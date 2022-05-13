package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussmingshituijianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussmingshituijianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussmingshituijianView;



public interface DiscussmingshituijianService extends IService<DiscussmingshituijianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussmingshituijianVO> selectListVO(Wrapper<DiscussmingshituijianEntity> wrapper);
   	
   	DiscussmingshituijianVO selectVO(@Param("ew") Wrapper<DiscussmingshituijianEntity> wrapper);
   	
   	List<DiscussmingshituijianView> selectListView(Wrapper<DiscussmingshituijianEntity> wrapper);
   	
   	DiscussmingshituijianView selectView(@Param("ew") Wrapper<DiscussmingshituijianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussmingshituijianEntity> wrapper);
   	
}

