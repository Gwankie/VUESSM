package com.dao;

import com.entity.MingshituijianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MingshituijianVO;
import com.entity.view.MingshituijianView;


/**
 * 名师推荐
 * 
 * @author 
 * @email 
 * @date 2021-03-01 15:10:42
 */
public interface MingshituijianDao extends BaseMapper<MingshituijianEntity> {
	
	List<MingshituijianVO> selectListVO(@Param("ew") Wrapper<MingshituijianEntity> wrapper);
	
	MingshituijianVO selectVO(@Param("ew") Wrapper<MingshituijianEntity> wrapper);
	
	List<MingshituijianView> selectListView(@Param("ew") Wrapper<MingshituijianEntity> wrapper);

	List<MingshituijianView> selectListView(Pagination page,@Param("ew") Wrapper<MingshituijianEntity> wrapper);
	
	MingshituijianView selectView(@Param("ew") Wrapper<MingshituijianEntity> wrapper);
	
}
