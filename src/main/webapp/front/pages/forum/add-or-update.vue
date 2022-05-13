<template>
	<view class="content">
		<form>
			
									<view class="cu-form-group">
				<view class="title">帖子标题</view>
				<input v-model="ruleForm.title" placeholder="帖子标题"></input>
			</view>
																					<view class="cu-form-group">
				<view class="title">父节点id</view>
				<input v-model="ruleForm.parentid" placeholder="父节点id"></input>
			</view>
																					<view class="cu-form-group">
				<view class="title">用户名</view>
				<input v-model="ruleForm.username" placeholder="用户名"></input>
			</view>
												<view class="cu-form-group">
				<view class="title">状态</view>
				<picker @change="isdoneChange" :value="isdoneIndex" :range="isdoneOptions">
					<view class="uni-input">{{ruleForm.isdone?ruleForm.isdone:"请选择状态"}}</view>
				</picker>
			</view>
									
			<!-- ${location} -->
 
			
			          				          				          				          				          				          							
			          				          				<view class="cu-form-group">
				<view class="title">帖子内容</view>
				<textarea v-model="ruleForm.content" placeholder="帖子内容"></textarea>
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
												title: '',
																content: '',
																parentid: '',
																userid: '',
																username: '',
																isdone: '',
												},
																																																				isdoneOptions: [],
				isdoneIndex: 0,
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
			
			
																																										// 自定义下拉框值
			this.isdoneOptions = "开放,关闭".split(',')
									
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
				res = await this.$api.info(`forum`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
										if(o=='title'){
					this.ruleForm.title = obj[o];
					continue;
					}
										if(o=='content'){
					this.ruleForm.content = obj[o];
					continue;
					}
										if(o=='parentid'){
					this.ruleForm.parentid = obj[o];
					continue;
					}
										if(o=='userid'){
					this.ruleForm.userid = obj[o];
					continue;
					}
										if(o=='username'){
					this.ruleForm.username = obj[o];
					continue;
					}
										if(o=='isdone'){
					this.ruleForm.isdone = obj[o];
					continue;
					}
									}
																																																							}
		},
		methods: {
																																										
			// 多级联动参数
																																										
																																							
																																							
																																							// 下拉变化
			isdoneChange(e) {
				this.isdoneIndex = e.target.value
				this.ruleForm.isdone = this.isdoneOptions[this.isdoneIndex]
			},
						
																																																																											
			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {
																																																																																																																																																																																																																																																																																				if((!this.ruleForm.content)){
					this.$utils.msg(`帖子内容不能为空`);
					return
				}
																																																																								if((!this.ruleForm.userid)){
					this.$utils.msg(`用户id不能为空`);
					return
				}
																																																																																																				if(this.ruleForm.id){
					await this.$api.update(`forum`, this.ruleForm);
				}else{
					await this.$api.add(`forum`, this.ruleForm);
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
