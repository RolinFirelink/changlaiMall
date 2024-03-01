package com.aciu.service.impl;

import com.aciu.base.BaseDao;
import com.aciu.base.BaseServiceImpl;
import com.aciu.mapper.ItemMapper;
import com.aciu.po.Item;
import com.aciu.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends BaseServiceImpl<Item> implements ItemService {

    @Autowired
    private ItemMapper itemMapper;
    @Override
    public BaseDao<Item> getBaseDao() {
        return itemMapper;
    }
}
