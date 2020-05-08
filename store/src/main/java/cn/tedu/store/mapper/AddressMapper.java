package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Address;
/**
 * 处理用户收货地址数据的持久层接口
 * @author soft01
 *
 */
public interface AddressMapper {
	
	/**
	 * 增加收货地址
	 * @param address 用户收货地址的数据
	 * @return 受影响的行数
	 */
	Integer insert(Address address);
	
	/**
	 * 删除用户收货地址
	 * @param aid 收货地址id
	 * @return 受影响的行数
	 */
	Integer deleteByAid(Integer aid);
	
	/**
	 * 设置为默认
	 * @param aid 收货地址id
	 * @param modifiedUser 最后修改人
	 * @param modifiedTime 最后修改时间
	 * @return 受影响的行数
	 */
	Integer updateDefault(@Param("aid")Integer aid,@Param("modifiedUser")String modifiedUser,@Param("modifiedTime")Date modifiedTime);
	
	/**
	 * 将其他的都设置为非默认
	 * @param uid 用户的uid
	 * @return 受影响的行数
	 */
	Integer updateNotDefault(Integer uid);
	
	/**
	 * 修改收货地址数据
	 * @param Address 包含收货地址数据
	 * @return 受影响的行数
	 */
	Integer updateInfo(Address address);
	
	/**
	 * 统计某用户收货地址数据
	 * @param uid 用户uid
	 * @return 包含用户uid的一条数据
	 */
	Integer countByUid(Integer uid);
	
	
	/**
	 * 显示收货地址
	 * @param uid 用户的uid
	 * @return 包含显示收货地址的一条数据
	 */
	List<Address> findByUid(Integer uid);
	
	
	/**
	 * 查询收货地址数据
	 * @param aid 收货地址id
	 * @return 带有收货地址的一条数据,如果没找到此数据，则返回null
	 */
	Address findByAid(Integer aid);
	
	/**
	 * 查询删除数据是否为默认地址,最后修改的一条数据
	 * @param uid 用户id
	 * @return 带用户id的一条数据
	 */
	Address findLastModified(Integer uid);
} 


