package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;
import cn.tedu.store.service.IOrderService;
import cn.tedu.store.util.ResponseResult;

@RestController
@RequestMapping("/orders")
public class OrderController extends BaseController {
	
	@Autowired
	private IOrderService orderService;
	
	@RequestMapping("/create")
	public ResponseResult<Order> createOrder(Integer aid,Integer[] cids,HttpSession session){
		
		Integer uid = getUidFromSession(session);
		String username = session.getAttribute("username").toString();
		Order data = orderService.creater(uid, username, aid, cids);
		return new ResponseResult<>(SUCCESS,data);
	}
	
	@RequestMapping("/{id}/remove")
	public ResponseResult<Void> delete(@PathVariable("id")Integer id,HttpSession session){
		Integer uid = getUidFromSession(session);
		orderService.delete(uid);
		return new ResponseResult<>(SUCCESS);
	}
	
	@RequestMapping("/{id}/change")
	public ResponseResult<Integer> update(@PathVariable("id")Integer id,HttpSession session){
		Integer uid = getUidFromSession(session);
		Integer num = orderService.changeNum(uid,1);
		return new ResponseResult<>(SUCCESS,num);
	}
	
	@RequestMapping("/{id}/findbyid")
	public ResponseResult<OrderItem> select(@PathVariable("id")Integer id,HttpSession session){
		Integer uid = getUidFromSession(session);
		OrderItem orderItem = orderService.findById(uid);
		return new ResponseResult<>(SUCCESS,orderItem);
	}
}
