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


import com.dao.ShipinxuexiDao;
import com.entity.ShipinxuexiEntity;
import com.service.ShipinxuexiService;
import com.entity.vo.ShipinxuexiVO;
import com.entity.view.ShipinxuexiView;

@Service("shipinxuexiService")
public class ShipinxuexiServiceImpl extends ServiceImpl<ShipinxuexiDao, ShipinxuexiEntity> implements ShipinxuexiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShipinxuexiEntity> page = this.selectPage(
                new Query<ShipinxuexiEntity>(params).getPage(),
                new EntityWrapper<ShipinxuexiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShipinxuexiEntity> wrapper) {
		  Page<ShipinxuexiView> page =new Query<ShipinxuexiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShipinxuexiVO> selectListVO(Wrapper<ShipinxuexiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShipinxuexiVO selectVO(Wrapper<ShipinxuexiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShipinxuexiView> selectListView(Wrapper<ShipinxuexiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShipinxuexiView selectView(Wrapper<ShipinxuexiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
