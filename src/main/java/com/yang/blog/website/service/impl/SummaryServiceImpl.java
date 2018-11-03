package com.yang.blog.website.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.yang.blog.website.dao.SummaryVoMapper;
import com.yang.blog.website.model.Vo.SummaryVo;
import com.yang.blog.website.service.ISummaryService;

@Service
public class SummaryServiceImpl implements ISummaryService{
	
	 private static final Logger LOGGER = Logger.getLogger(SummaryServiceImpl.class);
	 
	 @Resource
	 private SummaryVoMapper summaryVoMapper;

	@Override
	public List<SummaryVo> selectSummarys() {
		
		return summaryVoMapper.selectSummarys();
	}

	@Override
	public void add(SummaryVo summaryVo) {
		 summaryVoMapper.addSummary(summaryVo);
		
	}

	@Override
	public void delete(SummaryVo summaryVo) {
		summaryVoMapper.deleteSummaryById(summaryVo);
		
	}

	@Override
	public SummaryVo detail(SummaryVo summaryVo) {
		
		return summaryVoMapper.detail(summaryVo);
	}

	@Override
	public void editSummary(SummaryVo summaryVo) {
		 summaryVoMapper.editSummary(summaryVo);
		
	}

}
