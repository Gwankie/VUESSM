<template>
	<view class="content">
		<form>
			
									<view class="cu-form-group">
				<view class="title">课程名称</view>
				<input v-model="ruleForm.kechengmingcheng" placeholder="课程名称"></input>
			</view>
												<view class="cu-form-group">
				<view class="title">名师姓名</view>
				<input v-model="ruleForm.mingshixingming" placeholder="名师姓名"></input>
			</view>
												<view class="cu-form-group">
				<view class="title">教龄</view>
				<input v-model="ruleForm.jiaoling" placeholder="教龄"></input>
			</view>
												<view class="cu-form-group" @tap="kechengtupianTap">
				<view class="title">课程图片</view>
				<view class="right-input">
					<image class="avator" v-if="ruleForm.kechengtupian" :src="ruleForm.kechengtupian" mode="widthFix"></image>
					<image class="avator" v-else src="../../static/gen/upload.png" mode="widthFix"></image>
				</view>
			</view>
												<view class="cu-form-group">
				<view class="title">课程类型</view>
				<input v-model="ruleForm.kechengleixing" placeholder="课程类型"></input>
			</view>
												<view class="cu-form-group">
				<view class="title">适合专业</view>
				<input v-model="ruleForm.shihezhuanye" placeholder="适合专业"></input>
			</view>
												<view class="cu-form-group">
				<view class="title">课程价格</view>
				<input v-model="ruleForm.kechengjiage" placeholder="课程价格"></input>
			</view>
																					<view class="cu-form-group">
				<view class="title">赞</view>
				<input v-model="ruleForm.thumbsupnum" placeholder="赞"></input>
			</view>
												<view class="cu-form-group">
				<view class="title">踩</view>
				<input v-model="ruleForm.crazilynum" placeholder="踩"></input>
			</view>
												<view class="cu-form-group">
				<view class="title">最近点击时间</view>
				<input v-model="ruleForm.clicktime" placeholder="最近点击时间" @tap="toggleTab('clicktime')"></input>
			</view>
												<view class="cu-form-group">
				<view class="title">点击次数</view>
				<input v-model="ruleForm.clicknum" placeholder="点击次数"></input>
			</view>
									
			<!-- 否 -->
 
			
			          				          				          				          				          				          				          				          				          				          				          				          							
			          				          				          				          				          				          				          				          				<view class="cu-form-group">
				<view class="title">课程简介</view>
				<textarea v-model="ruleForm.kechengjianjie" placeholder="课程简介"></textarea>
			</view>
						          				          				          				          							
			<button @tap="onSubmitTap" class="bg-red margin-tb-sm">提交</button>
		</form>

																																														<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="clicktimeConfirm" ref="clicktime" themeColor="#333333"></w-picker>
											
	</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";

	export default {
		data() {
			return {
				ruleForm: {
												kechengmingcheng: '',
																mingshixingming: '',
																jiaoling: '',
																kechengtupian: '',
																kechengleixing: '',
																shihezhuanye: '',
																kechengjiage: '',
																kechengjianjie: '',
																thumbsupnum: '',
																crazilynum: '',
																clicktime: '',
																clicknum: '',
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
			
						// ss读取
																																																																														
																																																																																	
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
				res = await this.$api.info(`mingshituijian`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
										if(o=='kechengmingcheng'){
					this.ruleForm.kechengmingcheng = obj[o];
					continue;
					}
										if(o=='mingshixingming'){
					this.ruleForm.mingshixingming = obj[o];
					continue;
					}
										if(o=='jiaoling'){
					this.ruleForm.jiaoling = obj[o];
					continue;
					}
										if(o=='kechengtupian'){
					this.ruleForm.kechengtupian = obj[o];
					continue;
					}
										if(o=='kechengleixing'){
					this.ruleForm.kechengleixing = obj[o];
					continue;
					}
										if(o=='shihezhuanye'){
					this.ruleForm.shihezhuanye = obj[o];
					continue;
					}
										if(o=='kechengjiage'){
					this.ruleForm.kechengjiage = obj[o];
					continue;
					}
										if(o=='kechengjianjie'){
					this.ruleForm.kechengjianjie = obj[o];
					continue;
					}
										if(o=='thumbsupnum'){
					this.ruleForm.thumbsupnum = obj[o];
					continue;
					}
										if(o=='crazilynum'){
					this.ruleForm.crazilynum = obj[o];
					continue;
					}
										if(o=='clicktime'){
					this.ruleForm.clicktime = obj[o];
					continue;
					}
										if(o=='clicknum'){
					this.ruleForm.clicknum = obj[o];
					continue;
					}
									}
																																																																																																							}
		},
		methods: {
																																																																														
			// 多级联动参数
																																																																														
																																																																											
																																																																					// 日长控件选择日期时间
			clicktimeConfirm(val) {
				console.log(val)
				this.ruleForm.clicktime = val.result;
				this.$forceUpdate();
			},
												
																																																																											
																																													kechengtupianTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.kechengtupian = _this.$base.url + 'upload/' + res.file;
					_this.$forceUpdate();
				});
			},
																																																																																																												
			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																												if((!this.ruleForm.kechengjiage)){
					this.$utils.msg(`课程价格不能为空`);
					return
				}
												if(this.ruleForm.kechengjiage&&(!this.$validate.isIntNumer(this.ruleForm.kechengjiage))){
					this.$utils.msg(`课程价格应输入整数`);
					return
				}
																																																																								if(this.ruleForm.thumbsupnum&&(!this.$validate.isIntNumer(this.ruleForm.thumbsupnum))){
					this.$utils.msg(`赞应输入整数`);
					return
				}
																																								if(this.ruleForm.crazilynum&&(!this.$validate.isIntNumer(this.ruleForm.crazilynum))){
					this.$utils.msg(`踩应输入整数`);
					return
				}
																																																																								if(this.ruleForm.clicknum&&(!this.$validate.isIntNumer(this.ruleForm.clicknum))){
					this.$utils.msg(`点击次数应输入整数`);
					return
				}
																																if(this.ruleForm.id){
					await this.$api.update(`mingshituijian`, this.ruleForm);
				}else{
					await this.$api.add(`mingshituijian`, this.ruleForm);
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
