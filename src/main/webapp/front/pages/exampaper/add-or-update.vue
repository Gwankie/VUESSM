<template>
	<view class="content">
		<form>
			
									<view class="cu-form-group">
				<view class="title">试卷名称</view>
				<input v-model="ruleForm.name" placeholder="试卷名称"></input>
			</view>
												<view class="cu-form-group">
				<view class="title">考试时长(分钟)</view>
				<input v-model="ruleForm.time" placeholder="考试时长(分钟)"></input>
			</view>
												<view class="cu-form-group">
				<view class="title">试卷状态</view>
				<picker @change="statusChange" :value="statusIndex" :range="statusOptions">
					<view class="uni-input">{{ruleForm.status?ruleForm.status:"请选择试卷状态"}}</view>
				</picker>
			</view>
									
			<!-- ${location} -->
 
			
			          				          				          							
			          				          				          							
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
												name: '',
																time: '',
																status: '',
												},
																												statusOptions: [],
				statusIndex: 0,
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
			this.statusOptions = "禁用 ,启用".split(',')
									
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
				res = await this.$api.info(`exampaper`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
										if(o=='name'){
					this.ruleForm.name = obj[o];
					continue;
					}
										if(o=='time'){
					this.ruleForm.time = obj[o];
					continue;
					}
										if(o=='status'){
					this.ruleForm.status = obj[o];
					continue;
					}
									}
																															}
		},
		methods: {
																								
			// 多级联动参数
																								
																					
																					
																					// 下拉变化
			statusChange(e) {
				this.statusIndex = e.target.value
				this.ruleForm.status = this.statusOptions[this.statusIndex]
			},
						
																																							
			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {
																																																																																																																																								if((!this.ruleForm.name)){
					this.$utils.msg(`试卷名称不能为空`);
					return
				}
																																								if((!this.ruleForm.time)){
					this.$utils.msg(`考试时长(分钟)不能为空`);
					return
				}
												if(this.ruleForm.time&&(!this.$validate.isIntNumer(this.ruleForm.time))){
					this.$utils.msg(`考试时长(分钟)应输入整数`);
					return
				}
																																				if((!this.ruleForm.status)){
					this.$utils.msg(`试卷状态不能为空`);
					return
				}
												if(this.ruleForm.status&&(!this.$validate.isIntNumer(this.ruleForm.status))){
					this.$utils.msg(`试卷状态应输入整数`);
					return
				}
																																if(this.ruleForm.id){
					await this.$api.update(`exampaper`, this.ruleForm);
				}else{
					await this.$api.add(`exampaper`, this.ruleForm);
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
