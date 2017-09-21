//页面视图模型绑定的数据内容
define([], function() {
	var PageViewModel = function(params) {
		var self = this;
		self.url = cube.gatewayURL_charger + "/charger/";
		//修改成网关地址
		//self.url = cube.gatewayURL + "/employee/";
		self.id = cube.obj(params.id);
		self.fields = [
		{name:"id",caption:"充电桩编号"},
		{name:"stationid",caption:"所属站点",editorType:"DropDownEditor"},
		{name:"powerleft",caption:"剩余电量"},
		{name:"chargerstatus",caption:"充电桩状态"},
		{name:"chargercapacity",caption:"充电桩容量"},
		{name:"batterytype",caption:"电池类型",editorType:"DropDownEditor"},
		{name:"deploydate",caption:"部署时间",editorType:"DateTimeEditor"},
		{name:"manufacturer",caption:"电池制造商"},
		{name:"remark",caption:"备注",},
		    ];

		self.saved = function(){
		cube.indicate("保存成功");
		}

		cube.endViewModel(self, params);
	};
	return PageViewModel;
});