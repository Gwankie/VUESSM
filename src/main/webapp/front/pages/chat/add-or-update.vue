<template>
	<view class="content">
		<form>
			
																		<view class="cu-form-group">
				<view class="title">管理员id</view>
				<input v-model="ruleForm.adminid" placeholder="管理员id"></input>
			</view>
																														<view class="cu-form-group">
				<view class="title">是否回复</view>
				<input v-model="ruleForm.isreply" placeholder="是否回复"></input>
			</view>
									
			<!-- ${location} -->
 
			
			          				          				          				<view class="cu-form-group">
				<view class="title">提问</view>
				<textarea v-model="ruleForm.ask" placeholder="提问"></textarea>
			</view>
						          				<view class="cu-form-group">
				<view class="title">回复</view>
				<textarea v-model="ruleForm.reply" placeholder="回复"></textarea>
			</view>
						          							
			          				          				          				          				          							
			<button @tap="onSubmitTap" class="bg-red margin-tb-sm">提交</button>
		</form>

																									
	</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";

	export default {
		data() {
			return {
				ruleForm: {
												userid: '',
																adminid: '',
																ask: '',
																reply: '',
																isreply: '',
												},
																																																// 登陆用户信息
				user: {}
			}
		},
		components: {
			wPicker
		},
		computed: {
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
					},
		async onLoad(options) {
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			
																																							
			// 如果有登陆，获取登陆后保存的userid
			this.ruleForm.userid = uni.getStorageSync("userid")
			if (options.refid) {
				// 如果上一级页面传递了refid，获取改refid数据信息
				this.ruleForm.refid = options.refid;
			}
			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				res = await this.$api.info(`chat`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
										if(o=='userid'){
					this.ruleForm.userid = obj[o];
					continue;
					}
										if(o=='adminid'){
					this.ruleForm.adminid = obj[o];
					continue;
					}
										if(o=='ask'){
					this.ruleForm.ask = obj[o];
					continue;
					}
										if(o=='reply'){
					this.ruleForm.reply = obj[o];
					continue;
					}
										if(o=='isreply'){
					this.ruleForm.isreply = obj[o];
					continue;
					}
									}
																																															}
		},
		methods: {
																																				
			// 多级联动参数
																																				
																																	
																																	
																																	
																																																															
			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {
																																																																																																																																																																																																																if((!this.ruleForm.userid)){
					this.$utils.msg(`用户id不能为空`);
					return
				}
																																																																																																																																												if(this.ruleForm.isreply&&(!this.$validate.isIntNumer(this.ruleForm.isreply))){
					this.$utils.msg(`是否回复应输入整数`);
					return
				}
																																if(this.ruleForm.id){
					await this.$api.update(`chat`, this.ruleForm);
				}else{
					await this.$api.add(`chat`, this.ruleForm);
				}
				this.$utils.msgBack('提交成功');
			},
			optionsChange(e) {
				this.index = e.target.value
			},
			bindDateChange(e) {
				this.date = e.target.value
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				this.$refs[str].show();
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
