define([], function() {
	var PageViewModel = function(params) {
		var self = this;
		self.menuItems = [
			 {
				    text: '订单管理',
			    	route: "#orderform",
			    	hasChildren: false
			},
			 {
				    text: '充电桩管理',
			    	route: "#chargerform",
			    	hasChildren: false
			}];
		self.onSelectItemChanged = function(p_value){
			app.setLocation(p_value.route);
		};

        cube.endViewModel(self, params);
	};
	return PageViewModel;
});
