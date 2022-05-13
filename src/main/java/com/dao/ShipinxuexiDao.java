package com.dao;

import com.entity.ShipinxuexiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShipinxuexiVO;
import com.entity.view.ShipinxuexiView;


/**
 * 视频学习
 * 
 * @author 
 * @email 
 * @date 2021-03-01 15:10:42
 */
public interface ShipinxuexiDao extends BaseMapper<ShipinxuexiEntity> {
	
	List<ShipinxuexiVO> selectListVO(@Param("ew") Wrapper<ShipinxuexiEntity> wrapper);
	
	ShipinxuexiVO selectVO(@Param("ew") Wrapper<ShipinxuexiEntity> wrapper);
	
	List<ShipinxuexiView> selectListView(@Param("ew") Wrapper<ShipinxuexiEntity> wrapper);

	List<ShipinxuexiView> selectListView(Pagination page,@Param("ew") Wrapper<ShipinxuexiEntity> wrapper);
	
	ShipinxuexiView selectView(@Param("ew") Wrapper<ShipinxuexiEntity> wrapper);
	
}
