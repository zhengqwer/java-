package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.util.ResponseResult;
import cn.tedu.store.vo.CartVO;

/**
 * 用于处理购物车商品数据的控制器层
 * @author soft01
 *
 */
@RestController
@RequestMapping("carts")
public class CartController extends BaseController {

	@Autowired
	private ICartService cartService;
	
	@RequestMapping("add_to_cart")
	public ResponseResult<Void> addToCart(Cart cart,HttpSession session){
		//从session获取uid和username
		Integer uid = getUidFromSession(session);
		String username = session.getAttribute("username").toString();
		//将uid封装到参数cart中
		cart.setUid(uid);
		//执行业务层对象加入购物车功能
		cartService.addToCart(cart, username);
		//响应成功
		return new ResponseResult<>(SUCCESS);
	}
	
	@GetMapping("/")
	public ResponseResult<List<CartVO>> getByUid(HttpSession session){
		Integer uid = getUidFromSession(session);
		List<CartVO> data = cartService.getByUid(uid);
		return new ResponseResult<>(SUCCESS,data);
	}
	
	@RequestMapping("{cid}/add_num")
	public ResponseResult<Integer> addNum(@PathVariable("cid")Integer cid,HttpSession session){
		Integer uid = getUidFromSession(session);
		String username = session.getAttribute("username").toString();
		Integer num = cartService.addNum(cid, uid, username);
		return new ResponseResult<>(SUCCESS,num);
	}
	
	@GetMapping("get_by_cids")
	public ResponseResult<List<CartVO>> getByCids(Integer[] cids){
		List<CartVO> data = cartService.getByCids(cids);
		return new ResponseResult<>(SUCCESS,data);
	}
}
