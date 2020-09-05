package com.venus.tspro.config;

import com.venus.tspro.shiro.ShiroRealm;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
//    @Resource
//    ShiroRealm shiroRealm;
//
//    private static String ANON = "anon";
//
//    @Bean
//    public SecurityManager securityManager(){
//        DefaultSecurityManager defaultSecurityManager = new DefaultWebSecurityManager(shiroRealm);
//        return defaultSecurityManager;
//    }
////
//    @Bean
//    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        //设置身份认证失败时访问此URL
//        shiroFilterFactoryBean.setLoginUrl("/index");
//        //设置认证成功访问的URL
//        shiroFilterFactoryBean.setSuccessUrl("/successLogin");
//        //设置授权失败访问的URL
//        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
//        //有序链表，用于顺序拦截
//        Map<String,String> filterChainMap = new LinkedHashMap<>();
//        filterChainMap.put("/static/**",ANON);
//        filterChainMap.put("/index",ANON);
//        filterChainMap.put("/login",ANON);
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
//        return shiroFilterFactoryBean;
//    }
}
