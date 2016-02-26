	package com.test.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.app.entities.Memo;
import com.test.app.repo.impl.MemoRepo;

@Controller 
public class Main {
	@Autowired  MemoRepo e;

	@RequestMapping(value = "/")
	public String homePahe(ModelMap model) {
		System.out.println("home");
		/////////////////////////////////////////get
		//System.out.println(e.get(3233));
		/////////////////////////////////////////insert
		Memo m = new Memo();
		m.setContent("sdf");
		m.setDate(new Date());
		m.setDomain("sdf");
		m.setIsenable(true);
		m.setIspublic(true);
		m.setTitle("sdf");
		m.setUrl("sdf");
		m.setUserid(1);
		System.out.println(e.insert(m));
		////////////////////////////////////////update
/*		Memo m1 = new Memo();
		m1.setId(1);
		m1.setContent("ff");
		m1.setDate(new Date());
		m1.setDomain("ff");
		m1.setIsenable(false);
		m1.setIspublic(false);
		m1.setTitle("ff");
		m1.setUrl("ff");
		m1.setUserid(2);
		System.out.println(e.update(m1));*/
		
		return "home";
	}
}