package com.example.demo.dao;

import com.example.demo.domain.RoleInfo;
import com.example.demo.domain.UrlRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityRepository extends JpaRepository<UrlRole,Integer> {
    /**
     * 查询某个用户对应的角色
     * @param username
     * @return
     */
    @Query("select UserRole.role from UserRole where UserRole.username=:username")
    List<String> findRolesOfUserByUsername(String username);
    /**
     * 查询某个url需要的权限
     * @param url
     * @return
     */
    @Query("select UrlRole.role from UrlRole where UrlRole.url=:url")
    List<String> findRolesOfUrlByUrl(String url);

    /**
     * 获取所有的URL与权限的对应关系
     * @return
     */
    @Query("select u from UrlRole u")
    List<UrlRole> findAllUrlRoleMapper();
}
