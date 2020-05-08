package cn.tedu.store.mapper;

import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;

/**
 * 处理生成订单数据和订单商品数据的持久层接口
 * @author soft01
 *
 */
public interface OrderMapper {
	
	/**
	 * 插入订单数据
	 * @param order 用户的订单信息
	 * @return 受影响的行数
	 */
	Integer insert(Order order);
	
	/**
	 * 插入订单商品数据
	 * @param orderItem 用户的订单商品数据
	 * @return 受影响的行数
	 */
	Integer insertOrderItem(OrderItem orderItem);
}
