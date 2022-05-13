<template>
	<view class="content">
		<form>
			
																		<view class="cu-form-group">
				<view class="title">用户名</view>
				<input v-model="ruleForm.username" placeholder="用户名"></input>
			</view>
												<view class="cu-form-group">
				<view class="title">试卷id（外键）</view>
				<input v-model="ruleForm.paperid" placeholder="试卷id（外键）"></input>
			</view>
												<view class="cu-form-group">
				<view class="title">试卷名称</view>
				<input v-model="ruleForm.papername" placeholder="试卷名称"></input>
			</view>
												<view class="cu-form-group">
				<view class="title">试题id（外键）</view>
				<input v-model="ruleForm.questionid" placeholder="试题id（外键）"></input>
			</view>
												<view class="cu-form-group">
				<view class="title">试题名称</view>
				<input v-model="ruleForm.questionname" placeholder="试题名称"></input>
			</view>
																					<view class="cu-form-group">
				<view class="title">分值</view>
				<input v-model="ruleForm.score" placeholder="分值"></input>
			</view>
												<view class="cu-form-group">
				<view class="title">正确答案</view>
				<input v-model="ruleForm.answer" placeholder="正确答案"></input>
			</view>
																					<view class="cu-form-group">
				<view class="title">试题得分</view>
				<input v-model="ruleForm.myscore" placeholder="试题得分"></input>
			</view>
												<view class="cu-form-group">
				<view class="title">考生答案</view>
				<input v-model="ruleForm.myanswer" placeholder="考生答案"></input>
			</view>
									
			<!-- ${location} -->
 
			
			          				          				          				          				          				          				          				<view class="cu-form-group">
				<view class="title">选项，json字符串</view>
				<textarea v-model="ruleForm.options" placeholder="选项，json字符串"></textarea>
			</view>
						          				          				          				<view class="cu-form-group">
				<view class="title">答案解析</view>
				<textarea v-model="ruleForm.analysis" placeholder="答案解析"></textarea>
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
																username: '',
																paperid: '',
																papername: '',
																questionid: '',
																questionname: '',
																options: '',
																score: '',
																answer: '',
																analysis: '',
																myscore: '',
																myanswer: '',
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
				res = await this.$api.info(`examrecord`, this.ruleForm.id);
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
										if(o=='username'){
					this.ruleForm.username = obj[o];
					continue;
					}
										if(o=='paperid'){
					this.ruleForm.paperid = obj[o];
					continue;
					}
										if(o=='papername'){
					this.ruleForm.papername = obj[o];
					continue;
					}
										if(o=='questionid'){
					this.ruleForm.questionid = obj[o];
					continue;
					}
										if(o=='questionname'){
					this.ruleForm.questionname = obj[o];
					continue;
					}
										if(o=='options'){
					this.ruleForm.options = obj[o];
					continue;
					}
										if(o=='score'){
					this.ruleForm.score = obj[o];
					continue;
					}
										if(o=='answer'){
					this.ruleForm.answer = obj[o];
					continue;
					}
										if(o=='analysis'){
					this.ruleForm.analysis = obj[o];
					continue;
					}
										if(o=='myscore'){
					this.ruleForm.myscore = obj[o];
					continue;
					}
										if(o=='myanswer'){
					this.ruleForm.myanswer = obj[o];
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
																																																																								if((!this.ruleForm.paperid)){
					this.$utils.msg(`试卷id（外键）不能为空`);
					return
				}
																																								if((!this.ruleForm.papername)){
					this.$utils.msg(`试卷名称不能为空`);
					return
				}
																																								if((!this.ruleForm.questionid)){
					this.$utils.msg(`试题id（外键）不能为空`);
					return
				}
																																								if((!this.ruleForm.questionname)){
					this.$utils.msg(`试题名称不能为空`);
					return
				}
																																																																																																																																																																								if((!this.ruleForm.myscore)){
					this.$utils.msg(`试题得分不能为空`);
					return
				}
																																																																				if(this.ruleForm.id){
					await this.$api.update(`examrecord`, this.ruleForm);
				}else{
					await this.$api.add(`examrecord`, this.ruleForm);
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
