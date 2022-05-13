package com.dao;

import com.entity.DiscussshipinxuexiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussshipinxuexiVO;
import com.entity.view.DiscussshipinxuexiView;


/**
 * 视频学习评论表
 * 
 * @author 
 * @email 
 * @date 2021-03-01 15:10:42
 */
public interface DiscussshipinxuexiDao extends BaseMapper<DiscussshipinxuexiEntity> {
	
	List<DiscussshipinxuexiVO> selectListVO(@Param("ew") Wrapper<DiscussshipinxuexiEntity> wrapper);
	
	DiscussshipinxuexiVO selectVO(@Param("ew") Wrapper<DiscussshipinxuexiEntity> wrapper);
	
	List<DiscussshipinxuexiView> selectListView(@Param("ew") Wrapper<DiscussshipinxuexiEntity> wrapper);

	List<DiscussshipinxuexiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshipinxuexiEntity> wrapper);
	
	DiscussshipinxuexiView selectView(@Param("ew") Wrapper<DiscussshipinxuexiEntity> wrapper);
	
}
