package cn.tedu.store.service;

import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;
import cn.tedu.store.service.ex.InsertException;

/**
 * 创建订单的业务层接口
 * @author zh
 *
 */
public interface IOrderService {
	
	/**
	 * 创建订单
	 * @param uid 当前登录的用户id
	 * @param username 当前登录的用户的用户名
	 * @param aid 用户选择的收货地址id
	 * @param cids 用户创建即将购买的购物车数据的id
	 * @return 成功创建的订单对象
	 * @throws InsertException
	 */
	Order creater(Integer uid,String username,Integer aid,Integer[] cids) throws InsertException;
	
	/**
	 * 删除订单
	 * @param id 订单id
	 * @return 
	 */
	void delete(Integer id);
	
	/**
	 * 更改商品数量
	 * @param id 订单id
	 */
	Integer changeNum(Integer id,Integer num);
	
	/**
	 * 查看订单
	 * @param id 订单id
	 * @return 订单数据
	 */
	OrderItem findById(Integer id);
		
	
}
