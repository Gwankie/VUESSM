<template>
	<view class="content">
		<form>
			<view class="cu-form-group">
				<view class="title">留言人</view>
				<input v-model="ruleForm.username" placeholder="留言人用户名"></input>
			</view>
			<view class="cu-form-group">
				<view class="title">留言内容</view>
				<textarea v-model="ruleForm.content" placeholder="留言内容"></textarea>
			</view>
			<button @tap="onSubmitTap" class="bg-red margin-tb-sm">提交</button>
		</form>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				ruleForm: {
					userid: '',
					username: '',
					content: '',
					reply: '',
				},
				user: {}
			}
		},
		async onLoad(options) {
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			// 如果有登陆，获取登陆后保存的userid
			this.ruleForm.userid = uni.getStorageSync("userid")
            						                                    if(table == `yonghu`){
                this.ruleForm.username = this.user.zhanghao
            }
                                                                                                                                                                                                						            			            			            			            			            			            			            			            			            			            			            			            			            		},
		methods: {
			async onSubmitTap() {
				if(this.ruleForm.content){
					await this.$api.add(`messages`, this.ruleForm);
					this.$utils.msgBack('提交成功');
				}else{
					this.$utils.msg("请填写留言内容")
				}
			}
		}
	}
</script>

<style lang="scss" scoped>
	.container {
		padding: 20upx;
	}

	textarea {
		border: 1upx solid #EEEEEE;
		border-radius: 20upx;
		padding: 20upx;
	}

	.title {
		width: 180upx;
	}

	.avator {
		width: 150upx;
		height: 60upx;
	}

	.right-input {
		flex: 1;
		text-align: left;
	}
</style>
