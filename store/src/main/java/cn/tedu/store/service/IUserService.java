package cn.tedu.store.service;


import cn.tedu.store.entity.User;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.PasswordNotmatchException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameDuplicateException;
/**
 * 处理用户数据的业务层接口
 * @author soft01
 *
 */
public interface IUserService {
	
	/**
	 * 用户注册
	 * @param user 将要注册的用户数据
	 * @throws UsernameDuplicateException
	 * @throws InsertException
	 */
	void reg(User user) throws UsernameDuplicateException,InsertException;
	
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 用户密码
	 * @return 成功登录的用户信息 uid,password,salt,avatar,username,is_delete AS isDelete
	 * @throws UserNotFoundException
	 * @throws PasswordNotmatchException
	 */
	User login(String username,String password) throws UserNotFoundException,PasswordNotmatchException;
	
	/**
	 * 修改用户密码
	 * @param uid 用户的uid
	 * @param oldPassword 旧密码
	 * @param newPassword 修改后的密码，新密码
	 * @param username 当前登录的用户名
	 * @throws UserNotFoundException
	 * @throws PasswordNotmatchException
	 * @throws UpdateException
	 */
	void changePassword(Integer uid,String username,String oldPassword,String newPassword)throws UserNotFoundException,PasswordNotmatchException,UpdateException;
	
	/**
	 * 修改用户个人信息
	 * @param user 将要修改的用户数据
	 * @throws UserNotFoundException
	 * @throws	UpdateException
	 */
	void changeInfo(User user) throws UserNotFoundException,UpdateException;
	
	/**
	 * 更新用户头像
	 * @param uid 用户uid
	 * @param avatar 上传头像路径
	 * @param username 当前登录的用户的用户名
	 * @throws UserNotFoundException
	 * @throws UpdateException
	 */
	void changeAvatar(Integer uid,String avatar,String username) throws UserNotFoundException,UpdateException;
	
	/**
	 * 获取用户修改的用户数据
	 * @param uid 用户uid
	 * @return 用户修改的用户数据
	 */
	User getByUid(Integer uid) throws UserNotFoundException;
}
