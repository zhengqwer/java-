package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.ex.AccessDeniedException;
import cn.tedu.store.service.ex.AddressNotFoundException;
import cn.tedu.store.service.ex.DeleteException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UpdateException;

/**
 * 处理用户收货地址的业务层接口
 * @author soft01
 *
 */
public interface IAddressService {

	/**
	 * 用户增加收货地址
	 * @param address 将要增加的收货地址数据
	 * @param username 当前登录的用户名
	 * @throws InsertException
	 */
	void addnew(Address address,String username) throws InsertException;
	
	/**
	 * 显示收货地址
	 * @param uid 用户的uid
	 * @return 包含显示收货地址的一条数据
	 */
	List<Address> getByUid(Integer uid);
	
	/**
	 * 将指定收货地址修改设为默认地址
	 * @param aid 收货地址aid
	 * @param uid 用户uid
	 * @param username 修改用户名
	 * @throws AddressNotFoundException
	 * @throws UpdateException
	 */
	void setDefault(Integer aid,Integer uid,String username) throws AddressNotFoundException,UpdateException,AccessDeniedException;
	
	/**
	 * 删除指定aid的收货地址数据
	 * @param aid 收货地址id
	 * @param uid 当前登录的用户的uid
	 * @param username 当前登录的用户名
	 * @throws DeleteException
	 */
	void deleteByAid(Integer aid,Integer uid,String username) throws DeleteException,AddressNotFoundException,AccessDeniedException,UpdateException;

	/**
	 * 修改收货地址数据
	 * @param address 将要修改的数据
	 * @throws AddressNotFoundException
	 * @throws UpdateException
	 */
	void changeInfo(Address address) throws AddressNotFoundException,UpdateException;
	
	/**
	 * 查询用户地址数据
	 * @param aid 地址id
	 * @return 用户地址数据
	 */
	Address getByAid(Integer aid);
	
}

