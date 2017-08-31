package com.demo.ztree.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.demo.ztree.entity.Menu;

public class ZtreeServlet extends HttpServlet {

	public void destroy() {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");      
		response.setContentType("UTF-8");       		 
	    response.setContentType("text/html;charset=UTF-8");	
		PrintWriter out = response.getWriter();
		
		List<Menu> list = new ArrayList<Menu>();
		Menu menu1 = new Menu();
		menu1.setId("1");
		menu1.setName("权限管理");
		menu1.setPid("1");
		menu1.setChecked(true);
		
		Menu menu2_1 = new Menu();
		menu2_1.setId("2");
		menu2_1.setName("人员权限");
		menu2_1.setPid("1");
		menu2_1.setChecked(true);
		
		Menu menu2_2 = new Menu();
		menu2_2.setId("5");
		menu2_2.setName("用户权限");
		menu2_2.setPid("1");
		menu2_2.setChecked(true);
		
		Menu menu3_1 = new Menu();
		menu3_1.setId("3");
		menu3_1.setName("地区权限");
		menu3_1.setPid("2");
		menu3_1.setChecked(true);
		Menu menu3_2 = new Menu();
		menu3_2.setId("4");
		menu3_2.setName("国家权限");
		menu3_2.setPid("2");
		Menu menu3_3 = new Menu();
		menu3_3.setId("6");
		menu3_3.setName("国家权限");
		menu3_3.setPid("5");
		menu3_3.setChecked(true);
		list.add(menu1);
		list.add(menu2_1);
		list.add(menu2_2);
		list.add(menu3_1);
		list.add(menu3_2);
		list.add(menu3_3);
		/**
		 * 封装到json数组中
		 */
		JSONArray json = JSONArray.fromObject(list);
		out.write(json.toString());  //输出到前台
		
	}

	public void init() throws ServletException {
	}

}
