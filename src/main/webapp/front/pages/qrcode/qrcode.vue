<template>
	<view class="content">
		<tki-qrcode class="bg-code" cid="inviteCode" ref="qrcode" :val="qhCodeOptions.val" :size="qhCodeOptions.size" :unit="qhCodeOptions.unit"
		 :icon="qhCodeOptions.icon" :iconSize="qhCodeOptions.iconsize" :usingComponents="true" :lv="qhCodeOptions.lv" :onval="qhCodeOptions.onval"
		 :loadMake="qhCodeOptions.loadMake" />
	</view>
</template>

<script>
	import tkiQrcode from '@/components/tki-qrcode/tki-qrcode.vue'
	export default {
		data() {
			return {
				qhCodeOptions: {
					val: '', // 要生成的二维码值
					size: 500, // 二维码大小
					unit: 'upx', // 单位
					// background: '', // 背景色
					// foreground: '', // 前景色
					// pdground: '', // 角标色
					icon: '/static/logo.png', // 二维码图标
					iconsize: 40, // 二维码图标大小
					lv: 3, // 二维码容错级别 ， 一般不用设置，默认就行
					onval: true, // val值变化时自动重新生成二维码
					loadMake: true, // 组件加载完成后自动生成二维码
				}
			};
		},
		created() {
			console.log("qrcode created")
			this.qhCodeOptions.val = this.$base.url;
		},
		components: {
			tkiQrcode
		}
	}
</script>

<style lang="scss">
	.bg-image {
		position: absolute;
		width: 100%;
		bottom: 0;
	}

	.bg-code {
		position: absolute;
		width: 60%;
		height: 30%;
		left: 20%;
		top: 20%;
	}
</style>



<style>

</style>
