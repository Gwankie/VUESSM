package com.entity.view;

import com.entity.DiscussshipinxuexiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 视频学习评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-01 15:10:42
 */
@TableName("discussshipinxuexi")
public class DiscussshipinxuexiView  extends DiscussshipinxuexiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussshipinxuexiView(){
	}
 
 	public DiscussshipinxuexiView(DiscussshipinxuexiEntity discussshipinxuexiEntity){
 	try {
			BeanUtils.copyProperties(this, discussshipinxuexiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
