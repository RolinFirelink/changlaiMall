package com.aciu.service.impl;

import com.aciu.base.BaseDao;
import com.aciu.base.BaseServiceImpl;
import com.aciu.mapper.OrderDetailMapper;
import com.aciu.po.OrderDetail;
import com.aciu.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail> implements OrderDetailService {
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public BaseDao<OrderDetail> getBaseDao() {
        return orderDetailMapper;
    }
}
