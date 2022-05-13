<template>
	<view class="content">
		<view class="logo">
			<image src="/static/login/logo.png" mode=""></image>
		</view>
		<view class="uni-form-item uni-column">
			<input v-model="username" type="text" class="uni-input" name="" placeholder="请输入账号" />
		</view>
		<view class="uni-form-item uni-column">
			<input v-model="password" type="password" class="uni-input" name="" placeholder="请输入密码" />
		</view>
		<view class="uni-form-item uni-column">
			<picker @change="optionsChange" :value="index" :range="options">
				<view class="uni-input">{{options[index]}}</view>
			</picker>
		</view>
		<button @tap="onLoginTap" type="primary">登录</button>
		<view class="links">
            			            			            			            			            			            			            			            			            			            			            			            			            			            		</view>
		<view class="links">
			<view @tap="onForgetTap">忘记密码？</view>
		</view>
	</view>
</template>

<script>
	import menu from '@/utils/menu'

	export default {
		data() {
			return {
				username: '',
				password: '',
				options: [
					'请选择登录用户类型'
				],
                optionsValues: [
					'',
					                                        'yonghu',
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        				],
				index: 0
			}
		},
		onLoad() {
			let options = ['请选择登录用户类型'];
			let menus = menu.list();
			this.menuList = menus;
			for(let i=0;i<this.menuList.length;i++){
				if(this.menuList[i].roleName!='管理员'){
					options.push(this.menuList[i].roleName);
				}
			}
			this.options = options;
		},
		methods: {
			onRegisterTap(tableName) {
                uni.setStorageSync("loginTable", tableName);
				this.$utils.jump('../register/register')
			},
			onForgetTap() {
				this.$utils.jump('../forget/forget')
			},
			async onLoginTap() {
                if (!this.optionsValues[this.index]) {
					this.$utils.msg('请选择登陆用户类型')
					return
				}
				let res = await this.$api.login(`${this.optionsValues[this.index]}`, {
					username: this.username,
					password: this.password
				});
				uni.setStorageSync("token", res.token);
				uni.setStorageSync("nowTable", `${this.optionsValues[this.index]}`);
				res = await this.$api.session(`${this.optionsValues[this.index]}`);
				// 保存用户id
				uni.setStorageSync("userid", res.data.id);
				uni.setStorageSync("role", `${this.options[this.index]}`);
				this.$utils.tab('../index/index');
			},
			optionsChange(e) {
				this.index = e.target.value
			}
		}
	}
</script>

<style lang="scss" scoped>
	$color-primary: #b49950;

	.content {
		padding: 100upx;
	}

	.logo {
		text-align: center;

		image {
			height: 200upx;
			width: 200upx;
			margin: 0 0 60upx;
		}
	}

	.uni-form-item {
		margin-bottom: 40upx;
		padding: 0;
		border-bottom: 1px solid #e3e3e3;

		.uni-input {
			font-size: 30upx;
			padding: 7px 0;
		}
	}

	button[type="primary"] {
		background-color: $color-primary;
		border-radius: 0;
		font-size: 34upx;
		margin-top: 60upx;
	}

	.links {
		text-align: center;
		margin-top: 40upx;
		font-size: 26upx;
		color: #999;

		view {
			display: inline-block;
			vertical-align: top;
			margin: 0 10upx;
		}

		.link-highlight {
			color: $color-primary
		}
	}
</style>
