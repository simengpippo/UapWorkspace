define(['./app',"sammy"], function() {
 //cube.bundleName = "uaptext";//在UAP中使用时需配置，在微服务版中可不配置
 //cube.name= "app_demo";//场景名称，即pages的上级目录名称
 //章节1.1.3中的其他一些参数设置也在此设置

	var PageViewModel = function() {
		var self = this;
		self.depId = cube.obj("");
		self.contentUrl = cube.obj("chargerform");
		
		app = Sammy(function(){
			this.get(/\#([^/]+)/,function(){
			self.contentUrl(this.path.substring(1));
			});
			});
		app.run();
	};
	
	var pvm = new PageViewModel();
	
	$(document).ready(function(e){
		cube.startWebPage(pvm);
	});
});
