<template>
	<view>
		<swiper class="swiper" indicator-dots="true" autoplay="true" circular="true" indicator-active-color="#ffffff">
			<swiper-item v-for="(swiper,index) in swiperList" :key="index">
				<image mode="aspectFill" :src="swiper"></image>
			</swiper-item>
		</swiper>
		<view class="detail-content">
			<view class="name">
				名称：{{detail.name}}
			</view>
			<view class="address">
				地址：{{detail.address}}
			</view>
			<view class="description">
				简介：{{detail.description}}
			</view>
		</view>

		<view class="time-content">
			<view class="header">
				提交预定
			</view>
			<form class="time-form">
				<view class="cu-form-group">
					<view class="title">预定开始</view>
					<view>
						{{detail.starttime}}
					</view>
				</view>
				<view class="cu-form-group">
					<view class="title">预定结束</view>
					<view>
						{{detail.endtime}}
					</view>
				</view>
				<view class="cu-form-group">
					<view class="title">选择座位</view>
					<view>
						{{activeSeat}}号
					</view>
				</view>
				<view class="btn-content">
					<button @tap="onSubmitTap" class="btn-submit cu-btn round bg-red">预定</button>
				</view>
			</form>
		</view>

		<view class="seat-list">
			<view v-for="(item,index) in numberList " v-bind:key="index" class="seat-item">
				<image @tap="$utils.msg('该座位已被预定')" v-if="selectStr.indexOf(item)>=0||(activeSeat+'号')==item" class="seat-icon" src="../../static/restaurant-detail/select.png"
				 mode=""></image>
				<image @tap="selectSeat(index+1)" v-else class="seat-icon" src="../../static/restaurant-detail/unselect.png" mode=""></image>
				<text>{{item}}</text>
			</view>
		</view>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				//轮播
				swiperList: [],
				numberList: [],
				selectStr: '',
				detail: {},
				activeSeat: '',
			}
		},
		async onLoad(options) {
			let res = await this.$api.seats.detail(options.id);
			this.detail = res.data
			this.swiperList = res.data.picture ? res.data.picture.split(",") : ""
			for (let i = 1; i <= this.detail.number; i++) {
				this.numberList.push(`${i}号`);
			}
			if (this.detail.selected) {
				let selected = this.detail.selected.split(",");
				let selectList = []
				for (let i = 0; i < selected.length; i++) {
					selectList.push(`${selected[i]}号`);
				}
				this.selectStr = selectList.join(",")
			}
		},
		methods: {
			selectSeat(idx) {
				this.activeSeat = `${idx}`
			},
			onSubmitTap() {
				let _this = this;
				if (!this.activeSeat) {
					this.$utils.msg('请选择要预定的座位');
					return
				}
				uni.showModal({
					title: '提示',
					content: '是否确认预定',
					success: async function(res) {
						if (res.confirm) {
							if (_this.detail.selected) {
								_this.detail.selected = _this.detail.selected + "," + _this.activeSeat
							} else {
								_this.detail.selected = _this.detail.selected + _this.activeSeat
							}
							let data = {
								orderid: _this.$utils.genTradeNo(),
								tablename: 'seats',
								userid: '',
								goodid: _this.detail.id,
								goodname: _this.detail.name,
								picture: _this.swiperList ? _this.swiperList[0] : "",
								buynumber: 1,
								discountprice: 0,
								total: 0,
								discounttotal: 0,
								type: 1,
								total: 0,
								address: _this.activeSeat,
								status: '已支付'
							}
							if (_this.$global.system == 'seats-restaurant') {
								data['price'] = 0
								await _this.$api.orders.save(data);
								await _this.$api.seats.update(_this.detail);
								_this.$utils.msgBack('预定成功');
							} else if (_this.$global.system == 'seats-film') {
								data['price'] = _this.detail.price
								// await _this.$api.orders.save(data);
								// await _this.$api.seats.update(_this.detail);
								uni.setStorageSync('order', data);
								uni.setStorageSync('seat', _this.detail);
								_this.$utils.jump('../seats-order-confirm/seats-order-confirm');
							}

						}
					}
				});
			}
		}
	}
</script>

<style lang="scss">
	page {
		background: #EEEEEE;
	}

	.swiper {
		width: 100%;

		image {
			width: 100%;
		}
	}

	.detail-content {
		font-size: 28upx;
		color: #888888;
		padding: 10upx 20upx;
		background: #FFFFFF;
		line-height: 45upx;
	}


	.time-content {
		margin: 20upx;
		background: #FFFFFF;
		padding: 30upx;
		font-size: 30upx;
		border-radius: 20upx;

		.header {
			font-size: 33upx;
			margin-bottom: 20upx;
		}

		.cu-form-group {
			color: #888888;
		}
	}

	.seat-list {
		display: flex;
		align-items: center;
		flex-wrap: wrap;
		background: #FFFFFF;
		margin: 20upx;
		border-radius: 20upx;
		padding: 20upx;
		font-size: 30upx;

		.seat-item {
			width: 33.33%;
			display: flex;
			align-items: center;
			flex-direction: column;
			margin-bottom: 20upx;

			.seat-icon {
				width: 50upx;
				height: 50upx;
				margin-bottom: 10upx;
			}
		}
	}

	.btn-content {
		text-align: center;
		margin-top: 20upx;

		.btn-submit {
			width: 50%;
		}
	}
</style>
