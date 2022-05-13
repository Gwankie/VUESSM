package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MingshituijianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MingshituijianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MingshituijianView;


/**
 * 名师推荐
 *
 * @author 
 * @email 
 * @date 2021-03-01 15:10:42
 */
public interface MingshituijianService extends IService<MingshituijianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MingshituijianVO> selectListVO(Wrapper<MingshituijianEntity> wrapper);
   	
   	MingshituijianVO selectVO(@Param("ew") Wrapper<MingshituijianEntity> wrapper);
   	
   	List<MingshituijianView> selectListView(Wrapper<MingshituijianEntity> wrapper);
   	
   	MingshituijianView selectView(@Param("ew") Wrapper<MingshituijianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MingshituijianEntity> wrapper);
   	
}

