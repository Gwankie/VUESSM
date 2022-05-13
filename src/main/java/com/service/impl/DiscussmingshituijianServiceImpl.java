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


import com.dao.DiscussmingshituijianDao;
import com.entity.DiscussmingshituijianEntity;
import com.service.DiscussmingshituijianService;
import com.entity.vo.DiscussmingshituijianVO;
import com.entity.view.DiscussmingshituijianView;

@Service("discussmingshituijianService")
public class DiscussmingshituijianServiceImpl extends ServiceImpl<DiscussmingshituijianDao, DiscussmingshituijianEntity> implements DiscussmingshituijianService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussmingshituijianEntity> page = this.selectPage(
                new Query<DiscussmingshituijianEntity>(params).getPage(),
                new EntityWrapper<DiscussmingshituijianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussmingshituijianEntity> wrapper) {
		  Page<DiscussmingshituijianView> page =new Query<DiscussmingshituijianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussmingshituijianVO> selectListVO(Wrapper<DiscussmingshituijianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussmingshituijianVO selectVO(Wrapper<DiscussmingshituijianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussmingshituijianView> selectListView(Wrapper<DiscussmingshituijianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussmingshituijianView selectView(Wrapper<DiscussmingshituijianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
