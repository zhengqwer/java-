package cn.tedu.store.mapper;


import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;

/**
 * 处理订单和订单商品数据的持久层接口
 * @author zh
 *
 */
public interface OrderMapper {

	/**
	 * 插入订单数据
	 * @param order 订单数据
	 * @return 受影响的行数
	 */
	Integer insertOrder(Order order);
	
	/**
	 * 插入订单商品数据
	 * @param orderItem 订单商品数据
	 * @return 受影响的行数
	 */
	Integer insertOrderItem(OrderItem orderItem);
	
	/**
	 * 删除订单
	 * @param id 商品id
	 * @return 受影响得行数
	 */
	Integer deleteById(Integer id);
	
	/**
	 * 更改数量
	 * @param id 订单id
	 * @param num 商品数量
	 * @return 受影响得行数
	 */
	Integer updateByNum(@Param("id")Integer id,@Param("num")Integer num);
	
	/**
	 * 显示商品
	 * @param id 订单id
	 * @return 返回订单详情
	 */
	OrderItem findByid(Integer id);
}
