(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/shipinxuexi/detail"],{"1b24":function(t,e,n){"use strict";(function(t){Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var a=i(n("a34a"));function i(t){return t&&t.__esModule?t:{default:t}}function s(t,e,n,a,i,s,r){try{var u=t[s](r),o=u.value}catch(c){return void n(c)}u.done?e(o):Promise.resolve(o).then(a,i)}function r(t){return function(){var e=this,n=arguments;return new Promise((function(a,i){var r=t.apply(e,n);function u(t){s(r,a,i,u,o,"next",t)}function o(t){s(r,a,i,u,o,"throw",t)}u(void 0)}))}}var u={data:function(){return{id:"",detail:{},swiperList:[],commentList:[],mescroll:null,downOption:{auto:!1},upOption:{noMoreSize:3,textNoMore:"~ 没有更多了 ~"},hasNext:!0,user:{},sfshIndex:-1,sfshOptions:["通过","不通过"],count:0}},computed:{SecondToDate:function(){var t=this.count;return null!=t&&""!=t&&(t=t>60&&t<3600?parseInt(t/60)+"分钟"+parseInt(60*(parseFloat(t/60)-parseInt(t/60)))+"秒":t>=3600&&t<86400?parseInt(t/3600)+"小时"+parseInt(60*(parseFloat(t/3600)-parseInt(t/3600)))+"分钟"+parseInt(60*(parseFloat(60*(parseFloat(t/3600)-parseInt(t/3600)))-parseInt(60*(parseFloat(t/3600)-parseInt(t/3600)))))+"秒":t>=86400?parseInt(t/3600/24)+"天"+parseInt(24*(parseFloat(t/3600/24)-parseInt(t/3600/24)))+"小时"+parseInt(60*(parseFloat(t/3600)-parseInt(t/3600)))+"分钟"+parseInt(60*(parseFloat(60*(parseFloat(t/3600)-parseInt(t/3600)))-parseInt(60*(parseFloat(t/3600)-parseInt(t/3600)))))+"秒":parseInt(t)+"秒"),t}},onLoad:function(e){var n=this;return r(a.default.mark((function i(){var s,r;return a.default.wrap((function(a){while(1)switch(a.prev=a.next){case 0:return n.id=e.id,n.init(),s=t.getStorageSync("nowTable"),a.next=5,n.$api.session(s);case 5:r=a.sent,n.user=r.data;case 7:case"end":return a.stop()}}),i)})))()},destroyed:function(){window.clearInterval(this.inter)},methods:{onPayTap:function(){t.setStorageSync("paytable","shipinxuexi"),t.setStorageSync("payObject",this.detail),this.$utils.jump("../pay-confirm/pay-confirm?type=1")},shoucang:function(){var e=this;return r(a.default.mark((function n(){var i;return a.default.wrap((function(n){while(1)switch(n.prev=n.next){case 0:i=e,t.showModal({title:"提示",content:"是否收藏",success:function(){var t=r(a.default.mark((function t(e){return a.default.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(!e.confirm){t.next=4;break}return t.next=3,i.$api.add("storeup",{userid:i.user.id,name:i.detail.jiaoxuebiaoti,picture:i.swiperList[0],refid:i.detail.id,tablename:"shipinxuexi"});case 3:i.$utils.msg("收藏成功");case 4:case"end":return t.stop()}}),t)})));function e(e){return t.apply(this,arguments)}return e}()});case 2:case"end":return n.stop()}}),n)})))()},onAcrossTap:function(e){t.setStorageSync("crossTable","shipinxuexi"),t.setStorageSync("crossObj",this.detail),this.$utils.jump("../".concat(e,"/add-or-update?cross=true"))},init:function(){var t=this;return r(a.default.mark((function e(){var n;return a.default.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,t.$api.info("shipinxuexi",t.id);case 2:n=e.sent,t.detail=n.data,t.swiperList=t.detail.tupianfengmian?t.detail.tupianfengmian.split(","):[];case 5:case"end":return e.stop()}}),e)})))()},mescrollInit:function(t){this.mescroll=t},downCallback:function(t){this.hasNext=!0,t.resetUpScroll()},upCallback:function(t){var e=this;return r(a.default.mark((function n(){var i;return a.default.wrap((function(n){while(1)switch(n.prev=n.next){case 0:return n.next=2,e.$api.list("discussshipinxuexi",{page:t.num,limit:t.size,refid:e.id});case 2:i=n.sent,1==t.num&&(e.commentList=[]),e.commentList=e.commentList.concat(i.data.list),0==i.data.list.length&&(e.hasNext=!1),t.endSuccess(t.size,e.hasNext);case 7:case"end":return n.stop()}}),n)})))()},onChatTap:function(){this.$utils.jump("../chat/chat")},download:function(e){var n=this;t.downloadFile({url:n.$base.url+"file/download?fileName="+e.replace(n.$base.url+"upload/",""),success:function(t){200===t.statusCode&&(n.$utils.msg("下载成功"),window.open(e))}})},onCartTabTap:function(){this.$utils.tab("../shop-cart/shop-cart")},onCommentTap:function(){this.$utils.jump("../discussshipinxuexi/add-or-update?refid=".concat(this.id))},zan:function(){var e=this;return r(a.default.mark((function n(){var i;return a.default.wrap((function(n){while(1)switch(n.prev=n.next){case 0:i=e,t.showModal({title:"提示",content:"是否点赞",success:function(){var t=r(a.default.mark((function t(e){return a.default.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(!e.confirm){t.next=5;break}return i.detail.thumbsupnum+=1,t.next=4,i.$api.update("shipinxuexi",i.detail);case 4:i.$utils.msg("点赞成功");case 5:case"end":return t.stop()}}),t)})));function e(e){return t.apply(this,arguments)}return e}()});case 2:case"end":return n.stop()}}),n)})))()},cai:function(){var e=this;return r(a.default.mark((function n(){var i;return a.default.wrap((function(n){while(1)switch(n.prev=n.next){case 0:i=e,t.showModal({title:"提示",content:"是否点踩",success:function(){var t=r(a.default.mark((function t(e){return a.default.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(!e.confirm){t.next=5;break}return i.detail.crazilynum+=1,t.next=4,i.$api.update("shipinxuexi",i.detail);case 4:i.$utils.msg("点踩成功");case 5:case"end":return t.stop()}}),t)})));function e(e){return t.apply(this,arguments)}return e}()});case 2:case"end":return n.stop()}}),n)})))()},onSHTap:function(){this.$refs.popup.open()},onFinishTap:function(){var t=this;return r(a.default.mark((function e(){return a.default.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(t.detail.sfsh){e.next=3;break}return t.$utils.msg("请选择审核状态"),e.abrupt("return");case 3:if(t.detail.shhf){e.next=6;break}return t.$utils.msg("请填写审核回复"),e.abrupt("return");case 6:return"通过"==t.detail.sfsh&&(t.detail.sfsh="是"),"不通过"==t.detail.sfsh&&(t.detail.sfsh="否"),e.next=10,t.$api.update("shipinxuexi",t.detail);case 10:t.$utils.msg("审核成功"),t.$refs.popup.close();case 12:case"end":return e.stop()}}),e)})))()},onCloseWinTap:function(){this.$refs.popup.close()},sfshChange:function(t){console.log(this.detail),this.sfshIndex=t.target.value,this.detail.sfsh=this.sfshOptions[this.sfshIndex]}}};e.default=u}).call(this,n("543d")["default"])},"1e1d":function(t,e,n){"use strict";n.r(e);var a=n("1b24"),i=n.n(a);for(var s in a)"default"!==s&&function(t){n.d(e,t,(function(){return a[t]}))}(s);e["default"]=i.a},"5a7f":function(t,e,n){"use strict";n.r(e);var a=n("cc7d"),i=n("1e1d");for(var s in i)"default"!==s&&function(t){n.d(e,t,(function(){return i[t]}))}(s);n("7297");var r,u=n("f0c5"),o=Object(u["a"])(i["default"],a["b"],a["c"],!1,null,null,null,!1,a["a"],r);e["default"]=o.exports},7297:function(t,e,n){"use strict";var a=n("f75f"),i=n.n(a);i.a},c3db:function(t,e,n){"use strict";(function(t){n("7fe6");a(n("66fd"));var e=a(n("5a7f"));function a(t){return t&&t.__esModule?t:{default:t}}t(e.default)}).call(this,n("543d")["createPage"])},cc7d:function(t,e,n){"use strict";n.d(e,"b",(function(){return i})),n.d(e,"c",(function(){return s})),n.d(e,"a",(function(){return a}));var a={mescrollUni:function(){return Promise.all([n.e("common/vendor"),n.e("components/mescroll-uni/mescroll-uni")]).then(n.bind(null,"07a5"))},uniPopup:function(){return n.e("components/uni-popup/uni-popup").then(n.bind(null,"9daa"))}},i=function(){var t=this,e=t.$createElement;t._self._c},s=[]},f75f:function(t,e,n){}},[["c3db","common/runtime","common/vendor"]]]);