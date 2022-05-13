package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 名师推荐
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-03-01 15:10:42
 */
@TableName("mingshituijian")
public class MingshituijianEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public MingshituijianEntity() {
		
	}
	
	public MingshituijianEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 课程名称
	 */
					
	private String kechengmingcheng;
	
	/**
	 * 名师姓名
	 */
					
	private String mingshixingming;
	
	/**
	 * 教龄
	 */
					
	private String jiaoling;
	
	/**
	 * 课程图片
	 */
					
	private String kechengtupian;
	
	/**
	 * 课程类型
	 */
					
	private String kechengleixing;
	
	/**
	 * 适合专业
	 */
					
	private String shihezhuanye;
	
	/**
	 * 课程价格
	 */
					
	private Integer kechengjiage;
	
	/**
	 * 课程简介
	 */
					
	private String kechengjianjie;
	
	/**
	 * 赞
	 */
					
	private Integer thumbsupnum;
	
	/**
	 * 踩
	 */
					
	private Integer crazilynum;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	/**
	 * 点击次数
	 */
					
	private Integer clicknum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：课程名称
	 */
	public void setKechengmingcheng(String kechengmingcheng) {
		this.kechengmingcheng = kechengmingcheng;
	}
	/**
	 * 获取：课程名称
	 */
	public String getKechengmingcheng() {
		return kechengmingcheng;
	}
	/**
	 * 设置：名师姓名
	 */
	public void setMingshixingming(String mingshixingming) {
		this.mingshixingming = mingshixingming;
	}
	/**
	 * 获取：名师姓名
	 */
	public String getMingshixingming() {
		return mingshixingming;
	}
	/**
	 * 设置：教龄
	 */
	public void setJiaoling(String jiaoling) {
		this.jiaoling = jiaoling;
	}
	/**
	 * 获取：教龄
	 */
	public String getJiaoling() {
		return jiaoling;
	}
	/**
	 * 设置：课程图片
	 */
	public void setKechengtupian(String kechengtupian) {
		this.kechengtupian = kechengtupian;
	}
	/**
	 * 获取：课程图片
	 */
	public String getKechengtupian() {
		return kechengtupian;
	}
	/**
	 * 设置：课程类型
	 */
	public void setKechengleixing(String kechengleixing) {
		this.kechengleixing = kechengleixing;
	}
	/**
	 * 获取：课程类型
	 */
	public String getKechengleixing() {
		return kechengleixing;
	}
	/**
	 * 设置：适合专业
	 */
	public void setShihezhuanye(String shihezhuanye) {
		this.shihezhuanye = shihezhuanye;
	}
	/**
	 * 获取：适合专业
	 */
	public String getShihezhuanye() {
		return shihezhuanye;
	}
	/**
	 * 设置：课程价格
	 */
	public void setKechengjiage(Integer kechengjiage) {
		this.kechengjiage = kechengjiage;
	}
	/**
	 * 获取：课程价格
	 */
	public Integer getKechengjiage() {
		return kechengjiage;
	}
	/**
	 * 设置：课程简介
	 */
	public void setKechengjianjie(String kechengjianjie) {
		this.kechengjianjie = kechengjianjie;
	}
	/**
	 * 获取：课程简介
	 */
	public String getKechengjianjie() {
		return kechengjianjie;
	}
	/**
	 * 设置：赞
	 */
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
	/**
	 * 设置：踩
	 */
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
	/**
	 * 设置：点击次数
	 */
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}

}
