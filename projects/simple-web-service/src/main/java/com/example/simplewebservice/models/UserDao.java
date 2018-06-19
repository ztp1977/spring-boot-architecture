package com.example.simplewebservice.models;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

// Transaction可以回滚呦！！
@Transactional
public interface UserDao extends CrudRepository<User, Long> {
    // TODO 为啥没有被实现也可以用
    User findByEmail(String email);
}
