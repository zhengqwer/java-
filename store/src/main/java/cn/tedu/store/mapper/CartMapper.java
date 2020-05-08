package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.vo.CartVO;

/**
 * 处理购物车数据的持久层接口
 * @author soft01
 *
 */
public interface CartMapper {
	
	/**
	 * 加入购物车
	 * @param cart 购物车数据
	 * @return 受影响的行数
	 */
	Integer addnew(Cart cart);
	
	/**
	 * 修改商品数量
	 * @param cid 购物车数据id
	 * @param num 新的商品数量
	 * @param modifiedUser 修改人执行人
	 * @param modifedTime 修改时间
	 * @return 受影响的行数
	 */
	Integer updateNum(@Param("cid")Integer cid,@Param("num")Integer num,@Param("modifiedUser")String modifiedUser,@Param("modifiedTime")Date modifiedTime);
	
	/**
	 * 根据用户id和商品id查询购物车数据
	 * @param uid 用户id
	 * @param gid 商品id
	 * @return 匹配的购物车数据
	 */
	Cart findByUidAndGid(@Param("uid")Integer uid,@Param("gid")Long gid);
	
	/**
	 * 显示某用户的购物车商品数据
	 * @param uid 用户id
	 * @return 匹配的购物车数据
	 */
	List<CartVO> findByUid(Integer uid);
	
	/**
	 * 根据cid和uid查询购物车中商品信息
	 * @param cids 商品id
	 * @return 匹配的购物车中数据
	 */
	List<CartVO> findByCids(Integer[] cids);
	
	/**
	 * 根据cid查找购物车商品数据是否存在
	 * @param cid 商品id
	 * @return 购物车中商品数据
	 */
	Cart findByCid(Integer cid);
	
	
}
