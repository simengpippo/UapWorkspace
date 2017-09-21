//页面视图模型绑定的数据内容
define([], function() {
	var PageViewModel = function(params) {
		var self = this;
		self.url = cube.gatewayURL_charger + "/charger/";
		
		var statinfo = getStationInfo();
		//修改成网关地址
		//self.url = cube.gatewayURL + "/employee/";
		self.id = cube.obj(params.id);
		self.fields = [
		{name:"id",caption:"充电桩编号"},
		{name:"stationid",caption:"所属站点",editorType:"DropDownEditor",list:statinfo},
		{name:"powerleft",caption:"剩余电量"},
		{name:"chargerstatus",caption:"充电桩状态"},
		{name:"chargercapacity",caption:"充电桩容量"},
		{name:"batterytype",caption:"电池类型",editorType:"DropDownEditor"},
		{name:"deploydate",caption:"部署时间",editorType:"DateTimeEditor"},
		{name:"manufacturer",caption:"电池制造商",editorType:"DropDownEditor"},
		{name:"remark",caption:"备注",},
		    ];

		self.saved = function(){
		cube.indicate("保存成功");
		}
		

		cube.endViewModel(self, params);
	};
	return PageViewModel;
});


function getStationInfo(){
	 stationInfo = new Array();

		var locationList = new Array();
		//获取后台传来的数据 192.168.8.158:809
		//url = "http://127.0.0.1:809/station/all";
		url = "http://192.168.8.155:8050/station/all";
		// 同步 数据绑定
		$.ajax({url,async:false,success:function(result){resultValue = result.resultValue;
	    	locationList = resultValue.items;
		    	for(var i=0; i<locationList.length;i++){
		    		stationInfo[i] = new Array();
		    		stationInfo[i]={value:locationList[i].id,text:locationList[i].stationname};    
		    	}
		    	
		}});
		
		 return stationInfo;
	  };