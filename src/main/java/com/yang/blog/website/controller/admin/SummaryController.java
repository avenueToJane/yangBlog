package com.yang.blog.website.controller.admin;



import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.yang.blog.website.constant.WebConst;
import com.yang.blog.website.controller.BaseController;
import com.yang.blog.website.dto.Types;
import com.yang.blog.website.exception.TipException;
import com.yang.blog.website.model.Bo.RestResponseBo;
import com.yang.blog.website.model.Vo.ContentVo;
import com.yang.blog.website.model.Vo.ContentVoExample;
import com.yang.blog.website.model.Vo.SummaryVo;
import com.yang.blog.website.model.Vo.UserVo;
import com.yang.blog.website.service.ISummaryService;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * 
* <p>Title: SummaryController </p>
* <p>Description: </p>
* <p>Company: xxx</p> 
* @author Mr.yang
* @date 2018年11月2日 下午5:43:25
 */
@Controller
@RequestMapping("/admin/summary")
@Transactional(rollbackFor = TipException.class)
public class SummaryController extends BaseController {

    private static final Logger LOGGER = Logger.getLogger(SummaryController.class);
    
    @Resource
    private ISummaryService summaryService;
    
    @GetMapping(value = "")
    public String index(HttpServletRequest request) {
       
        return "admin/summary_edit";
    }
    
  
    
    @PostMapping(value = "add")
    @ResponseBody
    public RestResponseBo add(@RequestParam String title, @RequestParam String content, HttpServletRequest request) {
    	if(StringUtil.isEmpty(content)) {
    		String msg = "纪要事件不能为空";
            return RestResponseBo.fail(msg);
    	}
    	SummaryVo summaryVo =new SummaryVo();
       summaryVo.setTitle(title);
       summaryVo.setContent(content);
       //创建日期
       Date date = new Date(); 
       DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒 EE", Locale.CHINA); 
       summaryVo.setCreateTime(df.format(date));
       LOGGER.info("新增纪要事件 ："+summaryVo);
       summaryService.add(summaryVo); 
 
       return RestResponseBo.ok();
    }
    
    @PostMapping(value = "delete")
    @ResponseBody
    public RestResponseBo delete(@RequestParam Integer id,  HttpServletRequest request) {
       SummaryVo summaryVo =new SummaryVo();
       summaryVo.setId(id);
       LOGGER.info("删除纪要事件 ："+summaryVo);
       summaryService.delete(summaryVo); 
       return RestResponseBo.ok();
    }
    
    @PostMapping(value = "detail")
    @ResponseBody
    public RestResponseBo detail(@RequestParam Integer id,  HttpServletRequest request) {
       SummaryVo summaryVo =new SummaryVo();
       summaryVo.setId(id);
       summaryVo= summaryService.detail(summaryVo); 
       LOGGER.info("查询纪要事件 ："+summaryVo);
       return RestResponseBo.ok(summaryVo);
    }
    
    @PostMapping(value = "saveSummary")
    @ResponseBody
    public RestResponseBo saveSummary(@RequestParam Integer id,@RequestParam String title, @RequestParam String content, HttpServletRequest request) {
    	
       SummaryVo summaryVo =new SummaryVo();
       summaryVo.setTitle(title);
       summaryVo.setId(id);
       summaryVo.setContent(content);
       //创建日期
       Date date = new Date(); 
       DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒 EE", Locale.CHINA); 
       summaryVo.setCreateTime(df.format(date));
       LOGGER.info("修改纪要事件 ："+summaryVo);
       summaryService.editSummary(summaryVo); 
       return RestResponseBo.ok();
    }
    


}
