package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ExceptionHandler;

import cn.tedu.store.service.ex.AccessDeniedException;
import cn.tedu.store.service.ex.AddressNotFoundException;
import cn.tedu.store.service.ex.CartNotFoundException;
import cn.tedu.store.service.ex.DeleteException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.PasswordNotmatchException;
import cn.tedu.store.service.ex.ServiceException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameDuplicateException;
import cn.tedu.store.upload.ex.FileEmptyException;
import cn.tedu.store.upload.ex.FileIoException;
import cn.tedu.store.upload.ex.FileSizeException;
import cn.tedu.store.upload.ex.FileStateException;
import cn.tedu.store.upload.ex.FileTypeException;
import cn.tedu.store.upload.ex.FileUploadException;
import cn.tedu.store.util.ResponseResult;
/**
 * 控制器的基类
 * @author soft01
 *
 */
public abstract class BaseController {
	
	/**
	 * 响应结果时用于表示操作成功	
	 */
	protected static final int SUCCESS = 200;
	
	/**
	 * 获取session中的uid
	 * @param session  HttpSession
	 * @return 返回取出当前用户登录uid
	 */
	protected final Integer getUidFromSession(HttpSession session) {
		
		return Integer.valueOf(session.getAttribute("uid").toString());
	}
	
	@ExceptionHandler({ServiceException.class,FileUploadException.class})
	public ResponseResult<Void> handleException(Throwable e) {
		
		ResponseResult<Void> rr = new ResponseResult<>();
		rr.setMessage(e.getMessage());
		
		if(e instanceof UsernameDuplicateException) {
			//400-用户名冲突异常
			rr.setState(400);
		}else if(e instanceof InsertException) {
			//500-插入数据异常
			rr.setState(500);
		}else if(e instanceof UserNotFoundException) {
			//401-尝试访问的用户数据不存在
			rr.setState(401);
		}else if(e instanceof PasswordNotmatchException) {
			//402-验证密码失败，密码错误
			rr.setState(402);
		}else if(e instanceof UpdateException) {
			//501-修改密码失败
			rr.setState(501);
		}else if(e instanceof FileEmptyException) {
			//600-上传文件失败
			rr.setState(600);
		}else if(e instanceof FileIoException) {
			//601-上传文集中断
			rr.setState(601);
		}else if(e instanceof FileSizeException) {
			//602-上传文件大小超过最大值
			rr.setState(602);
		}else if(e instanceof FileStateException) {
			//603-文件上传状态异常
			rr.setState(603);
		}else if(e instanceof FileTypeException) {
			//604-上传文件类型不匹配
			rr.setState(604);
		}else if( e instanceof AccessDeniedException) {
			//403-非法绑定异常
			rr.setState(403);
		}else if(e instanceof AddressNotFoundException) {
			//404-查找不到地址数据异常
			rr.setState(404);
		}else if(e instanceof DeleteException) {
			//502-删除失败时发生此异常
			rr.setState(502);
		}else if(e instanceof CartNotFoundException) {
			//404-查找不到购物车数据异常
			rr.setState(405);
		}
		return rr;
	}
}
