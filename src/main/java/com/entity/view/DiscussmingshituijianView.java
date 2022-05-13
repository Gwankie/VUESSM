package com.entity.view;

import com.entity.DiscussmingshituijianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 名师推荐评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-01 15:10:42
 */
@TableName("discussmingshituijian")
public class DiscussmingshituijianView  extends DiscussmingshituijianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussmingshituijianView(){
	}
 
 	public DiscussmingshituijianView(DiscussmingshituijianEntity discussmingshituijianEntity){
 	try {
			BeanUtils.copyProperties(this, discussmingshituijianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
