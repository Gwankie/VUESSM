(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/exampaper/list"],{"054f":function(t,e,n){"use strict";n.d(e,"b",(function(){return r})),n.d(e,"c",(function(){return i})),n.d(e,"a",(function(){return a}));var a={mescrollUni:function(){return Promise.all([n.e("common/vendor"),n.e("components/mescroll-uni/mescroll-uni")]).then(n.bind(null,"07a5"))}},r=function(){var t=this,e=t.$createElement,n=(t._self._c,t.isAuth("exampaper","修改")),a=t.isAuth("exampaper","删除"),r=t.isAuth("exampaper","新增");t.$mp.data=Object.assign({},{$root:{m0:n,m1:a,m2:r}})},i=[]},"0b66":function(t,e,n){"use strict";(function(t){n("7fe6");a(n("66fd"));var e=a(n("1b08"));function a(t){return t&&t.__esModule?t:{default:t}}t(e.default)}).call(this,n("543d")["createPage"])},"1b08":function(t,e,n){"use strict";n.r(e);var a=n("054f"),r=n("7186");for(var i in r)"default"!==i&&function(t){n.d(e,t,(function(){return r[t]}))}(i);n("4ef7");var s,o=n("f0c5"),u=Object(o["a"])(r["default"],a["b"],a["c"],!1,null,null,null,!1,a["a"],s);e["default"]=u.exports},"4ef7":function(t,e,n){"use strict";var a=n("b52b"),r=n.n(a);r.a},7186:function(t,e,n){"use strict";n.r(e);var a=n("a9f4"),r=n.n(a);for(var i in a)"default"!==i&&function(t){n.d(e,t,(function(){return a[t]}))}(i);e["default"]=r.a},a9f4:function(t,e,n){"use strict";(function(t){Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var a=r(n("a34a"));function r(t){return t&&t.__esModule?t:{default:t}}function i(t,e,n,a,r,i,s){try{var o=t[i](s),u=o.value}catch(c){return void n(c)}o.done?e(u):Promise.resolve(u).then(a,r)}function s(t){return function(){var e=this,n=arguments;return new Promise((function(a,r){var s=t.apply(e,n);function o(t){i(s,a,r,o,u,"next",t)}function u(t){i(s,a,r,o,u,"throw",t)}o(void 0)}))}}var o={data:function(){return{list:[],mescroll:null,downOption:{auto:!1},upOption:{noMoreSize:5,textNoMore:"~ 没有更多了 ~"},hasNext:!0,searchForm:{},CustomBar:"0"}},onShow:function(){this.hasNext=!0,this.mescroll&&this.mescroll.resetUpScroll()},onLoad:function(){this.hasNext=!0,this.mescroll&&this.mescroll.resetUpScroll()},methods:{mescrollInit:function(t){this.mescroll=t},downCallback:function(t){this.hasNext=!0,t.resetUpScroll()},upCallback:function(t){var e=this;return s(a.default.mark((function n(){var r;return a.default.wrap((function(n){while(1)switch(n.prev=n.next){case 0:return n.next=2,e.$api.list("exampaper",{page:t.num,limit:t.size});case 2:r=n.sent,1==t.num&&(e.list=[]),e.list=e.list.concat(r.data.list),0==r.data.list.length&&(e.hasNext=!1),t.endSuccess(t.size,e.hasNext);case 7:case"end":return n.stop()}}),n)})))()},onDetailTap:function(t){this.$utils.jump("./detail?id=".concat(t.id))},onUpdateTap:function(t){this.$utils.jump("./add-or-update?id=".concat(t))},onAddTap:function(){this.$utils.jump("./add-or-update")},onDeleteTap:function(e){var n=this;t.showModal({title:"提示",content:"是否确认删除",success:function(){var t=s(a.default.mark((function t(r){return a.default.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(!r.confirm){t.next=5;break}return t.next=3,n.$api.del("exampaper",JSON.stringify([e]));case 3:n.hasNext=!0,n.mescroll.resetUpScroll();case 5:case"end":return t.stop()}}),t)})));function r(e){return t.apply(this,arguments)}return r}()})},search:function(){var t=this;return s(a.default.mark((function e(){var n,r;return a.default.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return t.mescroll.num=1,n={page:t.mescroll.num,limit:t.mescroll.size},t.searchForm.name&&(n["name"]="%"+t.searchForm.name+"%"),e.next=5,t.$api.list("exampaper",n);case 5:r=e.sent,1==t.mescroll.num&&(t.list=[]),t.list=t.list.concat(r.data.list),0==r.data.list.length&&(t.hasNext=!1),t.mescroll.endSuccess(t.mescroll.size,t.hasNext);case 10:case"end":return e.stop()}}),e)})))()}}};e.default=o}).call(this,n("543d")["default"])},b52b:function(t,e,n){}},[["0b66","common/runtime","common/vendor"]]]);