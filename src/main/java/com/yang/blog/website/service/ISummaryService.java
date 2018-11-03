package com.yang.blog.website.service;

import java.util.List;

import com.yang.blog.website.model.Vo.SummaryVo;

/**
 * 
* <p>Title: ISummaryService </p>
* <p>Description: </p>
* <p>Company: xxx</p> 
* @author Mr.yang
* @date 2018年11月2日 下午3:12:23
 */
public interface ISummaryService {
   
    List<SummaryVo> selectSummarys();

	void add(SummaryVo summaryVo);

	void delete(SummaryVo summaryVo);

	SummaryVo detail(SummaryVo summaryVo);

	void editSummary(SummaryVo summaryVo);
}
