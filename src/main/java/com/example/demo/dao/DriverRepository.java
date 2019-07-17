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
    @Query("select d from DriverInformation d")
     List<DriverInformation> find();

    /**
     * 保存或更新某个驾驶员信息
     * @param s
     * @param <S>
     * @return
     */
    @Override
    @CachePut(key="'Driver'+#s.id")
    <S extends DriverInformation> S save(S s);

    /**
     * 查询id值为某个值的驾驶员
     * @param id id值
     * @return
     */
    @Override
    @Cacheable(key="'Driver'+#id")
    Optional<DriverInformation> findById(Integer id);

    /**
     * 查询身份证号为某个值的驾驶员
     * @param personId 身份证号
     * @return
     */
    @Query("select d from DriverInformation d where person_id=:personId")
     DriverInformation findByPersonId(String personId);
    /**
     * 查询身份证号为某个值的驾驶员
     * @param phoneNumber 身份证号
     * @return 返回某个符合身份证号的驾驶员信息
     */
    @Query("select d from DriverInformation d where phone_number=:phoneNumber")
    DriverInformation findByPhoneNumber(String phoneNumber);

    /**
     * 针对photo为空的记录使用特殊更新sql。
     */
    /*@Query("update DriverInformation d set d.name=driverInformation.name,d.nationality=driverInformation.nationality," +
            "d.phone_number=driverInformation.phone_number,d.marital_status=driverInformation.marital_status," +
            "d.person_id=driverInformation.person_id,d.company=driverInformation.company,d.sex=driverInformation.sex," +
            "d.foreign_language_ability=driverInformation.foreign_language_ability," +
            "d.birthday=driverInformation.birthday,d.education=driverInformation.education,d.name=driverInformation.name")
    int update(DriverInformation driverInformation);*/
}
