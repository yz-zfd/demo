package com.example.demo.dao;

import com.example.demo.domain.DriverInformation;
import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Created by Song on 2019/6/26
 * driver_information表操作接口
 */
@Repository
public interface UserRepository extends JpaRepository <User,Integer>{
    /**
     * 查询所有用户
     */
    @Query("select d from User d")
    List<User> find();
    /**
     * 查询一个用户
     */
    @Query("select d from User d where username=:username")
    User findByUsername(String username);
}
