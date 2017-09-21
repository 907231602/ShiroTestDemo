package com.example.ShiroTestDemo;

import org.apache.shiro.subject.Subject;
import org.junit.Test;

import com.shiro.common.ShiroUtils;

public class TestPermission {
	
	@Test
	public void testIsPermitted() {
		Subject currentUser=	ShiroUtils.login("classpath:shiro-permission.ini","wang", "123");
		System.out.println(currentUser.isPermitted("user:select")?"yes":"no");
		System.out.println(currentUser.isPermitted("user:update")?"yes":"no");
		boolean[] result= currentUser.isPermitted("user:update","user:select");
		System.out.println(result[0]?"yes":"no");
		System.out.println(result[1]?"yes":"no");
		
		currentUser.logout();
	}
	
	@Test
	public void testCheckPermitted() {
		Subject currentUser=	ShiroUtils.login("classpath:shiro-permission.ini","wang", "123");
		currentUser.checkPermission("user:select");
		//currentUser.checkPermission("user:update");//没有update权限
		
		currentUser.logout();
	}

}
