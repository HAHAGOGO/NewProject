package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pojo.Cart;
import com.pojo.FrontUser;
import com.pojo.SimpleCart;
import com.service.ICartService;
import com.service.IFrontUserService;
import com.utils.JsonUtil;



@Controller
@RequestMapping("cartCon")
public class CartController {
	private ICartService cartServiceImpl;
	@Resource(name = "frontService")
	private IFrontUserService frontService;
	@RequestMapping(value="insertCart",method=RequestMethod.POST)
	public void insertCart(String openid,Integer goodId,
			@RequestParam(defaultValue="1")Integer cartNumber,HttpServletResponse response){
		//传过来的cart包含userId，goodId的信息,cartNumber默认为1
		//需要先判断，购物车内是否已有了此商品
		Integer fontid = frontService.checkOpenID(openid);
		SimpleCart cart = new SimpleCart();
		cart.setUserId(fontid);
		cart.setGoodId(goodId);
		cart.setCartNumber(cartNumber);
		int status = 0;
		if(cartServiceImpl.isHaveGoodOfCart(cart)>0){
			status=1;
		}
		boolean flag=false;
		//有，则数量+1
		if(status>0){
			flag=cartServiceImpl.cartNumberAdd1(cart);
		}
		else{
		//没有则插入
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
	@RequestMapping(value="setCartNumber",method=RequestMethod.GET)
	public void goodOfCartSub1(String openid,Integer goodId,
			@RequestParam(defaultValue="1")Integer number,HttpServletResponse response){
		//设置商品数量
		Integer fontid = frontService.checkOpenID(openid);
		SimpleCart cart = new SimpleCart();
		cart.setUserId(fontid);
		cart.setGoodId(goodId);
		cart.setCartNumber(number);
		boolean flag = cartServiceImpl.setCartNumber(cart);
		try {
			PrintWriter writer = response.getWriter();
			writer.print(flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value="removeGoodOfCart",method=RequestMethod.GET)
	public void deleteGoodOfCart(String openid,Integer goodId,HttpServletResponse response){

		//移除商品
		Integer fontid = frontService.checkOpenID(openid);
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
	public void confirmGoodOfCart(String openid,Integer goodId,HttpServletResponse response){
		//勾选购物车商品
		Integer fontid = frontService.checkOpenID(openid);
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
	public void cancelGoodOfCart(String openid,Integer goodId,HttpServletResponse response){
		//取消打勾
		Integer fontid = frontService.checkOpenID(openid);
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
	public void selectCartOfUser(String openid,Integer goodId,HttpServletResponse response){
		//查询购物车里的商品信息
		response.setContentType("text/html;charset=utf-8");
		Integer fontid = frontService.checkOpenID(openid);
		FrontUser user = new FrontUser();
		user.setFrontid(fontid);
		List<Cart>list  = cartServiceImpl.selectCartOfUser(user);
		for (Cart cart : list) {
			cart.init();
		}
		try {
			PrintWriter writer = response.getWriter();
			String jsonCart= JsonUtil.arrayToJsonStr(list);
			writer.write(jsonCart);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="selectRealCartOfUser",method=RequestMethod.GET)
	public void selectRealCartOfUser(String openid,HttpServletResponse response){
		//查询已经勾选的商品在购物车显示
		response.setContentType("text/html;charset=utf-8");
		FrontUser user = new FrontUser();
		Integer fontid = frontService.checkOpenID(openid);
		user.setFrontid(fontid);
		List<Cart>list = cartServiceImpl.selectRealCartOfUser(user);
		for (Cart cart : list) {
			cart.init();
		}
		try {
			PrintWriter writer = response.getWriter();
			String jsonCart= JsonUtil.arrayToJsonStr(list);
			writer.write(jsonCart);
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

