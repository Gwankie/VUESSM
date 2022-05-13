package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.MingshituijianEntity;
import com.entity.view.MingshituijianView;

import com.service.MingshituijianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 名师推荐
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-01 15:10:42
 */
@RestController
@RequestMapping("/mingshituijian")
public class MingshituijianController {
    @Autowired
    private MingshituijianService mingshituijianService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MingshituijianEntity mingshituijian, HttpServletRequest request){

        EntityWrapper<MingshituijianEntity> ew = new EntityWrapper<MingshituijianEntity>();
		PageUtils page = mingshituijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mingshituijian), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MingshituijianEntity mingshituijian, HttpServletRequest request){
        EntityWrapper<MingshituijianEntity> ew = new EntityWrapper<MingshituijianEntity>();
		PageUtils page = mingshituijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mingshituijian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MingshituijianEntity mingshituijian){
       	EntityWrapper<MingshituijianEntity> ew = new EntityWrapper<MingshituijianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( mingshituijian, "mingshituijian")); 
        return R.ok().put("data", mingshituijianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MingshituijianEntity mingshituijian){
        EntityWrapper< MingshituijianEntity> ew = new EntityWrapper< MingshituijianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( mingshituijian, "mingshituijian")); 
		MingshituijianView mingshituijianView =  mingshituijianService.selectView(ew);
		return R.ok("查询名师推荐成功").put("data", mingshituijianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MingshituijianEntity mingshituijian = mingshituijianService.selectById(id);
		mingshituijian.setClicknum(mingshituijian.getClicknum()+1);
		mingshituijian.setClicktime(new Date());
		mingshituijianService.updateById(mingshituijian);
        return R.ok().put("data", mingshituijian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MingshituijianEntity mingshituijian = mingshituijianService.selectById(id);
		mingshituijian.setClicknum(mingshituijian.getClicknum()+1);
		mingshituijian.setClicktime(new Date());
		mingshituijianService.updateById(mingshituijian);
        return R.ok().put("data", mingshituijian);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        MingshituijianEntity mingshituijian = mingshituijianService.selectById(id);
        if(type.equals("1")) {
        	mingshituijian.setThumbsupnum(mingshituijian.getThumbsupnum()+1);
        } else {
        	mingshituijian.setCrazilynum(mingshituijian.getCrazilynum()+1);
        }
        mingshituijianService.updateById(mingshituijian);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MingshituijianEntity mingshituijian, HttpServletRequest request){
    	mingshituijian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(mingshituijian);

        mingshituijianService.insert(mingshituijian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MingshituijianEntity mingshituijian, HttpServletRequest request){
    	mingshituijian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(mingshituijian);

        mingshituijianService.insert(mingshituijian);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MingshituijianEntity mingshituijian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(mingshituijian);
        mingshituijianService.updateById(mingshituijian);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        mingshituijianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<MingshituijianEntity> wrapper = new EntityWrapper<MingshituijianEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = mingshituijianService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,MingshituijianEntity mingshituijian, HttpServletRequest request,String pre){
        EntityWrapper<MingshituijianEntity> ew = new EntityWrapper<MingshituijianEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        
        params.put("order", "desc");
		PageUtils page = mingshituijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mingshituijian), params), params));
        return R.ok().put("data", page);
    }


}
