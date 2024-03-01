package com.aciu.service.impl;

import com.aciu.base.BaseDao;
import com.aciu.base.BaseServiceImpl;
import com.aciu.mapper.UserMapper;
import com.aciu.po.User;
import com.aciu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseDao<User> getBaseDao() {
        return userMapper;
    }
}
