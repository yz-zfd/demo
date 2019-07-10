package com.example.demo.service;

import com.example.demo.dao.AuthorityRepository;
import com.example.demo.domain.UrlRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author zfd
 */
@Service
public class MyAuthorityService {
    @Autowired
    AuthorityRepository authorityRepository;
    //获取某个用户的角色集合
    public List<String> findRolesOfUserByUsername(String username){
        return authorityRepository.findRolesOfUserByUsername(username);
    }
    //获取某个url的角色集合
    public List<String> findRolesOfUrlByUrlname(String url){
        return authorityRepository.findRolesOfUrlByUrlname(url);
    }
    //获取所有url与role的对应关系
    public LinkedHashMap<String, List<String>> getAllUrlRoleMapper(){
        LinkedHashMap<String, List<String>> linkedHashMap=new LinkedHashMap<>();
        List<UrlRole> list = authorityRepository.findAllUrlRoleMapper();
        for (UrlRole u:list) {
            if(linkedHashMap.containsKey(u.getUrl_id())){

            }
        }
        return null;
    }
}
