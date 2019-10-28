package com.oyms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyms.mapper.GoodTypeMapper;
import com.oyms.mapper.GoodsMapper;
import com.oyms.model.GoodType;
import com.oyms.model.Goods;

@Service
public class GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private GoodTypeMapper goodTypeMapper;

//   商品管理方法
	public void addGoods(Goods goods) {
		goodsMapper.insert(goods);
	}

	public List<Goods> getGoodsList() {
		List<Goods> getData = goodsMapper.findAll();
		return getData;
	}

	public int deleteOneGood(Long id) {
		int isDelete = goodsMapper.deleteOneGood(id);
		return isDelete;
	}

	public int modifyOneGood(Goods goods) {
		int isModify = goodsMapper.updateByPrimaryKey(goods);
		return isModify;
	}

	// 商品类型管理方法
	public void addType(GoodType goodtype) {
		goodTypeMapper.insert(goodtype);
	}

	public List<GoodType> getGoodTypes() {
		List<GoodType> getData = goodTypeMapper.findAllType();
		return getData;
	}
}
