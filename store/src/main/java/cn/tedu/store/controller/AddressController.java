package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.util.ResponseResult;
/**
 * 用于处理用户收货地址的控制器层
 * @author soft01
 *
 */
@RestController
@RequestMapping("addresses")
public class AddressController extends BaseController {
	
	@Autowired
	private IAddressService addressService;
	
	@RequestMapping("addnew")
	public ResponseResult<Void> addnew(Address address,HttpSession session){
		Integer uid = getUidFromSession(session);
		address.setUid(uid);
		String username = session.getAttribute("username").toString();
		addressService.addnew(address, username);
		return new ResponseResult<>(SUCCESS);
	}
	
	@GetMapping("/")
	public ResponseResult<List<Address>> getByUid(HttpSession session){
		Integer uid = getUidFromSession(session);
		List<Address> data = addressService.getByUid(uid);
		return new ResponseResult<>(SUCCESS,data);
	}
	
	//RestFull分格API设置
	@RequestMapping("/{aid}/set_default")
	public ResponseResult<Void> setDefault(@PathVariable("aid") Integer aid,HttpSession session){
		Integer uid = getUidFromSession(session);
		String username = session.getAttribute("username").toString();
		
		addressService.setDefault(aid, uid, username);
		return new ResponseResult<>(SUCCESS);
	}
	
	@RequestMapping("/{aid}/delete")
	public ResponseResult<Void> delete(@PathVariable("aid")Integer aid,HttpSession session){
		
		Integer uid = getUidFromSession(session);
		String username = session.getAttribute("username").toString();
		
		addressService.deleteByAid(aid, uid, username);
		return new ResponseResult<>(SUCCESS);
	}
	
	@RequestMapping("change_info")
	public ResponseResult<Void> changeInfo(Address address,HttpSession session){
		String username = session.getAttribute("username").toString();
		
		address.setModifiedUser(username);
		
		addressService.changeInfo(address);
		return new ResponseResult<>(SUCCESS);
		
	}

}
