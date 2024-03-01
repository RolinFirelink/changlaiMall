package com.aciu.service.impl;

import com.aciu.base.BaseDao;
import com.aciu.base.BaseServiceImpl;
import com.aciu.mapper.NewsMapper;
import com.aciu.po.News;
import com.aciu.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl extends BaseServiceImpl<News> implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public BaseDao<News> getBaseDao() {
        return newsMapper;
    }
}
