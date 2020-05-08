package cn.tedu.store.service;

import cn.tedu.store.entity.Order;
import cn.tedu.store.service.ex.InsertException;

/**
 * 处理生成订单数据和订单商品数据的业务层接口
 * @author soft01
 *
 */
public interface IOrderService {
	
	/**
	 * 增加订单信息
	 * @param aid 用户收货地址id
	 * @param cids 购物车中商品id
	 * @param uid 当前用户登录的uid
	 * @param username 当前用户登录的用户名
	 * @return 成功创建订单对象
	 * @throws InsertException
	 */
	Order create(Integer aid,Integer[] cids,Integer uid,String username) throws InsertException;
}
