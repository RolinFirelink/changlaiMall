package com.aciu.service.impl;

import com.aciu.base.BaseDao;
import com.aciu.base.BaseServiceImpl;
import com.aciu.mapper.ItemOrderMapper;
import com.aciu.po.ItemOrder;
import com.aciu.service.ItemOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemOrderServiceImpl extends BaseServiceImpl<ItemOrder> implements ItemOrderService {

    @Autowired
    private ItemOrderMapper itemOrderMapper;

    @Override
    public BaseDao<ItemOrder> getBaseDao() {
        return itemOrderMapper;
    }
}
