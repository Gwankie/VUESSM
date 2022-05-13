package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussshipinxuexiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussshipinxuexiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussshipinxuexiView;



public interface DiscussshipinxuexiService extends IService<DiscussshipinxuexiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussshipinxuexiVO> selectListVO(Wrapper<DiscussshipinxuexiEntity> wrapper);
   	
   	DiscussshipinxuexiVO selectVO(@Param("ew") Wrapper<DiscussshipinxuexiEntity> wrapper);
   	
   	List<DiscussshipinxuexiView> selectListView(Wrapper<DiscussshipinxuexiEntity> wrapper);
   	
   	DiscussshipinxuexiView selectView(@Param("ew") Wrapper<DiscussshipinxuexiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussshipinxuexiEntity> wrapper);
   	
}

