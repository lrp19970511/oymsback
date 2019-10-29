package com.oyms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyms.mapper.GoodTypeMapper;
import com.oyms.mapper.GoodsMapper;
import com.oyms.model.GoodType;
import com.oyms.model.GoodTypeExample;
import com.oyms.model.Goods;
import com.oyms.model.GoodsExample;
import com.oyms.model.GoodsExample.Criteria;
@Service
public class GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private GoodTypeMapper goodTypeMapper;

    //商品管理方法
	public void addGoods(Goods goods) {
		goodsMapper.insert(goods);
	}
    //获取商品列表
	public List<Goods> getGoodsList() {
		GoodsExample goodsExample = new GoodsExample();
		Criteria criteria = goodsExample.createCriteria();
		criteria.andIsdeleteNotEqualTo((byte) 1);
		goodsExample.setOrderByClause("create_time desc");
		List<Goods> getGoods = goodsMapper.selectByExample(goodsExample);
		return getGoods;
	}
    //删除单个商品
	public int deleteOneGood(Long id) {
		Goods goods = new Goods();
		goods.setId(id);
		goods.setIsdelete((byte) 1);
		return goodsMapper.updateByPrimaryKeySelective(goods);
	}
    //修改商品信息
	public int modifyOneGood(Goods goods) {
		int isModify = goodsMapper.updateByPrimaryKey(goods);
		return isModify;
	}

	// 批量商品删除
	public Integer deleteList(String goodIdList) {
		Goods goods = new Goods();
		Integer isDelete = 0;
		// 将String分割成数组
		if (goodIdList != null && goodIdList != "") {
			goodIdList = goodIdList.replace("[", "").replace("]", "").replace(" ", "");
			String[] mutId = goodIdList.split(",");
			for (String a : mutId) {
				Long deleteId = Long.parseLong(a);
				goods.setId(deleteId);
				goods.setIsdelete((byte) 1);
				isDelete = goodsMapper.updateByPrimaryKeySelective(goods);
				if (isDelete == 0) {
					return isDelete;
				}
			}
		}
		return isDelete;
	}

	// 商品类型管理方法
	public void addType(GoodType goodtype) {
		goodTypeMapper.insert(goodtype);
	}

	public List<GoodType> getGoodTypes() {
		GoodTypeExample goodstypExample = new GoodTypeExample();
		com.oyms.model.GoodTypeExample.Criteria criteria = goodstypExample.createCriteria();
		goodstypExample.setOrderByClause("good_type asc");
		criteria.andIsdeleteNotEqualTo((byte) 1);
		List<GoodType> getData = goodTypeMapper.selectByExample(goodstypExample);
		return getData;
	}

}
