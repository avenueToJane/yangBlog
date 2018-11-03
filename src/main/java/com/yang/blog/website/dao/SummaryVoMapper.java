package com.yang.blog.website.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.yang.blog.website.model.Vo.SummaryVo;
@Component
public interface SummaryVoMapper {
	
	List<SummaryVo> selectSummarys();

	void addSummary(SummaryVo summaryVo);

	void deleteSummaryById(SummaryVo summaryVo);

	SummaryVo detail(SummaryVo summaryVo);

	void editSummary(SummaryVo summaryVo);

}
