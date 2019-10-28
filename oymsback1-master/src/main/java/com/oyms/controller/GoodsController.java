package com.oyms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
		System.err.println(id);
		if (goodsService.deleteOneGood(id) > 0) {
			apiDTO.setIsSuccess(true);
		} else {
			apiDTO.setIsSuccess(false);
		}
		return apiDTO;
	}

	//商品类型控制
	@PostMapping("/addType")
	public ApiDTO<?> addType(@RequestBody JSONObject jsonObject) {
		String goodTypeName = jsonObject.getString("goodType");
		String subType = jsonObject.getString("subType");
		Date nowTime = new Date(System.currentTimeMillis());
		goodType.setGoodType(goodTypeName);
		goodType.setSubType(subType);
		goodType.setIsdelete((byte) 0);
		goodType.setCreateTime(nowTime);
		try {
			goodsService.addType(goodType);
			apiDTO.setIsSuccess(true);
			return apiDTO;
		} catch (Exception e) {
			// TODO: handle exception
		}
		apiDTO.setIsSuccess(false);
		return apiDTO;
	}

	@GetMapping("/showType")
	public ApiDTO<GoodType> showGoodType() {
		try {
			apiDTO2.setIsSuccess(true);
			apiDTO2.setData(goodsService.getGoodTypes());
			return apiDTO2;
		} catch (Exception e) {
			// TODO: handle exception
		}
		apiDTO2.setIsSuccess(false);

		return null;
	}
}
