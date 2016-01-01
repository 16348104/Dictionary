package com.dict.service.impl;

import com.dict.dao.GenericDao;
import com.dict.model.User;
import com.dict.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



/**
 * Created by xdx on 2015/12/27.
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements UserService {
    @Override
    @Autowired
    @Qualifier("userDaoImpl")
    public void setGenericDao(GenericDao<User, Integer> genericDao) {
        super.genericDao = genericDao;
    }

    @Override
    public void signup(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        super.genericDao.add(user);
    }

    @Override
    public User login(User user) {
        String password=user.getPassword();
        user.setPassword(null);
        user = genericDao.query(user);
        if (user!=null && BCrypt.checkpw(password,user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }
}


