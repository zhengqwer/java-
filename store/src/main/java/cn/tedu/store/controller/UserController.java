package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.upload.ex.FileEmptyException;
import cn.tedu.store.upload.ex.FileIoException;
import cn.tedu.store.upload.ex.FileSizeException;
import cn.tedu.store.upload.ex.FileStateException;
import cn.tedu.store.upload.ex.FileTypeException;
import cn.tedu.store.util.ResponseResult;
/**
 * 处理用户数据的控制器层
 * @author soft01
 *
 */
@RestController
@RequestMapping("users")
public class UserController extends BaseController{
		
	@Autowired
	private IUserService userService;
	
	@PostMapping("reg")
	public ResponseResult<Void> reg(User user){
		//执行注册
		userService.reg(user);
		//返回成功
		return new ResponseResult<>(SUCCESS);
	}
	
	@PostMapping("login")
	public ResponseResult<User> login(String username,String password,HttpSession session){
		//执行登录
		User result = userService.login(username, password);
		//将uid和username放到session中
		session.setAttribute("uid", result.getUid());
		session.setAttribute("username", result.getUsername());
		//返回登录成功的数据对应数据
		return new ResponseResult<User>(SUCCESS,result);
	}
	
	@PostMapping("change_password")
	public ResponseResult<Void> changePassword(@RequestParam("old_password")String oldPassword,@RequestParam("new_password")String newPassword,HttpSession session){
		
		//取出session中的uid和usernaem
		Integer uid = getUidFromSession(session);
		String username = session.getAttribute("username").toString();
		//执行修改密码
		userService.changePassword(uid, username, oldPassword, newPassword);
		//返回修改成功
		return new ResponseResult<>(SUCCESS);
	}
	
	@PostMapping("change_info")
	public ResponseResult<Void> changeInfo(User user,HttpSession session){
		//获取uid
		Integer uid = getUidFromSession(session);
		//获取用户名
		String username = session.getAttribute("username").toString();
		//将uid和用户名封装到参数user对象中
		user.setUid(uid);
		user.setModifiedUser(username);
		//调用业务层对象执行修改个人资料
		userService.changeInfo(user);
		//返回操作成功
		return new ResponseResult<>(SUCCESS);
	}
	
	/**
	 * 上传文件的保存文件夹名
	 */
	public static final String UPLOAD_DIR = "upload";
	
	/**
	 * 上传文件最大值
	 */
	public static final long UPLOAD_AVATAR_MAX_SIZE = 1 * 1024 * 1024;
	
	public static final List<String> UPLOAD_AVATAR_TYPES = new ArrayList<String>();
	
	static {
		UPLOAD_AVATAR_TYPES.add("image/png");
		UPLOAD_AVATAR_TYPES.add("image/jpeg");
	}
	
	@PostMapping("change_avatar")
	public ResponseResult<String> changeAvatar(HttpServletRequest request,@RequestParam("avatar") MultipartFile avatar,HttpSession session){
		
		//检查是否选择了有效文件提交的请求
		if(avatar.isEmpty()) {
			//抛出异常:FileEmptyException
			throw new FileEmptyException("上传头像失败，上传文件无效，请重新选择文件！！！");
		}
		
		//检查文件大小
		long size = avatar.getSize();
		if(size > UPLOAD_AVATAR_MAX_SIZE) {
			//抛出异常:FileSizeException
			throw new FileSizeException("上传头像失败，上传文件超过指定大小"+UPLOAD_AVATAR_MAX_SIZE / 1024 + "KB" +"，请重新选择文件！！！");
		}
		
		//检查文件类型
		String contentType = avatar.getContentType();
		if(!UPLOAD_AVATAR_TYPES.contains(contentType)) {
			//抛出异常:FileTypeException
			throw new FileTypeException("上传头像失败,上传文件类型不匹配异常"+UPLOAD_AVATAR_TYPES.toString()+"，请重新选择文件！！！");
		}
		
		//确定保存到那个文件夹
		String parentPath = request.getServletContext().getRealPath(UPLOAD_DIR);
		File parent = new File(parentPath);
		//判断文件是否存在
		if(!parent.exists()) {
			parent.mkdirs();
		}
		//获取文件名
		String originalFilename = avatar.getOriginalFilename();
		String suffix = "";
		int beginIndex = originalFilename.lastIndexOf(".");
		//判断文件是否有后缀名
		if(beginIndex != -1) {
			suffix = originalFilename.substring(beginIndex);
		}
		//上传文件全名
		String child = UUID.randomUUID().toString() + suffix;
		//确定保存到那个文件
		File dest = new File(parent,child);
			try {
				//保存头像文件
				avatar.transferTo(dest);
			} catch (IllegalStateException e) {
				//抛出异常
				throw new FileStateException("文件上传失败，所选文件不可用，请联系管理员！！！");
				
			} catch (IOException e) {
				//抛出异常
				throw new FileIoException("文件上传中断，读写文件失败，请联系管理员！！！");
			}

		//从session中获取uid和username
		Integer uid = getUidFromSession(session);
		String username = session.getAttribute("username").toString();
		//执行修改头像
		String avatarPath = "/" + UPLOAD_DIR + "/" + child;
		userService.changeAvatar(uid,avatarPath, username);
		//返回上传头像数据
		ResponseResult<String> rr = new ResponseResult<String>();
		rr.setState(SUCCESS);
		rr.setData(avatarPath);
		return rr;
	}
	
	@GetMapping("details")
	public ResponseResult<User> getByUid(HttpSession session){
		//获取uid
		Integer uid = getUidFromSession(session);
		//调用业务层对象执行获取数据
		User data = userService.getByUid(uid);
		//返回操作成功及数据
		return new ResponseResult<>(SUCCESS,data);
	}
}
