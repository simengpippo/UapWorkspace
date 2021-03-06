//页面视图模型绑定的数据内容
define(["RESTClient"], function(RestClient) {
	var PageViewModel = function(params) {

		var selectId = null;

		var self = this;
		self.url= cube.gatewayURL_charger + "/charger/";
		// 修改成网关地址
		//self.url = cube.gatewayURL + "/employee/";
		self.args = cube.obj({
			"depId" : params.depId()
		});
		self.columns = [ {
			name : "id",
			caption : "充电桩编号",
		}, {
			name : "stationid",
			caption : "所属站点"
		}, {
			name : "powerleft",
			caption : "剩余电量"
		}, {
			name : "chargerstatus",
			caption : "充电桩状态"
		}, {
			name : "chargercapacity",
			caption : "充电桩容量"
		}, {
			name : "batterytype",
			caption : "电池类型"
		}, {
			name : "deploydate",
			caption : "部署时间"
		}, {
			name : "manufacturer",
			caption : "电池制造商"
		}, {
			name : "remark",
			caption : "备注"
		}];
		cube.subscribe(params.depId, function() {
			self.args({
				"depId" : params.depId()
			});
		});
		self.customOperations = [ {
			caption : "编辑",
			icon : "icon-edit",// Font Awesome 3.0.2中的图标样式，当icon没有设置时显示caption
			click : function(item) {
				app.setLocation("#orderdetail?id=" + item.id);

			}
		} ];

		self.toolbarContent = [ {
			group : [ {
				text : "新建",
				icon : "plus",
				func : "onNewClick"
			}, {
				text : "删除",
				icon : "trash",
				func : "onDeleteClick"
			} ]
		} ];
		
		self.onSelectedItems = function(item){
			selectId = item[0];
		}

		
		self.onItemClick = function(e) {
			if (e == "onNewClick") {
				app.setLocation("#chargerdetail");
			} else if (e == "onDeleteClick") {
				cube.getPageViewModelByNode($("#ordergrid")).delCheckedItem();
			}
		};
		self.fields = [ {
			name : "chargerid",
			caption : "充电桩编号",
			editorType : "TextEditor"
		} ];
		cube.endViewModel(self, params);
	};
	return PageViewModel;
});
