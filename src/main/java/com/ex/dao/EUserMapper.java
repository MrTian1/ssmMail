package com.ex.dao;

import com.ex.entity.EUser;
import org.apache.ibatis.annotations.Param;


public interface EUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EUser user);

    int insertSelective(EUser user);

    EUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EUser user);

    int updateByPrimaryKey(EUser user);

    EUser login(@Param("username") String username, @Param( "password") String password);

    int register(EUser user);

    EUser getpass(String username);

    EUser selectUserById(Integer id);

    int update(EUser user);
}