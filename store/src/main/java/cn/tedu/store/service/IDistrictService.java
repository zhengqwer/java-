package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.District;
/**
 * 处理查看省市区数据的业务层接口
 * @author soft01
 *
 */
public interface IDistrictService {
	
	/**
	 * 查询省市区数据
	 * @param parent 父代号
	 * @return 包括父代号的数据
	 */
	List<District> getByParent(String parent);
	
	/**
	 * 根据省市区的代号查询详情
	 * @param code 代号
	 * @return 将省市区的代号封装的District中
	 */
	District getByCode(String code);
}
