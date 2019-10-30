package com.oyms.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.oyms.dto.ApiDTO;
import com.oyms.model.GoodType;
import com.oyms.model.Goods;
import com.oyms.model.ParentType;
import com.oyms.service.GoodsService;

@RestController
@CrossOrigin
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private Goods goods;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private ApiDTO<Goods> apiDTO;
	@Autowired
	private ApiDTO<GoodType> apiDTO2;
	@Autowired
	private GoodType goodType;
	@Autowired
	private ParentType parentType;

	// 商品管理控制
	@PostMapping("/add")
	public ApiDTO<Goods> addGoods(@RequestBody JSONObject jsonObject) {

		String goodName = jsonObject.getString("goodName");
		String goodtype = jsonObject.getString("goodtype");
		Float goodprice = jsonObject.getFloat("goodprice");
		Long goodnum = jsonObject.getLong("goodnum");
		String gooddesc = jsonObject.getString("gooddesc");
		String goodImgUrl = jsonObject.getString("goodImgUrl");
		Date nowTime = new Date(System.currentTimeMillis());
		Long id = jsonObject.getLong("modifyId");
		goods.setGoodname(goodName);
		goods.setGoodtype(goodtype);
		goods.setGoodprice(goodprice);
		goods.setGoodimgurl(goodImgUrl);
		goods.setGoodnum(goodnum);
		goods.setGooddesc(gooddesc);
		goods.setIsdelete((byte) 0);
		goods.setCreateTime(nowTime);
		System.err.println(id);
		if (id == null || id.toString() == "") {
			try {
				goodsService.addGoods(goods);
				apiDTO.setIsSuccess(true);
				return apiDTO;
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			try {
				goods.setId(id);
				if (goodsService.modifyOneGood(goods) > 0) {
					apiDTO.setIsSuccess(true);
				}
				return apiDTO;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		apiDTO.setIsSuccess(false);
		return apiDTO;
	}

	@GetMapping("/show")
	public ApiDTO<Goods> showGoods() {
		try {
			apiDTO.setIsSuccess(true);
			apiDTO.setData(goodsService.getGoodsList());
			return apiDTO;
		} catch (Exception e) {
			// TODO: handle exception
		}
		apiDTO.setIsSuccess(false);

		return null;
	}

	@GetMapping("/isdelete")
	public ApiDTO<?> deleteOneGood(@RequestParam(value = "goodId", required = true) Long id) {
		if (goodsService.deleteOneGood(id) > 0) {
			apiDTO.setIsSuccess(true);
		} else {
			apiDTO.setIsSuccess(false);
		}
		return apiDTO;
	}

//	批量删除
	@PostMapping("/mutidelete")
	public ApiDTO<?> deleteList(@RequestBody JSONObject jsonObject) {
		String deleteGoodsList = jsonObject.getString("deleteIdList");
		if (goodsService.deleteList(deleteGoodsList) > 0) {
			apiDTO.setIsSuccess(true);
			return apiDTO;
		}
		apiDTO.setIsSuccess(false);
		return apiDTO;
	}

	// 商品类型控制
	// 添加商品类型
	@PostMapping("/addType")
	public ApiDTO<?> addType(@RequestBody JSONObject jsonObject) {
		String cname = jsonObject.getString("goodType");
		String pname = jsonObject.getString("parentType");
		if (pname != null && pname != "") {
			parentType.setPname(pname);
			parentType.setIsdelete((byte) 0);
			Integer pnameId = goodsService.addParentType(parentType);
			Date nowTime = new Date(System.currentTimeMillis());
			if (pnameId != null) {
				goodType.setCname(cname);
				goodType.setParentId(pnameId);
				goodType.setCreateTime(nowTime);
				goodType.setIsdelete((byte) 0);
				if (goodsService.addGoodType(goodType) > 0) {
					apiDTO.setIsSuccess(true);
					return apiDTO;
				}
			}
		}
		apiDTO.setIsSuccess(false);
		return apiDTO;

	}

	@GetMapping("/showType")
	public ApiDTO<GoodType> showGoodType() {
		List<GoodType> goodTypeList = goodsService.getParentList();
		apiDTO2.setData(goodTypeList);
		apiDTO2.setIsSuccess(true);
		return apiDTO2;
	}
}
