(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/discussshipinxuexi/detail"],{"0552":function(t,e,n){"use strict";n.r(e);var s=n("c210"),a=n.n(s);for(var i in s)"default"!==i&&function(t){n.d(e,t,(function(){return s[t]}))}(i);e["default"]=a.a},"1dee":function(t,e,n){"use strict";var s=n("3964"),a=n.n(s);a.a},"37f8":function(t,e,n){"use strict";n.r(e);var s=n("eb14"),a=n("0552");for(var i in a)"default"!==i&&function(t){n.d(e,t,(function(){return a[t]}))}(i);n("1dee");var r,u=n("f0c5"),o=Object(u["a"])(a["default"],s["b"],s["c"],!1,null,null,null,!1,s["a"],r);e["default"]=o.exports},3964:function(t,e,n){},"4d48":function(t,e,n){"use strict";(function(t){n("7fe6");s(n("66fd"));var e=s(n("37f8"));function s(t){return t&&t.__esModule?t:{default:t}}t(e.default)}).call(this,n("543d")["createPage"])},c210:function(t,e,n){"use strict";(function(t){Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var s=a(n("a34a"));function a(t){return t&&t.__esModule?t:{default:t}}function i(t,e,n,s,a,i,r){try{var u=t[i](r),o=u.value}catch(c){return void n(c)}u.done?e(o):Promise.resolve(o).then(s,a)}function r(t){return function(){var e=this,n=arguments;return new Promise((function(s,a){var r=t.apply(e,n);function u(t){i(r,s,a,u,o,"next",t)}function o(t){i(r,s,a,u,o,"throw",t)}u(void 0)}))}}var u={data:function(){return{id:"",detail:{},swiperList:[],commentList:[],mescroll:null,downOption:{auto:!1},upOption:{noMoreSize:3,textNoMore:"~ 没有更多了 ~"},hasNext:!0,user:{},sfshIndex:-1,sfshOptions:["通过","不通过"],count:0}},computed:{SecondToDate:function(){var t=this.count;return null!=t&&""!=t&&(t=t>60&&t<3600?parseInt(t/60)+"分钟"+parseInt(60*(parseFloat(t/60)-parseInt(t/60)))+"秒":t>=3600&&t<86400?parseInt(t/3600)+"小时"+parseInt(60*(parseFloat(t/3600)-parseInt(t/3600)))+"分钟"+parseInt(60*(parseFloat(60*(parseFloat(t/3600)-parseInt(t/3600)))-parseInt(60*(parseFloat(t/3600)-parseInt(t/3600)))))+"秒":t>=86400?parseInt(t/3600/24)+"天"+parseInt(24*(parseFloat(t/3600/24)-parseInt(t/3600/24)))+"小时"+parseInt(60*(parseFloat(t/3600)-parseInt(t/3600)))+"分钟"+parseInt(60*(parseFloat(60*(parseFloat(t/3600)-parseInt(t/3600)))-parseInt(60*(parseFloat(t/3600)-parseInt(t/3600)))))+"秒":parseInt(t)+"秒"),t}},onLoad:function(e){var n=this;return r(s.default.mark((function a(){var i,r;return s.default.wrap((function(s){while(1)switch(s.prev=s.next){case 0:return n.id=e.id,n.init(),i=t.getStorageSync("nowTable"),s.next=5,n.$api.session(i);case 5:r=s.sent,n.user=r.data;case 7:case"end":return s.stop()}}),a)})))()},destroyed:function(){window.clearInterval(this.inter)},methods:{onPayTap:function(){t.setStorageSync("paytable","discussshipinxuexi"),t.setStorageSync("payObject",this.detail),this.$utils.jump("../pay-confirm/pay-confirm?type=1")},onAcrossTap:function(e){t.setStorageSync("crossTable","discussshipinxuexi"),t.setStorageSync("crossObj",this.detail),this.$utils.jump("../".concat(e,"/add-or-update?cross=true"))},init:function(){var t=this;return r(s.default.mark((function e(){var n;return s.default.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,t.$api.info("discussshipinxuexi",t.id);case 2:n=e.sent,t.detail=n.data;case 4:case"end":return e.stop()}}),e)})))()},mescrollInit:function(t){this.mescroll=t},downCallback:function(t){this.hasNext=!0,t.resetUpScroll()},upCallback:function(t){var e=this;return r(s.default.mark((function n(){var a;return s.default.wrap((function(n){while(1)switch(n.prev=n.next){case 0:return n.next=2,e.$api.list("discussdiscussshipinxuexi",{page:t.num,limit:t.size,refid:e.id});case 2:a=n.sent,1==t.num&&(e.commentList=[]),e.commentList=e.commentList.concat(a.data.list),0==a.data.list.length&&(e.hasNext=!1),t.endSuccess(t.size,e.hasNext);case 7:case"end":return n.stop()}}),n)})))()},onChatTap:function(){this.$utils.jump("../chat/chat")},download:function(e){var n=this;t.downloadFile({url:n.$base.url+"file/download?fileName="+e.replace(n.$base.url+"upload/",""),success:function(t){200===t.statusCode&&(n.$utils.msg("下载成功"),window.open(e))}})},onCartTabTap:function(){this.$utils.tab("../shop-cart/shop-cart")},onCommentTap:function(){this.$utils.jump("../discussdiscussshipinxuexi/add-or-update?refid=".concat(this.id))},zan:function(){var e=this;return r(s.default.mark((function n(){var a;return s.default.wrap((function(n){while(1)switch(n.prev=n.next){case 0:a=e,t.showModal({title:"提示",content:"是否点赞",success:function(){var t=r(s.default.mark((function t(e){return s.default.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(!e.confirm){t.next=5;break}return a.detail.thumbsupnum+=1,t.next=4,a.$api.update("discussshipinxuexi",a.detail);case 4:a.$utils.msg("点赞成功");case 5:case"end":return t.stop()}}),t)})));function e(e){return t.apply(this,arguments)}return e}()});case 2:case"end":return n.stop()}}),n)})))()},cai:function(){var e=this;return r(s.default.mark((function n(){var a;return s.default.wrap((function(n){while(1)switch(n.prev=n.next){case 0:a=e,t.showModal({title:"提示",content:"是否点踩",success:function(){var t=r(s.default.mark((function t(e){return s.default.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(!e.confirm){t.next=5;break}return a.detail.crazilynum+=1,t.next=4,a.$api.update("discussshipinxuexi",a.detail);case 4:a.$utils.msg("点踩成功");case 5:case"end":return t.stop()}}),t)})));function e(e){return t.apply(this,arguments)}return e}()});case 2:case"end":return n.stop()}}),n)})))()},onSHTap:function(){this.$refs.popup.open()},onFinishTap:function(){var t=this;return r(s.default.mark((function e(){return s.default.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(t.detail.sfsh){e.next=3;break}return t.$utils.msg("请选择审核状态"),e.abrupt("return");case 3:if(t.detail.shhf){e.next=6;break}return t.$utils.msg("请填写审核回复"),e.abrupt("return");case 6:return"通过"==t.detail.sfsh&&(t.detail.sfsh="是"),"不通过"==t.detail.sfsh&&(t.detail.sfsh="否"),e.next=10,t.$api.update("discussshipinxuexi",t.detail);case 10:t.$utils.msg("审核成功"),t.$refs.popup.close();case 12:case"end":return e.stop()}}),e)})))()},onCloseWinTap:function(){this.$refs.popup.close()},sfshChange:function(t){console.log(this.detail),this.sfshIndex=t.target.value,this.detail.sfsh=this.sfshOptions[this.sfshIndex]}}};e.default=u}).call(this,n("543d")["default"])},eb14:function(t,e,n){"use strict";n.d(e,"b",(function(){return a})),n.d(e,"c",(function(){return i})),n.d(e,"a",(function(){return s}));var s={mescrollUni:function(){return Promise.all([n.e("common/vendor"),n.e("components/mescroll-uni/mescroll-uni")]).then(n.bind(null,"07a5"))},uniPopup:function(){return n.e("components/uni-popup/uni-popup").then(n.bind(null,"9daa"))}},a=function(){var t=this,e=t.$createElement;t._self._c},i=[]}},[["4d48","common/runtime","common/vendor"]]]);