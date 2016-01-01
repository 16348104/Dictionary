package com.dict.service;

import com.dict.model.User;

/**
 * Created by xdx on 2015/12/27.
 */
public interface UserService extends GenericService{
    void signup(User user);
    User login(User user);
}
