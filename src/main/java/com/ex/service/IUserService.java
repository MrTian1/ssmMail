package com.ex.service;


import com.ex.entity.EUser;

import javax.xml.registry.infomodel.User;

public interface IUserService {

    int insert(EUser user);

    EUser login(String username, String password);

    int register(EUser user);

    EUser getpass(String username);

    EUser selectUserById(Integer id);

    int update(EUser user);
}
