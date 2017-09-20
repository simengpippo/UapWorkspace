define([], function() {
	var PageViewModel = function(params) {
		var self = this;
		self.url = cube.gatewayURL_dept + "/department/tree";
		self.onSelectedChanged = function(p_value){
			params.depId(p_value.id);
		};

        cube.endViewModel(self, params);
	};
	return PageViewModel;
});
