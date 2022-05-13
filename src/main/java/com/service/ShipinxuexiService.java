package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShipinxuexiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShipinxuexiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShipinxuexiView;


/**
 * 视频学习
 *
 * @author 
 * @email 
 * @date 2021-03-01 15:10:42
 */
public interface ShipinxuexiService extends IService<ShipinxuexiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShipinxuexiVO> selectListVO(Wrapper<ShipinxuexiEntity> wrapper);
   	
   	ShipinxuexiVO selectVO(@Param("ew") Wrapper<ShipinxuexiEntity> wrapper);
   	
   	List<ShipinxuexiView> selectListView(Wrapper<ShipinxuexiEntity> wrapper);
   	
   	ShipinxuexiView selectView(@Param("ew") Wrapper<ShipinxuexiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShipinxuexiEntity> wrapper);
   	
}

