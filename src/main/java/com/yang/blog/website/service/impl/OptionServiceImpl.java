package com.yang.blog.website.service.impl;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yang.blog.website.dao.OptionVoMapper;
import com.yang.blog.website.model.Vo.OptionVo;
import com.yang.blog.website.model.Vo.OptionVoExample;
import com.yang.blog.website.service.IOptionService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * options表的service
 * Created by BlueT on 2017/3/7.
 */
@Service
public class OptionServiceImpl implements IOptionService {

    private static final Logger LOGGER = Logger.getLogger(OptionServiceImpl.class);

    @Resource
    private OptionVoMapper optionDao;

    @Override
    public void insertOption(OptionVo optionVo) {
        LOGGER.debug("Enter insertOption method:optionVo={}");
        optionDao.insertSelective(optionVo);
        LOGGER.debug("Exit insertOption method.");
    }

    @Override
    @Transactional
    public void insertOption(String name, String value) {
        LOGGER.debug("Enter insertOption method:name={},value={}");
        OptionVo optionVo = new OptionVo();
        optionVo.setName(name);
        optionVo.setValue(value);
        if (optionDao.selectByPrimaryKey(name) == null) {
            optionDao.insertSelective(optionVo);
        } else {
            optionDao.updateByPrimaryKeySelective(optionVo);
        }
        LOGGER.debug("Exit insertOption method.");
    }

    @Override
    @Transactional
    public void saveOptions(Map<String, String> options) {
        if (null != options && !options.isEmpty()) {
            options.forEach(this::insertOption);
        }
    }

    @Override
    public OptionVo getOptionByName(String name) {
        return optionDao.selectByPrimaryKey(name);
    }

    @Override
    public List<OptionVo> getOptions() {
        return optionDao.selectByExample(new OptionVoExample());
    }
}
