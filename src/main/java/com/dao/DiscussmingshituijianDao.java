package com.dao;

import com.entity.DiscussmingshituijianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussmingshituijianVO;
import com.entity.view.DiscussmingshituijianView;


/**
 * 名师推荐评论表
 * 
 * @author 
 * @email 
 * @date 2021-03-01 15:10:42
 */
public interface DiscussmingshituijianDao extends BaseMapper<DiscussmingshituijianEntity> {
	
	List<DiscussmingshituijianVO> selectListVO(@Param("ew") Wrapper<DiscussmingshituijianEntity> wrapper);
	
	DiscussmingshituijianVO selectVO(@Param("ew") Wrapper<DiscussmingshituijianEntity> wrapper);
	
	List<DiscussmingshituijianView> selectListView(@Param("ew") Wrapper<DiscussmingshituijianEntity> wrapper);

	List<DiscussmingshituijianView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussmingshituijianEntity> wrapper);
	
	DiscussmingshituijianView selectView(@Param("ew") Wrapper<DiscussmingshituijianEntity> wrapper);
	
}
