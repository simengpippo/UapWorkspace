package com.sgcc.uap.charger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sgcc.uap.charger.domain.Charger;

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
public interface ChargerRepository extends JpaRepository<Charger,String>,JpaSpecificationExecutor<Charger> {
	
}
