package com.sgcc.uap.charger.services;

import java.util.Map;

import com.sgcc.uap.charger.domain.Charger;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;

/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *
 * @author Administrator
 * @date 2017-09-20 15:57:15
 * @since 1.0
 */
public interface IChargerService {
	/**
	 * 根据主键 查询
	 * @param queryCondition
	 * @return
	 */
	public QueryResultObject getChargerById(String id);
	/**
	 * 根据idObject删除
	 * @param idObject
	 */
	public void remove(IDRequestObject idObject);
	/**
	 * 保存
	 * @param map
	 * @return
	 */
	public Charger saveCharger(Map map);
	/**
	 * 根据查询条件 查询
	 * @param queryCondition
	 * @return
	 */
	public QueryResultObject query(RequestCondition queryCondition);
}
