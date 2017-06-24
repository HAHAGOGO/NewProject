package com.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dao.IGoodImageDao;
import com.dao.IGoodInfoDao;
import com.dao.IGoodServiceRelaxDao;
import com.pojo.GoodImage;
import com.pojo.GoodInfo;
import com.service.IGoodInfoService;

@Service
public class GoodInfoServiceImpl implements IGoodInfoService {

	private IGoodInfoDao goodInfoDaoImpl;
	private IGoodServiceRelaxDao goodServiceRelaxDaoImpl;
	private IGoodImageDao goodImageDaoImpl;

	@Override
	public GoodInfo findByGoodId(Integer goodId) {
		return goodInfoDaoImpl.findByGoodId(goodId);
	}

	@Override
	public List<GoodInfo> findByStyleId(Integer styleId, Integer cp, Integer ps) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodInfo> findAll(Integer styleId, Integer cp, Integer ps) {
		if (cp == null || cp < 1) {
			cp = 1;
		}
		if (ps == null || ps < 1) {
			ps = 1;
		}
		Map<String, Integer> map = new HashMap<>();
		map.put("styleId", styleId);
		map.put("start", (cp - 1) * ps);
		map.put("ps", ps);
		return goodInfoDaoImpl.findAll(map);
	}

	@Override
	public Integer addGood(GoodInfo goodInfo, String[] serviceId, HttpServletRequest req) {
		Integer count = goodInfoDaoImpl.getCount(null);
		Integer id=count+1;
		goodInfo.setGoodId(id);
		GoodInfo g = saveImg(goodInfo, req);
		Integer goodId = goodInfoDaoImpl.addGood(g);
		saveFile(id, req);
		if (goodId < 0) {
			return -1;
		}
		if (serviceId!=null&&serviceId.length>0) {
			for (int i = 0; i < serviceId.length; i++) {
				boolean flag = goodServiceRelaxDaoImpl.insertRelax(goodId, Integer.valueOf(serviceId[i]));
				if (!flag) {
					return -1;
				}
			}
		}
		
		return goodId;
	}

	@Override
	public boolean updateGood(GoodInfo goodInfo, String[] serviceId, HttpServletRequest req) {
		Integer goodId = goodInfo.getGoodId();
		//删除图片文件
		deleteFile(goodId, req);
		
		//删除商品图片表相关数据
		goodImageDaoImpl.deleteImage(goodId);
		
		//重新写入文件并保存数据库
		saveFile(goodId, req);
		//删除关系表相关数据
		goodServiceRelaxDaoImpl.deleteRelax(goodId);
		
		//插入关系表相关数据
		if (serviceId!=null&&serviceId.length>0) {
			for (int i = 0; i < serviceId.length; i++) {
				boolean flag = goodServiceRelaxDaoImpl.insertRelax(goodId, Integer.valueOf(serviceId[i]));
				if (!flag) {
					System.out.println("添加关系表相关数据失败了");
					return false;
				}
			}
		}
		GoodInfo g = saveImg(goodInfo, req);
		//修改商品信息相关数据
		boolean updateFlag = goodInfoDaoImpl.updateGood(g);
		if (updateFlag) {
			return true;
		}
		System.out.println("修改商品信息相关数据失败了");
		return false;
	}

	@Override
	public boolean deleteGood(Integer goodId,HttpServletRequest req) {
		List<GoodImage> goodImageByGoodId = goodImageDaoImpl.getGoodImageByGoodId(goodId);
		String path = req.getServletContext().getRealPath("/");
		for (int i = 0; i < goodImageByGoodId.size(); i++) {
			File file = new File(path+"/"+goodImageByGoodId.get(i).getPicPath());
			if (file.exists()) {
				file.delete();
			}
		}
		boolean deleteFlag = goodServiceRelaxDaoImpl.deleteRelax(goodId);
		if (!deleteFlag) {
			return false;
		}
		boolean deleteImage = goodImageDaoImpl.deleteImage(goodId);
		if (!deleteImage) {
			return false;
		}
		return goodInfoDaoImpl.deleteGood(goodId);
	}

