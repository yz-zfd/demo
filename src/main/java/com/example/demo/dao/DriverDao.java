package com.example.demo.dao;

import com.example.demo.domain.DriverInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Song on 2019/6/26
 * driver_information表操作接口
 */
@Repository
public interface DriverDao extends JpaRepository <DriverInformation,Integer>{
    /**
     * 查询所有用户
     */
    @Query("select d from DriverInformation d")
    List<DriverInformation> find();
    /**
     * 查询一个用户
     */
    public DriverInformation findByName(String name);
}
