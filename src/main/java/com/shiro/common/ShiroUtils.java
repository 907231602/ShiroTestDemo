package com.shiro.common;

import javax.security.sasl.AuthenticationException;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class ShiroUtils {
	public static Subject login(String configFile,String userName,String password) {
		//1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager  
        Factory<org.apache.shiro.mgt.SecurityManager> factory =  
                new IniSecurityManagerFactory(configFile);  
      
        //2、得到SecurityManager实例 并绑定给SecurityUtils  
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();  
        SecurityUtils.setSecurityManager(securityManager);  
      
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）  
        Subject subject = SecurityUtils.getSubject(); 
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);  
       //身份验证
        subject.login(token);
        System.out.println("身份验证成功");
        return subject;
	}
}
