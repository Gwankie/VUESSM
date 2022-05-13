<template>
	<view class="uni-padding-wrap">
		<view class="header">
			<view class="headerb">
				<swiper class="swiper" indicator-dots="true" autoplay="true" circular="true" indicator-active-color="#ffffff">
					<swiper-item v-for="(swiper,index) in swiperList" :key="index" @tap="onSwiperTap(swiper)">
						<image mode="aspectFill" :src="swiper.img"></image>
					</swiper-item>
				</swiper>
			</view>
		</view>
		
										<!--header end-->
		<text class="pl15 col3" style="font-size: 36upx;font-weight: bold;">名师推荐推荐</text>
		<view class="uni-product-list">
			<view @tap="onDetailTap('mingshituijian',product.id)" class="uni-product" v-for="(product,index) in mingshituijianlist" :key="index">
				                				<view class="uni-product-title">{{product.kechengmingcheng}}</view>
								                				                				                				<view class="image-view">
					<image mode="aspectFill" class="uni-product-image" :src="product.kechengtupian?product.kechengtupian.split(',')[0]:''"></image>
				</view>
                				                				                				                				                				                				                				                				                							</view>
		</view>
		<!--list end-->
								<!--header end-->
		<text class="pl15 col3" style="font-size: 36upx;font-weight: bold;">视频学习推荐</text>
		<view class="uni-product-list">
			<view @tap="onDetailTap('shipinxuexi',product.id)" class="uni-product" v-for="(product,index) in shipinxuexilist" :key="index">
				                				<view class="uni-product-title">{{product.jiaoxuebiaoti}}</view>
								                				<view class="image-view">
					<image mode="aspectFill" class="uni-product-image" :src="product.tupianfengmian?product.tupianfengmian.split(',')[0]:''"></image>
				</view>
                				                				                				                				                				                				                				                							</view>
		</view>
		<!--list end-->
								<!--header end-->
		<text class="pl15 col3" style="font-size: 36upx;font-weight: bold;">在线学习推荐</text>
		<view class="uni-product-list">
			<view @tap="onDetailTap('zaixianxuexi',product.id)" class="uni-product" v-for="(product,index) in zaixianxuexilist" :key="index">
				                				<view class="uni-product-title">{{product.jiaoxuemingcheng}}</view>
								                				<view class="image-view">
					<image mode="aspectFill" class="uni-product-image" :src="product.tupian?product.tupian.split(',')[0]:''"></image>
				</view>
                				                				                				                				                				                				                				                				                							</view>
		</view>
		<!--list end-->
																																										
																		<view class="pl15 col3 header-title" style="font-size: 36upx;font-weight: bold;">
			<view class="left">
				在线学习
			</view>
			<view class="right-content" @tap="onPageTap('zaixianxuexi')">
				查看更多
			</view>
		</view>
		<view class="uni-product-list">
			<view @tap="onDetailTap('zaixianxuexi',product.id)" class="uni-product" v-for="(product,index) in homezaixianxuexilist" :key="index">
				                				<view class="uni-product-title">{{product.jiaoxuemingcheng}}</view>
								                				<view class="image-view">
					<image mode="aspectFill" class="uni-product-image" :src="product.tupian?product.tupian.split(',')[0]:''"></image>
				</view>
                				                				                				                				                				                				                				                				                							</view>
		</view>
		<!--list end-->
																																								
																																																						
	</view>
</template>

