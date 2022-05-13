<template>
	<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">

		<view class="uni-padding-wrap">
			<view class="header">
				<view class="headerb">
					<swiper class="swiper" indicator-dots="true" autoplay="true" circular="true" indicator-active-color="#ffffff">
						<swiper-item v-for="(swiper,index) in swiperList" :key="index" @tap="onSwiperTap(swiper)">
							<image mode="aspectFill" :src="swiper.img"></image>
						</swiper-item>
					</swiper>
					<view class="notice">
						<view class="noticem flex flex-align-center">
							<uni-icons type="sound" class="b" color="#f00"></uni-icons>
							<swiper :indicator-dots="false" :autoplay="true" :interval="3000" :duration="500" :vertical="true" class="noticer ml10">
								<swiper-item>
									<view class="swiper-item">这是平台公告这是平台公告这是平台公告</view>
								</swiper-item>
							</swiper>
						</view>
					</view>
				</view>
			</view>
			<!--header end-->
			<view class="list">
				<view class="flex flex-between flex-align-center pl15 pb30">
					<text v-if="$global.system=='seats-restaurant'" class="f28 col3">餐厅列表</text>
					<text v-if="$global.system=='seats-film'" class="f28 col3">影院列表</text>
					<!-- <text class="f24 col9">查看全部</text> -->
				</view>
				<view @tap="onDetailTap(item.id)" v-for="(item,index) in list " v-bind:key="index" class="listm flex flex-between">
					<image :src="item.picture" mode="widthFix" class="listmpic mt10"></image>
					<view class="listmr">
						<view class="col3 f30 elip mb15">{{item.name}}</view>
						<view class="colb f24 lh35">地址:{{item.address}}</view>
						<view class="colb f24 lh35 mt15 elip">描述:{{item.description}}</view>
						<view class="flex flex-align-center mt20">
							<text class="colb f25">座位数：{{item.number}}</text>
						</view>
					</view>
				</view>
			</view>
			<!--list end-->
		</view>
	</mescroll-uni>
</template>

<script>
	import '@/assets/css/global-restaurant.css'
	import uniIcons from "@/components/uni-ui/lib/uni-icons/uni-icons.vue"
	import uniNoticeBar from "@/components/uni-ui/lib/uni-notice-bar/uni-notice-bar.vue"
	export default {
		components: {
			uniIcons,
			uniNoticeBar
		},
		data() {
			return {
				//轮播
				swiperList: [{
						img: '/static/test/swiper-img/0.jpg'
					},
					{
						img: '/static/test/swiper-img/1.jpg'
					},
					{
						img: '/static/test/swiper-img/2.jpg'
					},
					{
						img: '/static/test/swiper-img/3.jpg'
					}
				],
				list: [],
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					page: {
						// num: 0, // 当前页码,默认0,回调之前会加1,即callback(page)会从1开始
						// size: 5 // 每页数据的数量
					},
					noMoreSize: 3, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true
			}
		},
		async onShow() {
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		methods: {
			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},
			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				// 重置分页参数页数为1
				mescroll.resetUpScroll()
			},
			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				let res = await this.$api.seats.list(mescroll.num, mescroll.size);
				// 如果是第一页数据置空
				if (mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);
			},
			// 餐厅详情
			onDetailTap(id) {
				this.$utils.jump(`../seats-detail/seats-detail?id=${id}`)
			},
			//轮播图跳转
			onSwiperTap(e) {

			},
		}
	}
</script>

<style>
	view {
		font-family: '\5FAE\8F6F\96C5\9ED1';
		font-size: 30upx;
	}

	page {
		background: #ededed;
	}

	.header {
		background: #f39800;
		padding: 15upx 20upx 255upx;
		position: relative;
	}

	.ssbox {
		background: rgba(255, 255, 255, 0.35);
		width: 530upx;
		border-radius: 60rpx;
		padding: 10upx 15upx;
		box-sizing: border-box;
	}

	.ss_input {
		border: none;
		width: 450upx;
		font-size: 30upx;
		color: #fff;
		background: none;
		height: 45upx;
		line-break: 45upx;
	}

	.headerb {
		position: absolute;
		left: 0;
		top: 60upx;
		width: 100%;
		box-sizing: border-box;
		padding: 0 20upx;
	}

	.headerb image {
		width: 710upx;
		box-shadow: 0 10upx 10px rgba(0, 0, 0, 0.3);
		border-radius: 40upx;
		position: relative;
		z-index: 10;
	}

	.notice {
		position: relative;
		z-index: 5;
		padding: 0 50upx;
	}

	.noticem {
		background: #fff;
		padding: 55upx 30upx 15upx;
		border-radius: 10upx;
		box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
		margin-top: -45upx;
	}

	.noticer {
		width: 480upx;
		height: 50upx;
	}

	.noticer .swiper-item {
		white-space: nowrap;
		text-overflow: ellipsis;
		overflow: hidden;
		height: 50upx;
		line-height: 50upx;
		font-size: 24upx;
	}

	.list {
		padding: 200upx 20upx 20upx;
	}

	.listm {
		background: #fff;
		border-radius: 15upx;
		box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
		margin-bottom: 20upx;
		padding: 30upx;
	}

	.listmpic {
		border-radius: 10upx;
		width: 166upx;
	}

	.listmr {
		width: 460upx;
		display: inline-block;
	}

	/* #ifdef MP-WEIXIN */
	.noticer .swiper-item {
		margin-top: 5upx;
	}

	/* #endif */
	/* #ifdef MP-BAIDU */
	.noticer .swiper-item {
		margin-top: 3upx;
	}

	/* #endif */
	/* #ifdef MP-ALIPAY */
	.noticer .swiper-item {
		margin-top: 2upx;
	}

	/* #endif */
	/* #ifdef MP-QQ */
	.noticer .swiper-item {
		margin-top: 4upx;
	}

	/* #endif */
	/* #ifdef MP-TOUTIAO */
	.noticer .swiper-item {
		margin-top: 4upx;
	}

	/* #endif */
</style>
