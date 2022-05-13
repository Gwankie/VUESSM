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


import com.dao.DiscussshipinxuexiDao;
import com.entity.DiscussshipinxuexiEntity;
import com.service.DiscussshipinxuexiService;
import com.entity.vo.DiscussshipinxuexiVO;
import com.entity.view.DiscussshipinxuexiView;

@Service("discussshipinxuexiService")
public class DiscussshipinxuexiServiceImpl extends ServiceImpl<DiscussshipinxuexiDao, DiscussshipinxuexiEntity> implements DiscussshipinxuexiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussshipinxuexiEntity> page = this.selectPage(
                new Query<DiscussshipinxuexiEntity>(params).getPage(),
                new EntityWrapper<DiscussshipinxuexiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussshipinxuexiEntity> wrapper) {
		  Page<DiscussshipinxuexiView> page =new Query<DiscussshipinxuexiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussshipinxuexiVO> selectListVO(Wrapper<DiscussshipinxuexiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussshipinxuexiVO selectVO(Wrapper<DiscussshipinxuexiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussshipinxuexiView> selectListView(Wrapper<DiscussshipinxuexiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussshipinxuexiView selectView(Wrapper<DiscussshipinxuexiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
