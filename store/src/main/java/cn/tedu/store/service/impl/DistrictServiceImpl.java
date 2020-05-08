package cn.tedu.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.District;
import cn.tedu.store.mapper.DistrictMapper;
import cn.tedu.store.service.IDistrictService;
/**
 * 实现查看省市区的业务层接口的实现类
 * @author soft01
 *
 */
@Service
public class DistrictServiceImpl implements IDistrictService {
	
	@Autowired
	private DistrictMapper districtMapper;

	@Override
	public List<District> getByParent(String parent) {
		
		return findByParent(parent);
	}
	
	@Override
	public District getByCode(String code) {
		
		return findByCode(code);
	}
	
	/**
	 * 查询省市区数据
	 * @param parent 父代号
	 * @return 包括父代号的数据
	 */
	private List<District> findByParent(String parent){
		return districtMapper.findByParent(parent);
	}
	
	/**
	 * 根据省市区的代号查询详情
	 * @param code 代号
	 * @return 将省市区的代号封装的District中
	 */
	private District findByCode(String code) {
		return districtMapper.findByCode(code);
	}
	

}
