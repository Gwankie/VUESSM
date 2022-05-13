<template>
	<view class="content">
		<form>
			
									<view class="cu-form-group">
				<view class="title">名称</view>
				<input v-model="ruleForm.name" placeholder="名称"></input>
			</view>
												<view class="cu-form-group" @tap="valueTap">
				<view class="title">值</view>
				<view class="right-input">
					<image class="avator" v-if="ruleForm.value" :src="ruleForm.value" mode="widthFix"></image>
					<image class="avator" v-else src="../../static/gen/upload.png" mode="widthFix"></image>
				</view>
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
																value: '',
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
				res = await this.$api.info(`config`, this.ruleForm.id);
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
										if(o=='value'){
					this.ruleForm.value = obj[o];
					continue;
					}
									}
																							}
		},
		methods: {
																		
			// 多级联动参数
																		
															
															
															
																					valueTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.value = _this.$base.url + 'upload/' + res.file;
					_this.$forceUpdate();
				});
			},
												
			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {
																																																																																																				if((!this.ruleForm.name)){
					this.$utils.msg(`名称不能为空`);
					return
				}
																																																																				if(this.ruleForm.id){
					await this.$api.update(`config`, this.ruleForm);
				}else{
					await this.$api.add(`config`, this.ruleForm);
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
