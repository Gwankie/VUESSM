<template>
	<view class="content">
		<view class="logo">
			<image src="/static/login/logo.png" mode=""></image>
		</view>
										<view v-if="tableName=='yonghu'" class="uni-form-item uni-column">
			<input v-model="ruleForm.zhanghao" type="text" class="uni-input" name="" placeholder="账号" />
		</view>
								<view v-if="tableName=='yonghu'" class="uni-form-item uni-column">
			<input v-model="ruleForm.mima" type="text" class="uni-input" name="" placeholder="密码" />
		</view>
								<view v-if="tableName=='yonghu'" class="uni-form-item uni-column">
			<input v-model="ruleForm.xingming" type="text" class="uni-input" name="" placeholder="姓名" />
		</view>
														<view v-if="tableName=='yonghu'" class="uni-form-item uni-column">
			<input v-model="ruleForm.shouji" type="text" class="uni-input" name="" placeholder="手机" />
		</view>
								<view v-if="tableName=='yonghu'" class="uni-form-item uni-column">
			<input v-model="ruleForm.youxiang" type="text" class="uni-input" name="" placeholder="邮箱" />
		</view>
																																																																						<button @tap="register" type="primary">注册</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				ruleForm: {
				},
				tableName:"",
			}
		},
		onLoad() {
			let table = uni.getStorageSync("loginTable");
    		this.tableName = table;
		},
		methods: {
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 注册
			async register() {
																				if((!this.ruleForm.zhanghao) && `yonghu` == this.tableName){
					this.$utils.msg(`账号不能为空`);
					return
				}
																																								if((!this.ruleForm.mima) && `yonghu` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
																																																																																																																																																								if(`yonghu` == this.tableName && this.ruleForm.youxiang&&(!this.$validate.isEmail(this.ruleForm.youxiang))){
					this.$utils.msg(`邮箱应输入邮件格式`);
					return
				}
																																																																																																																																																																																												await this.$api.register(`${this.tableName}`, this.ruleForm);
				this.$utils.msgBack('注册成功');;
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
