package cn.tedu.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Goods;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.service.IGoodsService;
/**
 * 实现业务层的实现类
 * @author soft01
 *
 */
@Service
public class GoodsServiceImpl implements IGoodsService {

	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public List<Goods> getHotList() {
		return findHotList();
	}
	
	@Override
	public Goods getById(Long id) {
		return findById(id);
	}
	
	/**
	 * 获取热销的前四项商品数据
	 * @return 前四项商品数据列表
	 */
	private List<Goods> findHotList(){
		return goodsMapper.findHotList();
	}

	/**
	 * 查询商品具体信息
	 * @param id 商品id
	 * @return 商品的具体信息
	 */
	private Goods findById(Long id) {
		return goodsMapper.findById(id);
	}

}
