package com.example.ShiroTestDemo;

import java.util.Arrays;

import org.apache.shiro.subject.Subject;
import org.junit.Test;

import com.shiro.common.ShiroUtils;

public class TestRole {

	@Test
	public void testRole() {
	Subject currentUser=	ShiroUtils.login("classpath:shiro-roles.ini","zhang", "123");
	System.out.println(currentUser.hasRole("role1")?"有role1这个角色":"没有role1这个角色"); ;
	boolean[] results=  currentUser.hasRoles(Arrays.asList("role1","role2","role3"));
	System.out.println(results[0]?"有role1这个角色":"没有role1这个角色");
	System.out.println(results[1]?"有role2这个角色":"没有role2这个角色");
	System.out.println(results[2]?"有role3这个角色":"没有role3这个角色");
	
	System.out.println(currentUser.hasAllRoles(Arrays.asList("role1","role2"))?"有role1,role2这个角色":"role1,role2不全有");
	
	currentUser.logout();
	}
	
	@Test
	public void checkRole() {
		Subject currentUser=	ShiroUtils.login("classpath:shiro-roles.ini","zhang", "123");
		currentUser.checkRole("role1");
		boolean[] results=  currentUser.hasRoles(Arrays.asList("role1","role2","role3"));
		System.out.println(results[0]?"有role1这个角色":"没有role1这个角色");
		System.out.println(results[1]?"有role2这个角色":"没有role2这个角色");
		System.out.println(results[2]?"有role3这个角色":"没有role3这个角色");
		
		System.out.println(currentUser.hasAllRoles(Arrays.asList("role1","role2"))?"有role1,role2这个角色":"role1,role2不全有");
		currentUser.logout();
	}
	

    
    
  
    
}
