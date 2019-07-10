package com.example.demo.dao;

import com.example.demo.domain.RoleInfo;
import com.example.demo.domain.UrlRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityRepository extends JpaRepository<RoleInfo,Integer> {
    /**
     * 三表连接查询某个用户对应得权限
     * @param username
     * @return
     */
    @Query("select r.role from UserRole ur join User u on ur.user_id=u.id join RoleInfo r on ur.role_id=r.id where u.username=:username")
    List<String> findRolesOfUserByUsername(String username);
    /**
     * 三表连接查询某个url需要的权限
     * @param username
     * @return
     */
    @Query("select r.role from UrlRole ur join UrlInfo ui on ur.url_id=ui.id join RoleInfo r on ur.role_id=r.id where ui.url=:url")
    List<String> findRolesOfUrlByUrlname(String url);

    @Query("select u from UrlRole u")
    List<UrlRole> findAllUrlRoleMapper();
}
