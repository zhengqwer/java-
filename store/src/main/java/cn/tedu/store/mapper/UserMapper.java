package cn.tedu.store.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.User;
/**
 * 处理用户数据的持久层接口
 * @author soft01
 *
 */
public interface UserMapper {
	
	/**
	 * 插入用户数据
	 * @param user	 用户的数据
	 * @return		受影响的行数
	 */
	Integer insert(User user);
	
	/**
	 * 根据uid修改用户密码
	 * @param uid 用户数据uid
	 * @param password	用户密码
	 * @param modifiedUser 修改人
	 * @param modifiedTime 修改时间
	 * @return 受影响的行数
	 */
	Integer updatePassword(@Param("uid")Integer uid,@Param("password")String password,@Param("modifiedUser")String modifiedUser,@Param("modifiedTime")Date modifiedTime);
	
	/**
	 * 修改用户信息
	 * @param user 包含用户信息的数据
	 * @return	受影响的行数
	 */
	Integer updateInfo(User user);
	
	/**
	 * 更新用户头像
	 * @param uid 用户id
	 * @param avatar 用户头像路径
	 * @param modifiedUser 最后修改人
	 * @param modifiedTime 最后修改时间
	 * @return 受影响的行数
	 */
	Integer updateAvatar(@Param("uid")Integer uid,@Param("avatar")String avatar,@Param("modifiedUser")String modifiedUser,@Param("modifiedTime")Date modifiedTime );
	
	/**
	 * 根据用户名查询用户数据
	 * @param username 用户名
	 * @return	 包含用户名的一条数据
	 */
	User findByUsername(String username);
	
	/**
	 * 根据id查询数据
	 * @param uid 用户uid
	 * @return 包含用户uid的一条数据
	 */
	User findByUid(Integer uid);
	
	
}

