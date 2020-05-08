package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.entity.District;

/**
 * 处理省/市/区的持久层接口
 * @author soft01
 *
 */
public interface DistrictMapper {
	
	/**
	 * 根据parent的值查询省市区数据
	 * @param parent t_dict_districr表中的parent值
	 * @return 查询的数据全国所有的省市区
	 */
	List<District> findByParent(String parent);
	
	/**
	 * 根据省市区的代号查询详情
	 * @param code 代号
	 * @return 将省市区的代号封装的District中
	 */
	District findByCode(String code);
}
