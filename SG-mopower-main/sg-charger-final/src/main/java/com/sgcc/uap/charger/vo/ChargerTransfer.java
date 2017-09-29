package com.sgcc.uap.charger.vo;


import com.sgcc.uap.charger.domain.Charger;

public class ChargerTransfer {

	public static Charger toPO(ChargerVO vo) {
		Charger charger = new Charger();
		if(vo != null){
			charger.setId(vo.getId());
			charger.setStationid(vo.getStationid());
			charger.setPowerleft(vo.getPowerleft());
			charger.setChargerstatus(vo.getChargerstatus());
			charger.setChargercapacity(vo.getChargercapacity());
			charger.setBatterytype(vo.getBatterytype());
			charger.setDeploydate(vo.getDeploydate());
			charger.setManufacturer(vo.getManufacturer());
			charger.setRemark(vo.getRemark());
        }
		return charger;
	}

	public static ChargerVO toVO(Charger po) {
		ChargerVO vo = new ChargerVO();
		vo.setId(po.getId());
		vo.setStationid(po.getStationid());
		vo.setPowerleft(po.getPowerleft());
		vo.setChargerstatus(po.getChargerstatus());
		vo.setChargercapacity(po.getChargercapacity());
		vo.setBatterytype(po.getBatterytype());
		vo.setDeploydate(po.getDeploydate());
		vo.setManufacturer(po.getManufacturer());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
