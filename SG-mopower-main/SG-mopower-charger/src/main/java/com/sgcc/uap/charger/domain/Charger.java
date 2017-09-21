package com.sgcc.uap.charger.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Charger的POJO类
 *
 * @author Administrator 
 * @date 2017-09-20 15:57:15
 */
@Entity
@Table(name = "charger")
public class Charger implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * chargerID
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "id", nullable = false, length = 42)
    private String id ;
    
    /** 
     * stationID
     */
    @Column(name = "stationid", nullable = true, length = 42)
    private String stationid ;
    
    /** 
     * powerLeft
     */
    @Column(name = "powerleft", nullable = true, length = 30)
    private Float powerleft ;
    
    /** 
     * 0  1  2  
     */
    @Column(name = "chargerstatus", nullable = true, length = 255)
    private String chargerstatus ;
    
    /** 
     * chargerCapacity
     */
    @Column(name = "chargercapacity", nullable = true, length = 30)
    private Float chargercapacity ;
    
    /** 
     * batteryType
     */
    @Column(name = "batterytype", nullable = true, length = 255)
    private String batterytype ;
    
    /** 
     * deployDate
     */
    @Column(name = "deploydate", nullable = true, length = 255)
    private String deploydate ;
    
    /** 
     * manufacturer
     */
    @Column(name = "manufacturer", nullable = true, length = 255)
    private String manufacturer ;
    
    /** 
     * 备注
     */
    @Column(name = "remark", nullable = true, length = 255)
    private String remark ;
    
    /**
     * chargerID的get方法
     * @return id
     */
    public String getId(){
        return id;
    }
    /**
     * chargerID的set方法
     * @param id
     */
    public void setId(String id){
        if(id != null && id.trim().length() == 0){
        	this.id = null;
        }else{
        	this.id = id;
        }
	} 
    /**
     * stationID的get方法
     * @return stationid
     */
    public String getStationid(){
        return stationid;
    }
    /**
     * stationID的set方法
     * @param stationid
     */
    public void setStationid(String stationid){
		this.stationid = stationid;
	} 
    /**
     * powerLeft的get方法
     * @return powerleft
     */
    public Float getPowerleft(){
        return powerleft;
    }
    /**
     * powerLeft的set方法
     * @param powerleft
     */
    public void setPowerleft(Float powerleft){
		this.powerleft = powerleft;
	} 
    /**
     * 0  1  2  的get方法
     * @return chargerstatus
     */
    public String getChargerstatus(){
        return chargerstatus;
    }
    /**
     * 0  1  2  的set方法
     * @param chargerstatus
     */
    public void setChargerstatus(String chargerstatus){
		this.chargerstatus = chargerstatus;
	} 
    /**
     * chargerCapacity的get方法
     * @return chargercapacity
     */
    public Float getChargercapacity(){
        return chargercapacity;
    }
    /**
     * chargerCapacity的set方法
     * @param chargercapacity
     */
    public void setChargercapacity(Float chargercapacity){
		this.chargercapacity = chargercapacity;
	} 
    /**
     * batteryType的get方法
     * @return batterytype
     */
    public String getBatterytype(){
        return batterytype;
    }
    /**
     * batteryType的set方法
     * @param batterytype
     */
    public void setBatterytype(String batterytype){
		this.batterytype = batterytype;
	} 
    /**
     * deployDate的get方法
     * @return deploydate
     */
    public String getDeploydate(){
        return deploydate;
    }
    /**
     * deployDate的set方法
     * @param deploydate
     */
    public void setDeploydate(String deploydate){
		this.deploydate = deploydate;
	} 
    /**
     * manufacturer的get方法
     * @return manufacturer
     */
    public String getManufacturer(){
        return manufacturer;
    }
    /**
     * manufacturer的set方法
     * @param manufacturer
     */
    public void setManufacturer(String manufacturer){
		this.manufacturer = manufacturer;
	} 
    /**
     * 备注的get方法
     * @return remark
     */
    public String getRemark(){
        return remark;
    }
    /**
     * 备注的set方法
     * @param remark
     */
    public void setRemark(String remark){
		this.remark = remark;
	} 
    /**
     * Hibernate通过该方法判断对象是否相等
     * @return boolean
     */  
    public boolean equals(Object obj) {
        if (this == obj)
			return true;
		
        if (obj == null || !(obj instanceof Charger))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		Charger other = (Charger) obj;
		
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (stationid == null) {
			if (other.stationid != null) {
				return false;
			}
		} else if (!stationid.equals(other.stationid)) {
			return false;
		}
		if (powerleft == null) {
			if (other.powerleft != null) {
				return false;
			}
		} else if (!powerleft.equals(other.powerleft)) {
			return false;
		}
		if (chargerstatus == null) {
			if (other.chargerstatus != null) {
				return false;
			}
		} else if (!chargerstatus.equals(other.chargerstatus)) {
			return false;
		}
		if (chargercapacity == null) {
			if (other.chargercapacity != null) {
				return false;
			}
		} else if (!chargercapacity.equals(other.chargercapacity)) {
			return false;
		}
		if (batterytype == null) {
			if (other.batterytype != null) {
				return false;
			}
		} else if (!batterytype.equals(other.batterytype)) {
			return false;
		}
		if (deploydate == null) {
			if (other.deploydate != null) {
				return false;
			}
		} else if (!deploydate.equals(other.deploydate)) {
			return false;
		}
		if (manufacturer == null) {
			if (other.manufacturer != null) {
				return false;
			}
		} else if (!manufacturer.equals(other.manufacturer)) {
			return false;
		}
		if (remark == null) {
			if (other.remark != null) {
				return false;
			}
		} else if (!remark.equals(other.remark)) {
			return false;
		}
		return true;
	}
    
    /**
     * toString方法
     * @return String
     */
	public String toString(){
		return "Charger ["
			+ ", id=" + id
			+ ", stationid=" + stationid
			+ ", powerleft=" + powerleft
			+ ", chargerstatus=" + chargerstatus
			+ ", chargercapacity=" + chargercapacity
			+ ", batterytype=" + batterytype
			+ ", deploydate=" + deploydate
			+ ", manufacturer=" + manufacturer
			+ ", remark=" + remark;
	}
   
    
    /**
     * hashcode方法
     * @return int
     * 
     */
    @Override
    public int hashCode(){
		return super.hashCode();
	}
}