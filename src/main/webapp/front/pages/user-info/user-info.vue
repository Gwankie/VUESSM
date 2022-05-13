<template>
	<view class="content">
										<view v-if="tableName=='yonghu'" class="cu-form-group">
			<view class="title">账号</view>
			<input v-model="ruleForm.zhanghao" placeholder="账号"></input>
		</view>
								<view v-if="tableName=='yonghu'" class="cu-form-group">
			<view class="title">密码</view>
			<input v-model="ruleForm.mima" placeholder="密码"></input>
		</view>
								<view v-if="tableName=='yonghu'" class="cu-form-group">
			<view class="title">姓名</view>
			<input v-model="ruleForm.xingming" placeholder="姓名"></input>
		</view>
														<view v-if="tableName=='yonghu'" class="cu-form-group">
			<view class="title">手机</view>
			<input v-model="ruleForm.shouji" placeholder="手机"></input>
		</view>
								<view v-if="tableName=='yonghu'" class="cu-form-group">
			<view class="title">邮箱</view>
			<input v-model="ruleForm.youxiang" placeholder="邮箱"></input>
		</view>
								<view v-if="tableName=='yonghu'" @tap="yonghutouxiangTap" class="cu-form-group">
			<view class="title">头像</view>
			<image v-if="ruleForm.touxiang" class="avator" :src="ruleForm.touxiang" mode=""></image>
			<image v-else class="avator" src="../../static/center/face.jpeg" mode=""></image>
		</view>
																																																																		
		<view class="padding flex flex-direction" style="text-align: center;">
			<button @tap="update()" class="cu-btn bg-red lg">保存</button>
		</view>

		<view class="padding flex flex-direction" style="text-align: center;">
			<button @tap="logout()" class="cu-btn bg-grey lg">退出登录</button>
		</view>
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
		async onLoad() {
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table)
			this.ruleForm = res.data
			this.tableName = table;

																																																																																									},
		methods: {
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			logout() {
				uni.setStorageSync('token', '');
				this.$utils.jump('../login/login');
			},
			// 注册
			async update() {
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
																																																																																																																																																																																												let table = uni.getStorageSync("nowTable");
				await this.$api.update(table, this.ruleForm);
				this.$utils.msgBack('修改成功');;
			}

																																																			,yonghutouxiangTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.touxiang = _this.$base.url + 'upload/' + res.file;
					_this.$forceUpdate();
				});
			}
																																																																																												}
	}
</script>

<style lang="scss" scoped>
	.avator {
		width: 110upx;
		height: 110upx;
		border-radius: 50%;
		margin-left: 30upx;
	}

	.cu-btn {
		width: 100%;
	}

	.right-input {
		flex: 1;
		text-align: left;
	}
</style>
