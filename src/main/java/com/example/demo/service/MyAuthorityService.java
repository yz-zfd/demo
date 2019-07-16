package com.example.demo.service;

import com.example.demo.dao.AuthorityRepository;
import com.example.demo.domain.UrlRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author zfd
 */
@Service
public class MyAuthorityService {
    @Autowired
    AuthorityRepository authorityRepository;

    /**
     * 根据用户名获取用户角色
     * @param username
     * @return 某个用户的全部角色
     */
    public List<String> findRolesOfUserByUsername(String username){
        return authorityRepository.findRolesOfUserByUsername(username);
    }

    /**
     * 根据url，获取其需要的角色
     * @param url
     * @return 返回某个url的全部角色
     */
    public List<String> findRolesOfUrlByUrlname(String url){
        return authorityRepository.findRolesOfUrlByUrl(url);
    }

    /**
     * 获取所有的url与role的对应关系
     * @return url与role的对应关系
     */
    public LinkedHashMap<String, List<String>> getAllUrlRoleMapper(){
        LinkedHashMap<String, List<String>> linkedHashMap=new LinkedHashMap<>();
        List<UrlRole> list = authorityRepository.findAllUrlRoleMapper();
        for (UrlRole u:list) {
            String urlKey=u.getUrl();
            if(linkedHashMap.containsKey(urlKey)){
                linkedHashMap.get(urlKey).add(u.getRole());
            }else{
                List<String> listOfRole = new ArrayList<>();
                listOfRole.add(u.getRole());
                linkedHashMap.put(urlKey,listOfRole);
            }
        }
        return linkedHashMap;
    }
}
