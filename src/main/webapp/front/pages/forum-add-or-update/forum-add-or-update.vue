<template>
	<view class="container">
		<form>
			<view class="cu-form-group margin-top">
				<input v-model="forum.title" placeholder="标题"></input>
			</view>
			<view class="cu-form-group margin-top">
				<radio-group>
					<label class="radio">
						<radio @tap="setIsDoneTap('开放')" style="margin: 0 20upx;" value="开放" :checked="forum.isdone=='开放'" /><text>开放</text>
						<radio @tap="setIsDoneTap('关闭')" style="margin: 0 20upx;" value="关闭" :checked="forum.isdone=='关闭'" /><text>私人</text>
					</label>
				</radio-group>
			</view>
			<view class="cu-form-group margin-top">
				<textarea style="height: 500upx;" v-model="forum.content" placeholder="内容"></textarea>
			</view>
			<button @tap="onSubmitTap" class="bg-red margin-tb-sm">确认提交</button>
		</form>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				forum: {
					content: '',
					id: '',
					title: '',
					isdone: '开放',
					parentid: 0
				},
				username: '',
				user: {}
			}
		},
		async onLoad(options) {
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
									                                    if(table == `yonghu`){
                this.username = this.user.zhanghao
            }
                                                                                                                                                                                                						            			            			            			            			            			            			            			            			            			            			            			            			            			if (options.id) {
				this.id = options.id;
				let res = await this.$api.info('forum',this.id);
				this.forum = res.data
			}
		},
		methods: {
			async onSubmitTap() {
				this.forum.username = this.username;
				if (this.id) {
					await this.$api.update('forum',this.forum);
				} else {
					await this.$api.save('forum',this.forum);
				}
				this.$utils.msgBack('操作成功');
			},
			setIsDoneTap(isdone) {
				this.forum.isdone = isdone;
			},
		}
	}
</script>

<style>
	.container {
		padding: 20upx;
	}
</style>
