package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.entity.Goods;

/**
 * 处理商品数据的持久层接口
 * @author soft01
 *
 */
public interface GoodsMapper {
	/**
	 * 获取热销的前四项商品数据
	 * @return 前四项商品数据列表
	 */
	List<Goods> findHotList();
	
	/**
	 * 查询商品具体信息
	 * @param id 商品id
	 * @return 商品的具体信息,如果没有匹配商品则返回null
	 */
	Goods findById(Long id);
}
