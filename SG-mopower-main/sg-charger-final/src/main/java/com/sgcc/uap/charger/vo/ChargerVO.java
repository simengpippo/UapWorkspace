package com.sgcc.uap.charger.vo;

import java.io.Serializable;

import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;
/**
 * Charger的VO类
 *
 * @author Pavel 
 * @date 2017-09-28 11:28:34
 */
public class ChargerVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性chargerID
     */  
    @ViewAttribute(name ="id",caption="chargerID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String id;    
    /** 
     * 属性stationID
     */  
    @ViewAttribute(name ="stationid",caption="stationID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String stationid;    
    /** 
     * 属性powerLeft
     */  
    @ViewAttribute(name ="powerleft",caption="powerLeft", editor=EditorType.NumberEditor,nullable =true,readOnly=false, type=AttributeType.FLOAT)
    private Float powerleft;    
    /** 
     * 属性0  1  2  
     */  
    @ViewAttribute(name ="chargerstatus",caption="0  1  2  ", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String chargerstatus;    
    /** 
     * 属性chargerCapacity
     */  
    @ViewAttribute(name ="chargercapacity",caption="chargerCapacity", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String chargercapacity;    
    /** 
     * 属性batteryType
     */  
    @ViewAttribute(name ="batterytype",caption="batteryType", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String batterytype;    
    /** 
     * 属性deployDate
     */  
    @ViewAttribute(name ="deploydate",caption="deployDate", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String deploydate;    
    /** 
     * 属性manufacturer
     */  
    @ViewAttribute(name ="manufacturer",caption="manufacturer", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String manufacturer;    
    /** 
     * 属性备注
     */  
    @ViewAttribute(name ="remark",caption="备注", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /**
     * ChargerVO构造函数
     */
    public ChargerVO() {
        super();
    } 
   
	 /**
     * ChargerVO完整的构造函数
     */  
    public ChargerVO(String id){
        this.id = id;
    }
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
    public String getChargercapacity(){
        return chargercapacity;
    }
    /**
     * chargerCapacity的set方法
     * @param chargercapacity
     */
    public void setChargercapacity(String chargercapacity){
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
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("id"+":"+getId())
				.append("stationid"+":"+getStationid())
				.append("powerleft"+":"+getPowerleft())
				.append("chargerstatus"+":"+getChargerstatus())
				.append("chargercapacity"+":"+getChargercapacity())
				.append("batterytype"+":"+getBatterytype())
				.append("deploydate"+":"+getDeploydate())
				.append("manufacturer"+":"+getManufacturer())
				.append("remark"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
