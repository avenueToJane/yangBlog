package com.yang.blog.website.service.impl;

import com.github.pagehelper.PageHelper;
import com.yang.blog.website.constant.WebConst;
import com.yang.blog.website.dao.LogVoMapper;
import com.yang.blog.website.model.Vo.LogVo;
import com.yang.blog.website.model.Vo.LogVoExample;
import com.yang.blog.website.service.ILogService;
import com.yang.blog.website.utils.DateKit;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by BlueT on 2017/3/4.
 */
@Service
public class LogServiceImpl implements ILogService {

    private static final Logger LOGGER = Logger.getLogger(LogServiceImpl.class);

    @Resource
    private LogVoMapper logDao;

    @Override
    public void insertLog(LogVo logVo) {
        logDao.insert(logVo);
    }

    @Override
    public void insertLog(String action, String data, String ip, Integer authorId) {
        LogVo logs = new LogVo();
        logs.setAction(action);
        logs.setData(data);
        logs.setIp(ip);
        logs.setAuthorId(authorId);
        logs.setCreated(DateKit.getCurrentUnixTime());
        logDao.insert(logs);
    }

    @Override
    public List<LogVo> getLogs(int page, int limit) {
        LOGGER.debug("Enter getLogs method:page={},linit={}");
        if (page <= 0) {
            page = 1;
        }
        if (limit < 1 || limit > WebConst.MAX_POSTS) {
            limit = 10;
        }
        LogVoExample logVoExample = new LogVoExample();
        logVoExample.setOrderByClause("id desc");
        PageHelper.startPage((page - 1) * limit, limit);
        List<LogVo> logVos = logDao.selectByExample(logVoExample);
        LOGGER.debug("Exit getLogs method");
        return logVos;
    }
}