<script>
	import '@/assets/css/global-restaurant.css'
	import uniIcons from "@/components/uni-ui/lib/uni-icons/uni-icons.vue"
	export default {
		components: {
			uniIcons
		},
		data() {
			return {
				//轮播
				swiperList: [{
						img: '/static/test/swiper-img/2.jpg'
					},
					{
						img: '/static/test/swiper-img/3.jpg'
					}
				],
																				mingshituijianlist: [],
																shipinxuexilist: [],
																zaixianxuexilist: [],
																																																																																																																				homezaixianxuexilist: [],
																																																																																				news: []
			}
		},
		async onShow() {
			// 轮播图
			let swiperList = []
			let res = await this.$api.page('config', {
				page: 1,
				limit: 5
			});
			for (let item of res.data.list) {
				if (item.name.indexOf('picture') >= 0 && item.value && item.value!="" && item.value!=null ) {
					console.log(item)
					swiperList.push({
						img: item.value
					});
				}
			}
			if (swiperList) {
				this.swiperList = swiperList;
			}
																																																																																				
															// 推荐信息
			res = await this.$api.recommend('mingshituijian', 1, 4);
			this.mingshituijianlist = res.data.list
												// 推荐信息
			res = await this.$api.recommend('shipinxuexi', 1, 4);
			this.shipinxuexilist = res.data.list
												// 推荐信息
			res = await this.$api.recommend('zaixianxuexi', 1, 4);
			this.zaixianxuexilist = res.data.list
																																																												
																											res = await this.$api.list('zaixianxuexi', {
				page: 1,
				limit: 4
			});
			this.homezaixianxuexilist = res.data.list
																																																														},
		methods: {
			//轮播图跳转
			onSwiperTap(e) {

			},
			// 新闻详情
			onNewsDetailTap(id) {
				this.$utils.jump(`../news-detail/news-detail?id=${id}`)
			},
			// 推荐列表点击详情
			onDetailTap(tableName, id) {
				this.$utils.jump(`../${tableName}/detail?id=${id}`)
			},
			onPageTap(tableName){
				uni.navigateTo({
					url: `../${tableName}/list`,
					fail: function(){
						uni.switchTab({
							url: `../${tableName}/list`
						});
					}
				});
				// this.$utils.jump(`../${tableName}/list`)
			}
		}
	}
</script>

<style>
	page {
		background: #F8F8F8;
	}

	view {
		font-family: '\5FAE\8F6F\96C5\9ED1';
		font-size: 30upx;
	}

	.header {
		background: #EEEEEE;
		padding: 15upx 20upx 255upx;
		margin-bottom: 80upx;
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
		top: 10upx;
		width: 100%;
		box-sizing: border-box;
		padding: 0 20upx;
	}

	.headerb image {
		width: 100%;
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
		padding: 20upx 20upx 20upx;
	}

	.listm {
		background: #fff;
		border-radius: 15upx;
		box-shadow: 0 0 2upx rgba(0, 0, 0, 0.1);
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

	.uni-product-list {
		display: flex;
		width: 100%;
		flex-wrap: wrap;
		flex-direction: row;
		margin-top: 10upx;
	}

	.uni-product {
		padding: 10upx;
		margin: 10upx;
		display: flex;
		flex-direction: column;
		background: #FFFFFF;
	}

	.image-view {
		height: 330upx;
		width: 330upx;
		margin: 12upx 0;
	}

	.uni-product-image {
		height: 330upx;
		width: 330upx;
	}

	.uni-product-title {
		width: 300upx;
		word-break: break-all;
		display: -webkit-box;
		overflow: hidden;
		line-height: 1.5;
		text-overflow: ellipsis;
		-webkit-box-orient: vertical;
		-webkit-line-clamp: 2;
	}

	.uni-product-price {
		margin-top: 10upx;
		font-size: 28upx;
		line-height: 1.5;
		position: relative;
	}

	.uni-product-price-original {
		color: #e80080;
	}

	.uni-product-price-favour {
		color: #888888;
		text-decoration: line-through;
		margin-left: 10upx;
	}

	.uni-product-tip {
		position: absolute;
		right: 10upx;
		background-color: #ff3333;
		color: #ffffff;
		padding: 0 10upx;
		border-radius: 5upx;
	}

	.header-title {
		display: flex;
		align-items: center;
		text-align: center;
		justify-content: space-between;
		padding: 0 40upx;
	}
</style>
