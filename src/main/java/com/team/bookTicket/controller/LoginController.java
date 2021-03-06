package com.team.bookTicket.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.cj.Session;
import com.team.bookTicket.pojo.Customer;
import com.team.bookTicket.service.CustomerService;

@Controller
@ResponseBody
public class LoginController {
	@Autowired
	CustomerService customerService;
	
	/**
	 * 登录。返回json各字段如：<br>
	 * <li>code：状态码，200登录成功</li>
	 * <li>msg：错误信息</li>
	 * <li>isAdmin：是否为管理员</li>
	 * @param name
	 * @param cardId
	 * @return
	 */
	@PostMapping("/login")
	public Map<String, Object> login(@RequestParam String name,@RequestParam String cardId,HttpSession session){
		Map<String, Object> map=new HashMap<>();
		map.put("isAdmin", "false");
		
		if(name==null || cardId==null ||                     cardId.isEmpty()) {
			map.put("code", "400");
			map.put("msg", "账号或密码必须存在");
			return map;
		}
		
		Customer customer=customerService.getCustomer(1);
		if(customer!=null && customer.getName().equals(name)) {//身份核实
			map.put("code", "200");
			map.put("msg", "ok");
			
			if(customer.getIsAdmin()!=null && customer.getIsAdmin()!=0) {//管理员登录
				map.put("isAdmin", "true");
			}
			session.setAttribute("user", customer);
			
		}else {//无该用户
			map.put("code", "402");
			map.put("msg", "无该用户");
		}
		return map;
	}
	@GetMapping("/loginout")
	public void loginout(HttpSession session) {
		session.removeAttribute("user");
	}
	@GetMapping("/get/user")
	public Customer getUser(HttpSession session) {
		return (Customer) session.getAttribute("user");
	}
}



























