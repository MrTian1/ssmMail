package com.ex.service.impl;

import com.ex.dao.EUserMapper;

import com.ex.entity.EUser;
import com.ex.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private EUserMapper userMapper;

    @Override
    public int insert(EUser user) {
        return userMapper.insert(user);
    }


    @Override
    public EUser login(String username, String password) {
        return userMapper.login(username,password);
    }

    @Override
    public int register(EUser user) {
        return userMapper.register(user);
    }

    @Override
    public EUser getpass(String username) {
        return userMapper.getpass(username);
    }

    @Override
    public EUser selectUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public int update(EUser user) {
        return userMapper.update(user);
    }


}
