package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.MingshituijianDao;
import com.entity.MingshituijianEntity;
import com.service.MingshituijianService;
import com.entity.vo.MingshituijianVO;
import com.entity.view.MingshituijianView;

@Service("mingshituijianService")
public class MingshituijianServiceImpl extends ServiceImpl<MingshituijianDao, MingshituijianEntity> implements MingshituijianService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MingshituijianEntity> page = this.selectPage(
                new Query<MingshituijianEntity>(params).getPage(),
                new EntityWrapper<MingshituijianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MingshituijianEntity> wrapper) {
		  Page<MingshituijianView> page =new Query<MingshituijianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<MingshituijianVO> selectListVO(Wrapper<MingshituijianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MingshituijianVO selectVO(Wrapper<MingshituijianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MingshituijianView> selectListView(Wrapper<MingshituijianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MingshituijianView selectView(Wrapper<MingshituijianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
