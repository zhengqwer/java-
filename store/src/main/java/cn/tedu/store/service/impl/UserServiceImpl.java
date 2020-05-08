package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import cn.tedu.store.entity.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.PasswordNotmatchException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameDuplicateException;
/**
 * 实现用户业务层接口的实现类
 * @author soft01
 *
 */
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void reg(User user) throws UsernameDuplicateException, InsertException {
		
		User result = userMapper.findByUsername(user.getUsername());
		
		if(result == null) {
			//补充完善用户数据
			Date now = new Date();
			user.setIsDelete(0);
			user.setCreatedUser(user.getUsername());
			user.setCreatedTime(now);
			user.setModifiedUser(user.getUsername());
			user.setModifiedTime(now);
			// 生成随机盐
			String salt = UUID.randomUUID().toString();
			// 基于原密码和盐值执行加密
			String md5Password = getMd5Password(user.getPassword(), salt);
			// 将盐和加密结果封装到user对象中
			user.setSalt(salt);
			user.setPassword(md5Password);
			//执行注册
			Integer i = userMapper.insert(user);
			System.out.println(i);
			if(i != 1 ) {
				throw new InsertException("注册时发生未知错误，请联系系统管理员");
			}
		}else {
			throw new UsernameDuplicateException("尝试注册的用户名("+user.getUsername()+")已经存在");
		}
	}
	
	@Override
	public User login(String username, String password) throws UserNotFoundException, PasswordNotmatchException {
		
		User result = userMapper.findByUsername(username);
		//判断查询结果是否为null
		if(result == null) {
			throw new UserNotFoundException("用户名不存在，登录失败！！！");
		}
		//判断isDelete值是否为1
		if(result.getIsDelete() == 1) {
			throw new PasswordNotmatchException("密码已被锁住，登录失败！！！");
		}
		// 基于盐值和参数password执行加密
	    // 判断加密后的密码与查询结果中的密码是否不匹配
		String salt = result.getSalt();
		String md5password = getMd5Password(password, salt);
		if(!result.getPassword().equals(md5password)) {
			throw new PasswordNotmatchException("密码不匹配，登录失败！！！");
		}
		// 将查询结果中的salt, password, isDelete设置为null

		result.setSalt(null);
		result.setPassword(null);
		result.setIsDelete(null);
	    // 返回查询结果
		return result;
	}
	
	@Override
	public void changePassword(Integer uid, String username, String oldPassword, String newPassword)
			throws UserNotFoundException, PasswordNotmatchException, UpdateException {
		//根据参数uid查询用户数据
		User result = userMapper.findByUid(uid);
		// 判断查询结果是否为null
		if(result == null) {
			// 是：抛出UserNotFoundException
			throw new UserNotFoundException("修改失败，用户名不存在！！！");
		}
			// 判断查询结果中的isDelete是否为1
			if(result.getIsDelete() == 1) {
				 // 是：抛出UserNotFoundException
				throw new UserNotFoundException("修改失败，数据不存在！！！");
			}
		 // 取出查询结果中的盐值
		String salt = result.getSalt();
		// 基于参数oldPassword和盐值执行加密
		String oldMd5Password = getMd5Password(oldPassword, salt);
		// 判断加密结果与查询结果中的密码是否不匹配
		if(!oldMd5Password.equals(result.getPassword())) {
			// 是：抛出PasswordNotMatchException
			throw new PasswordNotmatchException("修改失败，原密码错误！！！");
		}
		
		// 基于参数newPassword和盐值执行加密
		String newMd5Password = getMd5Password(newPassword, salt);
	    // 创建当前时间对象，作为最后修改时间
		Date now = new Date();
		// 调用持久层执行更新密码（新密码是以上加密的结果），并获取返回值
		Integer rows = userMapper.updatePassword(uid, newMd5Password, username, now);
		// 判断返回值是否不为1
		if(rows != 1) {
			// 是：抛出UpdateException
			throw new UpdateException("修改失败，请联系管理员，给他打电话！！！");
		}
	}
	
	@Override
	public void changeInfo(User user) throws UserNotFoundException, UpdateException {
		// 从参数user中获取uid
	    // 调用持久层对象的方法，根据uid查询用户数据
		User result = userMapper.findByUid(user.getUid());
		// 判断查询结果是否为null
		if(result == null) {
		    // 是：抛出UserNotFoundException
			throw new UserNotFoundException("用户名不存在，修改失败！！！");
		}
			// 判断查询结果中的isDelete是否为1
			if(result.getIsDelete() == 1) {
			    // 是：抛出UserNotFoundException
				throw new UserNotFoundException("该条数据被删除，修改失败，请联系管理员！！！");
			}
			// 创建当前时间对象，封装到user中
			Date now = new Date();
			user.setModifiedTime(now);
			// 调用持久层对象执行修改，并获取返回值（即受影响的行数）
			Integer rows = userMapper.updateInfo(user);
			// 判断返回值是否不为1
			if(rows != 1) {
			    // 是：抛出UpdateException
				throw new UpdateException("修改失败，请联系管理员，给他打电话！！！");
			}
		
	}
	
	@Override
	public void changeAvatar(Integer uid, String avatar, String username)
			throws UserNotFoundException, UpdateException {
		// 调用持久层对象查询参数uid匹配的用户数据
		User result = userMapper.findByUid(uid);
		// 判断查询结果是否为null
		if(result == null) {
			// 是：抛出UserNotFoundException
			throw new UserNotFoundException("修改头像失败，查询失败！！！");
		}
		// 判断查询结果中的isDelete是否为1
			if(result.getIsDelete() == 1) {
				// 是：抛出UserNotFoundException
				throw new UserNotFoundException("修改头像失败，查询失败！！！");
			}
			// 创建当前时间对象，封装到user中
			Date now = new Date();
			// 调用持久层对象执行修改，并获取返回值（即受影响的行数）
			Integer rows = userMapper.updateAvatar(uid, avatar, username, now);
			// 判断返回值是否不为1
			if(rows != 1) {
				// 是：抛出UpdateException
				throw new UpdateException("修改错误，请联系管理员，给他打电话！！！");
			}
			
	}
	
	@Override
	public User getByUid(Integer uid) throws UserNotFoundException{
		// 调用持久层对象查询参数uid匹配的用户数据
		User result = userMapper.findByUid(uid);
		// 判断查询结果是否为null
		if(result == null) {
			throw new UserNotFoundException("用户名不存在，查询失败！！！");
		}
		 // 判断查询结果中的isDelete是否为1
			if(result.getIsDelete() == 1) {
				throw new UserNotFoundException("该条数据异常，查询失败！！！");
			}
			// 将查询结果中的password/salt/isDelete设置为null
			result.setPassword(null);
			result.setSalt(null);
			result.setIsDelete(null);
		// 返回查询结果	
		return result;
	}
	
	/**
	 * 将密码执行加密
	 * @param password 原密码
	 * @param salt	盐值
	 * @return	加密后的密码
	 */
	private String getMd5Password(String password,String salt) {
		String str = salt + password + salt;
		for (int i = 0; i < 5; i++) {
			str = DigestUtils.md5DigestAsHex(str.getBytes()).toUpperCase();
		}
		return str;	
	}



}
