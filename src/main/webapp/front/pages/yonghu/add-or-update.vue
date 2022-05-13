<template>
	<view class="content">
		<form>
			
									<view class="cu-form-group">
				<view class="title">账号</view>
				<input v-model="ruleForm.zhanghao" placeholder="账号"></input>
			</view>
												<view class="cu-form-group">
				<view class="title">密码</view>
				<input v-model="ruleForm.mima" placeholder="密码"></input>
			</view>
												<view class="cu-form-group">
				<view class="title">姓名</view>
				<input v-model="ruleForm.xingming" placeholder="姓名"></input>
			</view>
												<view class="cu-form-group">
				<view class="title">性别</view>
				<picker @change="xingbieChange" :value="xingbieIndex" :range="xingbieOptions">
					<view class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
				</picker>
			</view>
												<view class="cu-form-group">
				<view class="title">手机</view>
				<input v-model="ruleForm.shouji" placeholder="手机"></input>
			</view>
												<view class="cu-form-group">
				<view class="title">邮箱</view>
				<input v-model="ruleForm.youxiang" placeholder="邮箱"></input>
			</view>
												<view class="cu-form-group" @tap="touxiangTap">
				<view class="title">头像</view>
				<view class="right-input">
					<image class="avator" v-if="ruleForm.touxiang" :src="ruleForm.touxiang" mode="widthFix"></image>
					<image class="avator" v-else src="../../static/gen/upload.png" mode="widthFix"></image>
				</view>
			</view>
																		
			<!-- 否 -->
 
			
			          				          				          				          				          				          				          				          				<view class="cu-form-group">
				<view class="title">备注</view>
				<textarea v-model="ruleForm.beizhu" placeholder="备注"></textarea>
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
												zhanghao: '',
																mima: '',
																xingming: '',
																xingbie: '',
																shouji: '',
																youxiang: '',
																touxiang: '',
																beizhu: '',
												},
																																				xingbieOptions: [],
				xingbieIndex: 0,
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
			
						// ss读取
																																																						
																														// 自定义下拉框值
			this.xingbieOptions = "男,女".split(',')
																																	
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
				res = await this.$api.info(`yonghu`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
										if(o=='zhanghao'){
					this.ruleForm.zhanghao = obj[o];
					continue;
					}
										if(o=='mima'){
					this.ruleForm.mima = obj[o];
					continue;
					}
										if(o=='xingming'){
					this.ruleForm.xingming = obj[o];
					continue;
					}
										if(o=='xingbie'){
					this.ruleForm.xingbie = obj[o];
					continue;
					}
										if(o=='shouji'){
					this.ruleForm.shouji = obj[o];
					continue;
					}
										if(o=='youxiang'){
					this.ruleForm.youxiang = obj[o];
					continue;
					}
										if(o=='touxiang'){
					this.ruleForm.touxiang = obj[o];
					continue;
					}
										if(o=='beizhu'){
					this.ruleForm.beizhu = obj[o];
					continue;
					}
									}
																																																																							}
		},
		methods: {
																																																						
			// 多级联动参数
																																																						
																																																			
																																																			
																											// 下拉变化
			xingbieChange(e) {
				this.xingbieIndex = e.target.value
				this.ruleForm.xingbie = this.xingbieOptions[this.xingbieIndex]
			},
																														
																																																																																	touxiangTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.touxiang = _this.$base.url + 'upload/' + res.file;
					_this.$forceUpdate();
				});
			},
																								
			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {
																																																																																																																																																																																																																																																																																																																												if((!this.ruleForm.zhanghao)){
					this.$utils.msg(`账号不能为空`);
					return
				}
																																								if((!this.ruleForm.mima)){
					this.$utils.msg(`密码不能为空`);
					return
				}
																																																																																																																																																								if(this.ruleForm.youxiang&&(!this.$validate.isEmail(this.ruleForm.youxiang))){
					this.$utils.msg(`邮箱应输入邮件格式`);
					return
				}
																																																																																				if(this.ruleForm.id){
					await this.$api.update(`yonghu`, this.ruleForm);
				}else{
					await this.$api.add(`yonghu`, this.ruleForm);
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
