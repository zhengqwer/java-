package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Goods;

/**
 * 商品数据的业务层接口
 * @author soft01
 *
 */
public interface IGoodsService {
	
	/**
	 * 获取热销的前四项商品数据
	 * @return 前四项商品数据列表
	 */
	List<Goods> getHotList();
	
	/**
	 * 查询商品具体信息
	 * @param id 商品id
	 * @return 商品的具体信息
	 */
	Goods getById(Long id);
	
}
