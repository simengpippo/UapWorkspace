package com.sgcc.uap.charger.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sgcc.uap.charger.services.IChargerService;
import com.sgcc.uap.charger.vo.ChargerVO;
import com.sgcc.uap.rest.annotation.ColumnRequestParam;
import com.sgcc.uap.rest.annotation.QueryRequestParam;
import com.sgcc.uap.rest.annotation.attribute.ViewAttributeData;
import com.sgcc.uap.rest.support.FormRequestObject;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.support.ViewMetaData;
import com.sgcc.uap.rest.support.WrappedResult;
import com.sgcc.uap.rest.utils.ViewAttributeUtils;
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory; 

/**
 * <b>概述</b>：<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author Administrator
 * @date 2017-09-20 15:57:15
 * @since 1.0
 */
@RestController
@Transactional
@RequestMapping("/charger")
public class ChargerController {
	private final static Logger logger = (Logger) LoggerFactory.getLogger(ChargerController.class);

	@Autowired
	private IChargerService chargerService;
	/**
	 * 根据id查询
	 * @param id
	 * @return 查询结果
	 */
	@RequestMapping(value = "/{id}")
	public WrappedResult getById(@PathVariable String id) {
		try {
			QueryResultObject result = chargerService.getChargerById(id);
			logger.info("查询成功"); 
			return WrappedResult.successWrapedResult(result);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return WrappedResult.failedWrappedResult(e.getMessage());
		}
	}
	/**
	 * 删除节点（包括所有子节点）
	 * 
	 * @param params
	 *            删除节点ID
	 * @return 删除结果
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public WrappedResult deleteByIds(@RequestBody IDRequestObject idObject) {
		try {

			chargerService.remove(idObject);
			logger.info("删除节点["+idObject+"]成功");  
			return WrappedResult.successWrapedResult(true);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return WrappedResult.failedWrappedResult(e.getMessage());
		}
	}
	/**
	 * 保存
	 * @param params
	 * @return 保存结果
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public WrappedResult saveOrUpdate(@RequestBody FormRequestObject<Map> params) {
		try {
			QueryResultObject result = new QueryResultObject();
			Map map = (Map) params.getItems().get(0);
			result.setFormItems(chargerService.saveCharger(map));
			logger.info("保存数据成功"); 
			return WrappedResult.successWrapedResult(result);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return WrappedResult.failedWrappedResult(e.getMessage());
		}
	}
	/**
	 * 查询
	 * @param requestCondition
	 * @return 查询结果
	 */
	@RequestMapping("/")
	public WrappedResult query(@QueryRequestParam("params") RequestCondition requestCondition) {

		try {
			QueryResultObject queryResult = chargerService.query(requestCondition);
			logger.info("查询数据成功"); 
			return WrappedResult.successWrapedResult(queryResult);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return WrappedResult.failedWrappedResult(e.getMessage());
		}
	}
	
	/**
	 * 从vo中获取页面展示元数据信息
	 * 
	 * @param columns
	 *            将请求参数{columns:["id","name"]}封装为字符串数组
	 * @return datas
	 */
	@RequestMapping("/meta")
	public 	WrappedResult getMetaData(
			@ColumnRequestParam("params") String[] columns) {
		try{
			List<ViewAttributeData> datas = null;
			datas = ViewAttributeUtils.getViewAttributes(columns, ChargerVO.class);
			WrappedResult wrappedResult = WrappedResult
					.successWrapedResult(new ViewMetaData(datas));
			return wrappedResult;
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			return WrappedResult.failedWrappedResult(e.getMessage());
		}
	}

}
