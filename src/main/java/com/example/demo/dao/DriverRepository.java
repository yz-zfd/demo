package com.example.demo.dao;

import com.example.demo.domain.DriverInformation;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author zfd on 2019/6/26
 * driver_information表操作接口
 */
@Repository
@CacheConfig(cacheNames = "driverInformation")
public interface DriverRepository extends JpaRepository <DriverInformation,Integer>{
    /**
     *
     * @return 返回所有驾驶员信息集合
     */
    /*@Cacheable(key="'drivers'")*/
    @Query("select d from DriverInformation d")
    public List<DriverInformation> find();

    @Override
    @CachePut(key="'Driver'+#s.id")
    <S extends DriverInformation> S save(S s);

    @Override
    @Cacheable(key="'Driver'+#id")
    Optional<DriverInformation> findById(Integer id);
    @Query("select d from DriverInformation d where person_id=:person_id")
    public DriverInformation findByPerson_id(Integer person_id);
}
