package com.venus.tspro.shiro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class ShiroRealm {
//public class ShiroRealm extends AuthorizingRealm {

//    @Resource
//    SysUserService sysUserService;
//    SysUser sysUser = new SysUser();
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        sysUser.setUserName((String) principalCollection.getPrimaryPrincipal());
//        sysUser = sysUserService.querySysUser(sysUser);
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        for(SysPermission sysPermission : sysUser.getPermissions())
//            simpleAuthorizationInfo.addStringPermission(sysPermission.getPermissionId());
//        return simpleAuthorizationInfo;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        sysUser.setUserName(token.getUsername());
//        sysUser = sysUserService.querySysUser(sysUser);
//        if(sysUser!=null)
//            return new SimpleAuthenticationInfo(token.getUsername(),sysUser.getPassword(),getName());
//        throw new UnknownAccountException();
//    }
}
