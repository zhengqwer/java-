package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.service.ex.AccessDeniedException;
import cn.tedu.store.service.ex.CartNotFoundException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.vo.CartVO;

/**
 * 加入购物车的业务层接口
 * @author soft01
 *
 */
public interface ICartService {
	
	/**
	 * 将商品加入购物车
	 * @param cart 购物车中的商品数据
	 * @param username 当前操作修改人 
	 * @throws InsertException
	 * @throws UpdateException
	 */
	void addToCart(Cart cart,String username) throws InsertException,UpdateException;
	
	/**
	 * 显示某用户的购物车商品数据
	 * @param uid 用户id
	 * @return 匹配的购物车数据
	 */
	List<CartVO> getByUid(Integer uid);
	
	/**
	 * 根据cid和uid查询购物车中商品信息
	 * @param cids 若干个商品id
	 * @return 匹配的购物车中数据
	 * @throws AccessDeniedException
	 */
	List<CartVO> getByCids(Integer[] cids) throws AccessDeniedException;
	
	/**
	 * 增加购物车中商品数量
	 * @param cid 商品id
	 * @param uid 当前登录的用户id
	 * @param username 当前登录的用户名
	 * @return 增加之后的购物车商品数量
	 * @throws CartNotFoundException
	 * @throws AccessDeniedException
	 * @throws UpdateException
	 */
	Integer addNum(Integer cid,Integer uid,String username)throws CartNotFoundException,AccessDeniedException,UpdateException;
	
}
