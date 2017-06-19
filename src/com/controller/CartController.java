package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.pojo.Cart;
import com.pojo.FrontUser;
import com.pojo.SimpleCart;
import com.service.ICartService;
import com.utils.JsonUtil;



@Controller
@RequestMapping("cartCon")
public class CartController {
	
	private ICartService cartServiceImpl;
	@RequestMapping(value="insertCart",method=RequestMethod.POST)
	public void insertCart(Integer fontid,Integer goodId,
			@RequestParam(defaultValue="1")Integer cartNumber,HttpServletResponse response){
		//��������cart����userId��goodId����Ϣ,cartNumberĬ��Ϊ1
		//��Ҫ���жϣ����ﳵ���Ƿ������˴���Ʒ
		SimpleCart cart = new SimpleCart();
		cart.setUserId(fontid);
		cart.setGoodId(goodId);
		cart.setCartNumber(cartNumber);
		int status = 0;
		if(cartServiceImpl.isHaveGoodOfCart(cart)>0){
			status=1;
		}
		boolean flag=false;
		//�У�������+1
		if(status>0){
			flag=cartServiceImpl.cartNumberAdd1(cart);
		}
		else{
		//û�������
		flag= cartServiceImpl.insertCart(cart);
		}
		try {
			PrintWriter writer = response.getWriter();
			writer.print(flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value="goodOfCartSub1",method=RequestMethod.GET)
	public void goodOfCartSub1(Integer fontid,Integer goodId,
			@RequestParam(defaultValue="1")Integer number,HttpServletResponse response){
		//���ﳵ��Ӧ��Ʒ-1
		SimpleCart cart = new SimpleCart();
		cart.setUserId(fontid);
		cart.setGoodId(goodId);
		cart.setCartNumber(number);
		boolean flag = cartServiceImpl.cartNumberSub1(cart);
		try {
			PrintWriter writer = response.getWriter();
			writer.print(flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value="removeGoodOfCart",method=RequestMethod.GET)
	public void deleteGoodOfCart(Integer fontid,Integer goodId,HttpServletResponse response){
		//�Ƴ���Ʒ
		SimpleCart cart = new SimpleCart();
		cart.setUserId(fontid);
		cart.setGoodId(goodId);
		boolean flag = cartServiceImpl.removreGoodOfCart(cart);
		try {
			PrintWriter writer = response.getWriter();
			writer.print(flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value="confirmGoodOfCart",method=RequestMethod.GET)
	public void confirmGoodOfCart(Integer fontid,Integer goodId,HttpServletResponse response){
		//��ѡ���ﳵ��Ʒ
		SimpleCart cart = new SimpleCart();
		cart.setUserId(fontid);
		cart.setGoodId(goodId);
		boolean flag = cartServiceImpl.confirmGoodOfCart(cart);
		try {
			PrintWriter writer = response.getWriter();
			writer.print(flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value="cancelGoodOfCart",method=RequestMethod.GET)
	public void cancelGoodOfCart(Integer fontid,Integer goodId,HttpServletResponse response){
		//ȡ����
		SimpleCart cart = new SimpleCart();
		cart.setUserId(fontid);
		cart.setGoodId(goodId);
		boolean flag = cartServiceImpl.cancelGoodOfCart(cart);
		try {
			PrintWriter writer = response.getWriter();
			writer.print(flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value="selectCartOfUser",method=RequestMethod.GET)
	public void selectCartOfUser(Integer fontid,Integer goodId,HttpServletResponse response){
		//��ѯ���ﳵ�����Ʒ��Ϣ
		FrontUser user = new FrontUser();
		user.setFrontid(fontid);
		Cart cart = cartServiceImpl.selectCartOfUser(user);
		cart.init();
		try {
			PrintWriter writer = response.getWriter();
			String jsonCart = JsonUtil.objectToJsonStr(cart);
			writer.write(jsonCart);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="selectRealCartOfUser",method=RequestMethod.GET)
	public void selectRealCartOfUser(Integer fontid,Integer goodId,HttpServletResponse response){
		//��ѯ�Ѿ���ѡ����Ʒ�ڹ��ﳵ��ʾ
		FrontUser user = new FrontUser();
		user.setFrontid(fontid);
		Cart cart = cartServiceImpl.selectRealCartOfUser(user);
		cart.init();
		try {
			PrintWriter writer = response.getWriter();
			String jsonStr = JsonUtil.objectToJsonStr(cart);
			writer.write(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public ICartService getCartServiceImpl() {
		return cartServiceImpl;
	}
	public void setCartServiceImpl(ICartService cartServiceImpl) {
		this.cartServiceImpl = cartServiceImpl;
	}
	
}

