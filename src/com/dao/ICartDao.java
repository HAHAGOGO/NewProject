package com.dao;

import com.pojo.Cart;
import com.pojo.FrontUser;
import com.pojo.SimpleCart;


public interface ICartDao {
	public boolean insertCart(SimpleCart cart);//���빺�ﳵ 
	public Cart selectCartOfUser(FrontUser user);//��ѯ
	public Cart selectRealCartOfUser(FrontUser user);//��ѯѡ�е���Ʒ
	public int isHaveGoodOfCart(SimpleCart cart);//�ж���Ʒ�Ƿ����ڹ��ﳵ
	public boolean cartNumberAdd1(SimpleCart cart);//��Ӧ���ﳵ��Ʒ+1
	public boolean cartNumberSub1(SimpleCart cart);//��Ӧ���ﳵ��Ʒ-1
	public boolean removreGoodOfCart(SimpleCart cart);//ɾ����Ӧ���ﳵ��Ʒ
	public boolean confirmGoodOfCart(SimpleCart cart);//ѡ�ж�Ӧ����Ʒ
	public boolean cancelGoodOfCart(SimpleCart cart);//ȡ��ѡ�ж�Ӧ����Ʒ
	public boolean removreGoodOfCartAfterOrder(Cart cart);//ȷ�϶�����ɾ�����ﳵ�ж�Ӧ��Ʒ
	
	
	
}
