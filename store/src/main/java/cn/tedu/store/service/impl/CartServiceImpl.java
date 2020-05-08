package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.ex.AccessDeniedException;
import cn.tedu.store.service.ex.CartNotFoundException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.vo.CartVO;
/**
 * 处理购物车商品数据业务层的实现类
 * @author soft01
 *
 */
@Service
public class CartServiceImpl implements ICartService {
	
	@Autowired
	private CartMapper cartMapper;

	@Override
	@Transactional
	public void addToCart(Cart cart,String username) throws InsertException , UpdateException{
		//根据参数cart中的uid和gid执行查询
		Integer uid = cart.getUid();
		Long gid = cart.getGid();
		Cart result = findByUidAndGid(uid, gid);
		Date now = new Date();
		//判断查询结果是否为null
		if(result == null) {//第一次执行添加数据
			cart.setCreatedUser(username);
			cart.setCreatedTime(now);
			cart.setModifiedUser(username);
			cart.setModifiedTime(now);
			addnew(cart);
		}else {//第二次执行修改商品数量+1
			Integer cid = result.getCid();
			Integer num = result.getNum();
			num += cart.getNum();
			updateNum(cid, num, username, now);
		}
		
	}
	
	@Override
	public Integer addNum(Integer cid, Integer uid, String username)
			throws CartNotFoundException, AccessDeniedException, UpdateException {
		Cart result = findByCid(cid);
		if(result == null) {
			throw new CartNotFoundException("增加商品数量失败，该数据不存在，请重试！！！");
		}
			if(result.getUid() != uid) {
				throw new AccessDeniedException("增加商品数量失败，该数据归属错误，拒绝访问！！！");
			}
			Integer newNum = result.getNum() + 1;
			Date now = new Date();
			updateNum(cid, newNum, username, now);
		return newNum;
	}
	
	@Override
	public List<CartVO> getByUid(Integer uid) {
		
		return findByUid(uid);
	}
	
	@Override
	public List<CartVO> getByCids(Integer[] cids) throws AccessDeniedException {
		
		return findByCids(cids);
	}
	
	
	/**
	 * 加入购物车
	 * @param cart 购物车数据
	 */
	private void addnew(Cart cart) {
		Integer rows = cartMapper.addnew(cart);
		if(rows != 1) {
			throw new InsertException("将商品加入购物车失败，插入此数据出现异常，请重试！！！");
		}
	}
	
	/**
	 * 修改商品数量
	 * @param cid 购物车数据id
	 * @param num 新的商品数量
	 * @param modifiedUser 修改人执行人
	 * @param modifedTime 修改时间
	 */
	private void updateNum(Integer cid,Integer num,String modifiedUser,Date modifiedTime) {
		Integer rows = cartMapper.updateNum(cid, num, modifiedUser, modifiedTime);
		if(rows != 1) {
			throw new UpdateException("将商品加入购物车失败，更新此数据出现异常，请重试");
		}
	}
	
	/**
	 * 显示某用户的购物车商品数据
	 * @param uid 用户id
	 * @return 匹配的购物车数据
	 */
	private List<CartVO> findByUid(Integer uid){
		return cartMapper.findByUid(uid);
	}
	
	/**
	 * 根据cid和uid查询购物车中商品信息
	 * @param cids 若干个商品id
	 * @return 匹配的购物车中数据
	 */
	private List<CartVO> findByCids(Integer[] cids){
		return cartMapper.findByCids(cids);
	}
	
	/**
	 * 根据用户id和商品id查询购物车数据
	 * @param uid 用户id
	 * @param gid 商品id
	 * @return 匹配的购物车数据
	 */
	private Cart findByUidAndGid(Integer uid,Long gid) {
		return cartMapper.findByUidAndGid(uid, gid);
	}

	/**
	 * 检查购物车商品数据是否存在
	 * @param cid 商品id
	 * @return 购物车中商品数据
	 */
	private Cart findByCid(Integer cid) {
		return cartMapper.findByCid(cid);
	}

}
