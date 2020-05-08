package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.District;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.IDistrictService;
import cn.tedu.store.service.ex.AccessDeniedException;
import cn.tedu.store.service.ex.AddressNotFoundException;
import cn.tedu.store.service.ex.DeleteException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UpdateException;
/**
 * 实现用户收货地址业务层接口的实现类
 * @author soft01
 *
 */
@Service
public class AddressServiceImpl implements IAddressService{
	
	@Autowired
	private AddressMapper addressMapper;
	
	@Autowired
	private IDistrictService districtService;

	@Override
	public void addnew(Address address, String username) throws InsertException {
		// 根据参数address中的uid执行查询数量
		Integer count = countByUid(address.getUid());
	    // 判断收货地址数量是否为0
		// 将is_default的值封装到参数address中
		// 是：is_default > 1
		// 否：is_default > 0
		Integer isDefault = count == 0 ? 1 : 0;
		address.setIsDefault(isDefault);
		
		//获取省，市，区的名称
		String district = getDistrict(address.getProvince(), address.getCity(), address.getArea());
		address.setDistrict(district);
		
	    // 4项日志数据
		Date now = new Date();
		address.setCreatedUser(username);
		address.setCreatedTime(now);
		address.setModifiedUser(username);
		address.setModifiedTime(now);
	    // 执行增加
		insert(address);
		
	}
	
	@Override
	@Transactional
	public void deleteByAid(Integer aid, Integer uid, String username)
			throws DeleteException, AddressNotFoundException, AccessDeniedException, UpdateException {
		Address result = findByAid(aid);
		if(result == null) {
			throw new AddressNotFoundException("删除收货地址出现异常，请联系管理员！！！");
		}
		
			if(result.getUid() != uid) {
				throw new AccessDeniedException("删除此数据出现异常，拒绝访问！！！");
			}
			
			getdeleteByAid(aid);
			
				if(result.getIsDefault() == 1) {
					Integer rows = countByUid(uid);
					if(rows > 0) {
						Address address = getLastModified(uid);
						Integer lastModifiedAid = address.getAid();
						Date now = new Date();
						updateDefault(lastModifiedAid, username, now);
					}
				}
	}
	
	@Override
	@Transactional
	public void setDefault(Integer aid, Integer uid, String username) throws AddressNotFoundException, UpdateException {
		//查询收货地址数据
		Address result = findByAid(aid);
		//判断查询结果是否为null
		if(result == null) {
			throw new AddressNotFoundException("查询不到地址信息，请重试！！！");
		}
		//判断收货地址id是不是跟用户id匹配
		if(result.getUid() != uid) {
			throw new AccessDeniedException("设置默认收货地址失败，访问被拒绝！！！");
		}
		//将参数uid的数据不是默认的全部修改为0
		updateNotDefault(uid);
		//修该参数aid设为默认收货地址
		Date now = new Date();
		updateDefault(aid, username, now);
		
	}
	
	@Override
	public List<Address> getByUid(Integer uid) {
		
		return findByUid(uid);
	}
	
	@Override
	public Address getByAid(Integer aid) {
		
		return findByAid(aid);
	}
	
	
	/**
	 * 显示收货地址
	 * @param uid 用户的uid
	 * @return 包含显示收货地址的一条数据
	 */
	private List<Address> findByUid(Integer uid){
		return addressMapper.findByUid(uid);
	}
	
	/**
	 * 增加收货地址
	 * @param address 用户收货地址的数据
	 * @return 受影响的行数
	 */
	private void insert(Address address) {
		Integer rows = addressMapper.insert(address);
		if(rows != 1) {
			throw new InsertException("增加收货地址时发生未知错误，请重试！！！");
		}
	}
	
	/**
	 * 删除用户收货地址
	 * @param aid 收货地址id
	 * @return 受影响的行数
	 */
	private void getdeleteByAid(Integer aid) {
		Integer rows = addressMapper.deleteByAid(aid);
		if(rows != 1) {
			throw new DeleteException("删除收货地址数据失败，请联系管理员！！！");
		}
	}
	
	/**
	 * 查询删除数据是否为默认地址
	 * @param uid 用户id
	 * @return 带用户id的一条数据
	 */
	private Address getLastModified(Integer uid) {
		return addressMapper.findLastModified(uid);
	}
	
	/**
	 * 修改设为默认地址
	 * @param aid 收货地址aid
	 * @param uid 用户uid
	 * @param username 修改用户名
	 * @throws AddressNotFoundException
	 * @throws UpdateException
	 */
	private void updateDefault(Integer aid,String modifiedUser,Date modifiedTime) {
		Integer rows = addressMapper.updateDefault(aid, modifiedUser, modifiedTime);
		if(rows != 1) {
			throw new UpdateException("修改默认地址信息失败！！！");
		}
	}
	
	/**
	 * 将其他的都设置为0
	 * @param uid 用户的uid
	 * @return 受影响的行数
	 */
	private void updateNotDefault(Integer uid) {
		Integer rows = addressMapper.updateNotDefault(uid);
		if(rows < 1) {
			throw new UpdateException("修改默认地址信息失败！！！");
		}
	}
	
	/**
	 * 查询收货地址数据
	 * @param aid 收货地址id
	 * @return 带有收货地址的一条数据
	 */
	private Address findByAid(Integer aid) {
		return addressMapper.findByAid(aid);
	}
	
	/**
	 * 统计某用户收货地址数据
	 * @param uid 用户uid
	 * @return 包含用户uid的一条数据
	 */
	private Integer countByUid(Integer uid) {
		return addressMapper.countByUid(uid);
	}
	
	/**
	 * 根据省，市，区的代号获取名称
	 * @param provinceCode 省的代号
	 * @param cityCode 市的代号
	 * @param areaCode 区的代号
	 * @return 地址名称
	 */
	private String getDistrict(String provinceCode,String cityCode,String areaCode) {
		
		StringBuffer result = new StringBuffer();
		
		District province = districtService.getByCode(provinceCode);
		District city = districtService.getByCode(cityCode);
		District area = districtService.getByCode(areaCode);
		
		if(province != null) {
			result.append(province.getName());
		}
		
		if(city != null) {
			result.append(city.getName());
		}
		
		if(area != null) {
			result.append(area.getName());
		}
		
		return result.toString();
	}

	
	@Override
	public void changeInfo(Address address) throws AddressNotFoundException, UpdateException {
		Address result = findByAid(address.getAid());
		if(result == null) {
			throw new AddressNotFoundException("该数据出现异常，修改失败，请联系管理员！！！");
		}
		Date now = new Date();
		address.setModifiedTime(now);
		updateInfo(address);
	}
	
	/**
	 * 修改收货地址数据
	 * @param Address 包含收货地址数据
	 * @return 受影响的行数
	 */
	private void updateInfo(Address address) {
		Integer rows = addressMapper.updateInfo(address);
		if(rows != 1) {
			throw new UpdateException("修改数据失败，请联系管理员！！！");
		}
	}




}
