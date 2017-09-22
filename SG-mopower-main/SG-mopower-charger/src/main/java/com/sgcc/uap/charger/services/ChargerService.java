package com.sgcc.uap.charger.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sgcc.uap.charger.domain.Charger;
import com.sgcc.uap.charger.repositories.ChargerRepository;
import com.sgcc.uap.rest.support.DicItems;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryFilter;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.utils.CrudUtils;
import com.sgcc.uap.rest.utils.RestUtils;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
@Service
public class ChargerService  implements IChargerService{

	
	@Value("${spring。manufacturer}")
	private String manufacturer = "";
	
//	@Value("${spring。stationid}")
//	private String stationid = "";	
	
	@Value("${spring.batterytype}")
	private String batterytype = "";
	
	@Autowired 
	private ChargerRepository chargerRepository;
	
	@Override
	public QueryResultObject getChargerById(String id) {
		Charger charger = chargerRepository.findOne(id);
		List<DicItems>dictList = RestUtils.wrapDictList("manufacturer", manufacturer);
//		List<DicItems>dictList1 = RestUtils.wrapDictList("stationid", stationid);
		List<DicItems>dictList2 = RestUtils.wrapDictList("batterytype", batterytype);
		return RestUtils.wrappQueryResult(charger).addDicItems(dictList).addDicItems(dictList2);
	} 
	@Override
	public void remove(IDRequestObject idObject) {
		String[] ids = idObject.getIds();
		for (String id : ids)
			chargerRepository.delete(id);
	}
	@Override
	public Charger saveCharger(Map map) {
		
		Charger charger = new Charger();
		if (map.containsKey("id")) {
			
			try {
				String id = (String) map.get("id");
				charger = chargerRepository.findOne(id);
				CrudUtils.mapToObject(map, charger, id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			try {
				BeanUtils.populate(charger, map);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return chargerRepository.save(charger);
	}
	@Override
	public QueryResultObject query(RequestCondition queryCondition) {
		PageRequest request = this.buildPageRequest(queryCondition);
		List<QueryFilter> qList = queryCondition.getQueryFilter();
		Specification<Charger> specification = new Specification<Charger>() {

			@Override
			public Predicate toPredicate(Root<Charger> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = null;
				if(qList != null && !qList.isEmpty()){
					for(QueryFilter queryFilter : qList){
						Path<String> namePath = root.get(queryFilter.getFieldName());
						if(queryFilter.getFieldName().equals("stationid")){
							predicate = cb.equal(namePath, queryFilter.getValue());
						}else{
							predicate = cb.like(namePath, "%"+queryFilter.getValue()+"%");
						}
						query.where(predicate);
					}
				}
				return null;
			}
		};
		Page<Charger> charger = chargerRepository.findAll(specification,request);
	
		List<Charger> result = null;
		long count = 0;
		result = charger.getContent();
		count = charger.getTotalElements();
		List<DicItems>dictList = RestUtils.wrapDictList("manufacturer", manufacturer);
//		List<DicItems>dictList1 = RestUtils.wrapDictList("stationid", stationid);
		List<DicItems>dictList2 = RestUtils.wrapDictList("batterytype", batterytype);
		return RestUtils.wrappQueryResult(charger).addDicItems(dictList).addDicItems(dictList2);
	}

	/**
	 * 构建PageRequest
	 * @param queryCondition
	 * @return 页面请求对象
	 */
	private PageRequest buildPageRequest(RequestCondition queryCondition) {
		int pageIndex = 1, pageSize = 1;
		if (queryCondition.getPageIndex() != null && queryCondition.getPageSize() != null) {
			pageIndex = queryCondition.getPageIndex();
			pageSize = queryCondition.getPageSize();
		}
		return new PageRequest(pageIndex - 1, pageSize, null);
	}
}
