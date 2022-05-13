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
 * 在线学习
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-03-01 15:10:42
 */
@TableName("zaixianxuexi")
public class ZaixianxuexiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZaixianxuexiEntity() {
		
	}
	
	public ZaixianxuexiEntity(T t) {
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
	 * 教学名称
	 */
					
	private String jiaoxuemingcheng;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 教学视频
	 */
					
	private String jiaoxueshipin;
	
	/**
	 * 教学文档
	 */
					
	private String jiaoxuewendang;
	
	/**
	 * 教学内容
	 */
					
	private String jiaoxueneirong;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date fabushijian;
	
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
	 * 设置：教学名称
	 */
	public void setJiaoxuemingcheng(String jiaoxuemingcheng) {
		this.jiaoxuemingcheng = jiaoxuemingcheng;
	}
	/**
	 * 获取：教学名称
	 */
	public String getJiaoxuemingcheng() {
		return jiaoxuemingcheng;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：教学视频
	 */
	public void setJiaoxueshipin(String jiaoxueshipin) {
		this.jiaoxueshipin = jiaoxueshipin;
	}
	/**
	 * 获取：教学视频
	 */
	public String getJiaoxueshipin() {
		return jiaoxueshipin;
	}
	/**
	 * 设置：教学文档
	 */
	public void setJiaoxuewendang(String jiaoxuewendang) {
		this.jiaoxuewendang = jiaoxuewendang;
	}
	/**
	 * 获取：教学文档
	 */
	public String getJiaoxuewendang() {
		return jiaoxuewendang;
	}
	/**
	 * 设置：教学内容
	 */
	public void setJiaoxueneirong(String jiaoxueneirong) {
		this.jiaoxueneirong = jiaoxueneirong;
	}
	/**
	 * 获取：教学内容
	 */
	public String getJiaoxueneirong() {
		return jiaoxueneirong;
	}
	/**
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
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
