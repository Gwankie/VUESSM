(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-exampaper-add-or-update"],{1405:function(t,e,r){"use strict";r.r(e);var n=r("eebf"),a=r.n(n);for(var i in n)"default"!==i&&function(t){r.d(e,t,(function(){return n[t]}))}(i);e["default"]=a.a},"1d92":function(t,e,r){var n=r("24fb");e=n(!1),e.push([t.i,'@charset "UTF-8";\n/**\r\n * 这里是uni-app内置的常用样式变量\r\n *\r\n * uni-app 官方扩展插件及插件市场（https://ext.dcloud.net.cn）上很多三方插件均使用了这些样式变量\r\n * 如果你是插件开发者，建议你使用scss预处理，并在插件代码中直接使用这些变量（无需 import 这个文件），方便用户通过搭积木的方式开发整体风格一致的App\r\n *\r\n */\n/**\r\n * 如果你是App开发者（插件使用者），你可以通过修改这些变量来定制自己的插件主题，实现自定义主题功能\r\n *\r\n * 如果你的项目同样使用了scss预处理，你也可以直接在你的 scss 代码中使用如下变量，同时无需 import 这个文件\r\n */\n/* 颜色变量 */\n/* 行为相关颜色 */\n/* 文字基本颜色 */\n/* 背景颜色 */\n/* 边框颜色 */\n/* 尺寸变量 */\n/* 文字尺寸 */\n/* 图片尺寸 */\n/* Border Radius */\n/* 水平间距 */\n/* 垂直间距 */\n/* 透明度 */\n/* 文章场景相关 */.container[data-v-537af267]{padding:%?20?%}uni-textarea[data-v-537af267]{border:%?1?% solid #eee;border-radius:%?20?%;padding:%?20?%}.title[data-v-537af267]{width:%?180?%}.avator[data-v-537af267]{width:%?150?%;height:%?60?%}.right-input[data-v-537af267]{-webkit-box-flex:1;-webkit-flex:1;flex:1;text-align:left}',""]),t.exports=e},"2e5b":function(t,e,r){"use strict";var n=r("72e1"),a=r.n(n);a.a},"72e1":function(t,e,r){var n=r("1d92");"string"===typeof n&&(n=[[t.i,n,""]]),n.locals&&(t.exports=n.locals);var a=r("4f06").default;a("83dddf20",n,!0,{sourceMap:!1,shadowMode:!1})},bc8f:function(t,e,r){"use strict";var n,a=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("v-uni-view",{staticClass:"content"},[r("v-uni-form",[r("v-uni-view",{staticClass:"cu-form-group"},[r("v-uni-view",{staticClass:"title"},[t._v("试卷名称")]),r("v-uni-input",{attrs:{placeholder:"试卷名称"},model:{value:t.ruleForm.name,callback:function(e){t.$set(t.ruleForm,"name",e)},expression:"ruleForm.name"}})],1),r("v-uni-view",{staticClass:"cu-form-group"},[r("v-uni-view",{staticClass:"title"},[t._v("考试时长(分钟)")]),r("v-uni-input",{attrs:{placeholder:"考试时长(分钟)"},model:{value:t.ruleForm.time,callback:function(e){t.$set(t.ruleForm,"time",e)},expression:"ruleForm.time"}})],1),r("v-uni-view",{staticClass:"cu-form-group"},[r("v-uni-view",{staticClass:"title"},[t._v("试卷状态")]),r("v-uni-picker",{attrs:{value:t.statusIndex,range:t.statusOptions},on:{change:function(e){arguments[0]=e=t.$handleEvent(e),t.statusChange.apply(void 0,arguments)}}},[r("v-uni-view",{staticClass:"uni-input"},[t._v(t._s(t.ruleForm.status?t.ruleForm.status:"请选择试卷状态"))])],1)],1),r("v-uni-button",{staticClass:"bg-red margin-tb-sm",on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.onSubmitTap.apply(void 0,arguments)}}},[t._v("提交")])],1)],1)},i=[];r.d(e,"b",(function(){return a})),r.d(e,"c",(function(){return i})),r.d(e,"a",(function(){return n}))},dcc1:function(t,e,r){"use strict";r.r(e);var n=r("bc8f"),a=r("1405");for(var i in a)"default"!==i&&function(t){r.d(e,t,(function(){return a[t]}))}(i);r("2e5b");var s,u=r("f0c5"),o=Object(u["a"])(a["default"],n["b"],n["c"],!1,null,"537af267",null,!1,n["a"],s);e["default"]=o.exports},eebf:function(t,e,r){"use strict";var n=r("4ea4");Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0,r("ac6a"),r("28a5"),r("96cf");var a=n(r("3b8d")),i=n(r("e2b1")),s={data:function(){return{ruleForm:{name:"",time:"",status:""},statusOptions:[],statusIndex:0,user:{}}},components:{wPicker:i.default},computed:{},onLoad:function(){var t=(0,a.default)(regeneratorRuntime.mark((function t(e){var r,n,a,i;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return r=uni.getStorageSync("nowTable"),t.next=3,this.$api.session(r);case 3:if(n=t.sent,this.user=n.data,this.statusOptions="禁用 ,启用".split(","),this.ruleForm.userid=uni.getStorageSync("userid"),e.refid&&(this.ruleForm.refid=e.refid),!e.id){t.next=14;break}return this.ruleForm.id=e.id,t.next=12,this.$api.info("exampaper",this.ruleForm.id);case 12:n=t.sent,this.ruleForm=n.data;case 14:if(!e.cross){t.next=30;break}a=uni.getStorageSync("crossObj"),t.t0=regeneratorRuntime.keys(a);case 17:if((t.t1=t.t0()).done){t.next=30;break}if(i=t.t1.value,"name"!=i){t.next=22;break}return this.ruleForm.name=a[i],t.abrupt("continue",17);case 22:if("time"!=i){t.next=25;break}return this.ruleForm.time=a[i],t.abrupt("continue",17);case 25:if("status"!=i){t.next=28;break}return this.ruleForm.status=a[i],t.abrupt("continue",17);case 28:t.next=17;break;case 30:case"end":return t.stop()}}),t,this)})));function e(e){return t.apply(this,arguments)}return e}(),methods:{statusChange:function(t){this.statusIndex=t.target.value,this.ruleForm.status=this.statusOptions[this.statusIndex]},getUUID:function(){return(new Date).getTime()},onSubmitTap:function(){var t=(0,a.default)(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(this.ruleForm.name){t.next=3;break}return this.$utils.msg("试卷名称不能为空"),t.abrupt("return");case 3:if(this.ruleForm.time){t.next=6;break}return this.$utils.msg("考试时长(分钟)不能为空"),t.abrupt("return");case 6:if(!this.ruleForm.time||this.$validate.isIntNumer(this.ruleForm.time)){t.next=9;break}return this.$utils.msg("考试时长(分钟)应输入整数"),t.abrupt("return");case 9:if(this.ruleForm.status){t.next=12;break}return this.$utils.msg("试卷状态不能为空"),t.abrupt("return");case 12:if(!this.ruleForm.status||this.$validate.isIntNumer(this.ruleForm.status)){t.next=15;break}return this.$utils.msg("试卷状态应输入整数"),t.abrupt("return");case 15:if(!this.ruleForm.id){t.next=20;break}return t.next=18,this.$api.update("exampaper",this.ruleForm);case 18:t.next=22;break;case 20:return t.next=22,this.$api.add("exampaper",this.ruleForm);case 22:this.$utils.msgBack("提交成功");case 23:case"end":return t.stop()}}),t,this)})));function e(){return t.apply(this,arguments)}return e}(),optionsChange:function(t){this.index=t.target.value},bindDateChange:function(t){this.date=t.target.value},getDate:function(t){var e=new Date,r=e.getFullYear(),n=e.getMonth()+1,a=e.getDate();return"start"===t?r-=60:"end"===t&&(r+=2),n=n>9?n:"0"+n,a=a>9?a:"0"+a,"".concat(r,"-").concat(n,"-").concat(a)},toggleTab:function(t){this.$refs[t].show()}}};e.default=s}}]);