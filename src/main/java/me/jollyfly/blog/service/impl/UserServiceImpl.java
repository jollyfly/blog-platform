package me.jollyfly.blog.service.impl;

import me.jollyfly.blog.repo.UserRepository;
import me.jollyfly.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 登陆逻辑
     */
    @Override
    public Boolean login(String nic, String password) {
        return this.userRepository.findByNicAndPassword(nic,password).isPresent();
    }
}
