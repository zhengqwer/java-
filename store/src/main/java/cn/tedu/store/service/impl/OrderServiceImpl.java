package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;
import cn.tedu.store.mapper.OrderMapper;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.IOrderService;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.vo.CartVO;
/**
 * 处理生成订单数据和订单商品数据的业务层实现类
 * @author soft01
 *
 */
@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private IAddressService addressService;
	
	@Autowired
	private ICartService cartService;

	@Override
	@Transactional
	public Order create(Integer aid, Integer[] cids, Integer uid, String username) throws InsertException {
		Date now = new Date();
		
		Long totalPrice = 0L;
		List<CartVO> carts = cartService.getByCids(cids);
		for (CartVO cartVO : carts) {
			totalPrice = cartVO.getNum() * cartVO.getPrice();
		}
		
		Order order = new Order();
		order.setUid(uid);
		Address address = addressService.getByAid(aid);
		order.setTotal_price(totalPrice);
		order.setStatus(0);
		order.setOrder_time(now);
		order.setRecv_name(address.getName());
		order.setRecv_phone(address.getPhone());
		order.setRecv_address(address.getAddress() + address.getDistrict());
		order.setCreatedUser(username);
		order.setCreatedTime(now);
		order.setModifiedUser(username);
		order.setModifiedTime(now);
		insert(order);
		
		for (CartVO cartVO : carts) {
			OrderItem orderItem = new OrderItem();
			orderItem.setOid(order.getOid());
			orderItem.setGid(cartVO.getGid());
			orderItem.setGoods_title(cartVO.getTitle());
			orderItem.setGoods_image(cartVO.getImage());
			orderItem.setGoods_price(cartVO.getPrice());
			orderItem.setGoods_num(cartVO.getNum());
			orderItem.setCreatedUser(username);
			orderItem.setCreatedTime(now);
			orderItem.setModifiedUser(username);
			orderItem.setModifiedTime(now);
			insertOrderItem(orderItem);
		}
		return order;
	}
	
	/**
	 * 插入订单数据
	 * @param order 用户的订单信息
	 * @return 受影响的行数
	 */
	private void insert(Order order) {
		Integer rows = orderMapper.insert(order);
		if(rows != 1) {
			throw new InsertException("创建订单失败，插入订单数据出现异常,请重试！！！");
		}
	}
	
	/**
	 * 插入订单商品数据
	 * @param orderItem 用户的订单商品数据
	 * @return 受影响的行数
	 */
	private void insertOrderItem(OrderItem orderItem) {
		Integer rows = orderMapper.insertOrderItem(orderItem);
		if(rows != 1) {
			throw new InsertException("创建订单商品失败，插入订单商品数据出现异常，请重试！！！");
		}
	}

}
