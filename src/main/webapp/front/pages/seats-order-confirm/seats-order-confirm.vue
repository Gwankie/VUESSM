<template>
	<view class="content">
		<form>
			<view class="cu-form-group">
				<view class="title">影院</view>
				<image class="avator" :src="order.picture" mode=""></image>
			</view>
			<view class="cu-form-group">
				<view class="title">名称</view>
				<input v-model="order.goodname" disabled></input>
			</view>
			<view class="cu-form-group">
				<view class="title">地址</view>
				<input v-model="seat.address" disabled></input>
			</view>
			<view class="cu-form-group">
				<view class="title">简介</view>
				<input v-model="seat.description" disabled></input>
			</view>
			<view class="cu-form-group margin-top">
				<view class="title">座位</view>
				<input v-model="order.address" disabled></input>
			</view>
			<view class="cu-form-group">
				<view class="title">开场</view>
				<input v-model="seat.starttime" disabled></input>
			</view>
			<view class="cu-form-group">
				<view class="title">结束</view>
				<input v-model="seat.endtime" disabled></input>
			</view>
			<view class="cu-form-group">
				<view class="title">价格</view>
				<input v-model="order.price" disabled></input>
			</view>
		</form>
		<view class="padding flex flex-direction" style="text-align: center;">
			<button @tap="update()" class="cu-btn bg-red lg">确认支付</button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				user: {},
				order: {},
				seat: {}
			}
		},
		async onLoad() {
			let res = await this.$api.user.session()
			this.user = res.data
			// 获取订单信息，座位信息
			this.order = uni.getStorageSync('order');
			this.seat = uni.getStorageSync('seat');
		},
		methods: {
			async update() {
				let _this = this;
				uni.showModal({
					title: '提示',
					content: '是否确认支付',
					success: async function(res) {
						if (res.confirm) {
							if (_this.user.money < _this.order.price) {
								_this.$utils.msg('余额不足，请先充值');
								return
							}
							_this.user.money = _this.user.money - _this.order.price;
							await _this.$api.user.update('defaultuser',_this.user);
							await _this.$api.orders.save(_this.order);
							await _this.$api.seats.update(_this.seat);
							_this.$utils.msgBack('支付成功');
						}
					}
				});
			}
		}
	}
</script>

<style lang="scss">
	.avator {
		width: 150upx;
		height: 150upx;
		margin: 20upx 0;
	}
</style>