	@Override
	public boolean deleteAll(Integer[] delId,HttpServletRequest req) {
		boolean flag = goodServiceRelaxDaoImpl.deleteAll(delId);
		if (!flag) {
			return false;
		}
		String path = req.getServletContext().getRealPath("/");
		for (int i = 0; i < delId.length; i++) {
			List<GoodImage> goodImageByGoodId = goodImageDaoImpl.getGoodImageByGoodId(delId[i]);
			for (int j = 0; j < goodImageByGoodId.size(); i++) {
				File file = new File(path+"/"+goodImageByGoodId.get(j).getPicPath());
				if (file.exists()) {
					file.delete();
				}
			}
			boolean deleteImage = goodImageDaoImpl.deleteImage(delId[i]);
			if (!deleteImage) {
				return false;
			}
		}
		return goodInfoDaoImpl.deleteAll(delId);
	}

	@Override
	public Integer getCount(Integer styleId) {
		return goodInfoDaoImpl.getCount(styleId);
	}

	/**
	 * 保存商品详情表的图片路径
	 * 
	 * @param n
	 * @param req
	 * @return
	 */
	private GoodInfo saveImg(GoodInfo g, HttpServletRequest req) {
		MultipartHttpServletRequest mhr = (MultipartHttpServletRequest) req;
		List<MultipartFile> files = mhr.getFiles("pic");
		String originalFilename = files.get(0).getOriginalFilename();
		String[] split = originalFilename.split("\\.");
		String fileName = DigestUtils.md5Hex(split[0])+"."+split[1];
		g.setGoodPicPath("image/goods/" + fileName);
		return g;
	}
	/**
	 * 写入图片
	 * @param g
	 * @param req
	 */
	private boolean saveFile(Integer goodId, HttpServletRequest req) {
		try {
			MultipartHttpServletRequest mhr = (MultipartHttpServletRequest) req;
			String realpath = mhr.getServletContext().getRealPath("image/goods");
			List<MultipartFile> files = mhr.getFiles("pic");
			for (int i = 0; i < files.size(); i++) {
				MultipartFile pic = files.get(i);
				if (pic.isEmpty()) {
					continue;
				}
				String originalFilename = pic.getOriginalFilename();
				String[] split = originalFilename.split("\\.");
				String fileName = DigestUtils.md5Hex(split[0])+"."+split[1];
				File file = new File(realpath + "/" + fileName);
				FileCopyUtils.copy(pic.getInputStream(), new FileOutputStream(file));
				
				GoodImage goodImage = new GoodImage();
				goodImage.setGoodId(goodId);
				goodImage.setPicPath("image/goods/" + fileName);
				goodImage.setPicStatus("1");
				boolean imgFlag = goodImageDaoImpl.addImage(goodImage);
				if (!imgFlag) {
					return false;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("图片保存出错了:"+"FileNotFound错误");
		} catch (IOException e) {
			System.out.println("图片保存出错了"+"IO错误");
		}
		return true;
	}
	private void deleteFile(Integer goodId, HttpServletRequest req){
		List<GoodImage> goodImageByGoodId = goodImageDaoImpl.getGoodImageByGoodId(goodId);
		MultipartHttpServletRequest mhr = (MultipartHttpServletRequest) req;
		String realpath = mhr.getServletContext().getRealPath("/");
		for (int i = 0; i < goodImageByGoodId.size(); i++) {
			GoodImage goodImage = goodImageByGoodId.get(i);
			String picPath = goodImage.getPicPath();
			File file = new File(realpath+"/"+picPath);
			if (file.exists()) {
				boolean delete = file.delete();
				if (delete) {
					System.out.println("删除成功");
				}
			}
		}
	}

	public IGoodImageDao getGoodImageDaoImpl() {
		return goodImageDaoImpl;
	}

	public void setGoodImageDaoImpl(IGoodImageDao goodImageDaoImpl) {
		this.goodImageDaoImpl = goodImageDaoImpl;
	}

	public IGoodInfoDao getGoodInfoDaoImpl() {
		return goodInfoDaoImpl;
	}

	public void setGoodInfoDaoImpl(IGoodInfoDao goodInfoDaoImpl) {
		this.goodInfoDaoImpl = goodInfoDaoImpl;
	}

	public IGoodServiceRelaxDao getGoodServiceRelaxDaoImpl() {
		return goodServiceRelaxDaoImpl;
	}

	public void setGoodServiceRelaxDaoImpl(IGoodServiceRelaxDao goodServiceRelaxDaoImpl) {
		this.goodServiceRelaxDaoImpl = goodServiceRelaxDaoImpl;
	}

}
