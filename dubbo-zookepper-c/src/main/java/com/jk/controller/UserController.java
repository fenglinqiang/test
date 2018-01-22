/** 
 * <pre>项目名称:Spring-consumer 
 * 文件名称:UserController.java 
 * 包名:com.jk.controller 
 * 创建日期:2018年1月17日下午9:11:18 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.controller;

import com.jk.model.Tree;
import com.jk.model.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * <pre>项目名称：Spring-consumer    
 * 类名称：UserController    
 * 类描述：    
 * 创建人：冯林强_java@126.com    
 * 创建时间：2018年1月17日 下午9:11:18    
 * 修改人：冯林强_java@126.com  
 * 修改时间：2018年1月17日 下午9:11:18    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("findTree")
	@ResponseBody
	public List<Tree> findTree(HttpServletResponse resp, Tree tree){
		List<Tree> List = userService.findTree(0);
		List<Tree> parentList = parentList(List);
		return parentList;
	}


	public List<Tree> parentList(List<Tree> list){
		List<Tree> childList = new ArrayList<Tree>();
		for(int i = 0; i < list.size(); i++){
			Tree tree = list.get(i);
			List<Tree> findTree =userService.findTree(tree.getId());
			if(findTree.size()>0){
				// 当前 子节点的集合
				List<Tree> getchirdTree = getchirdTree(findTree);
				// 将子节点装进集合中
				tree.setNodes(getchirdTree);
				childList.add(tree);
			}else{
				childList.add(tree);
			}
		}
		return childList;
	}


	public List<Tree> getchirdTree(List<Tree> list){
		List<Tree> childList = new ArrayList<Tree>();
		for(int i = 0; i < list.size(); i++){
			Tree tree = list.get(i);
			List<Tree> findTree =userService.findTree(tree.getId());
			//判断他有没有子节点
			if(findTree.size()>0){
				// 当前 子节点的集合
				List<Tree> getchirdTree = getchirdTree(findTree);
				// 将子节点装进集合中
				tree.setNodes(getchirdTree);
				childList.add(tree);
			}else{
				childList.add(tree);
			}
		}
		return childList;
	}
	@RequestMapping("querylist")
	public String querylist(){
		return "view/list";
	}
	//查询
	@RequestMapping("queryUser")
	@ResponseBody
	public String queryUser(Integer pageSize,Integer start,User user){
		
		return userService.userService(pageSize,start,user);
		
	}
	//修改页面
	@RequestMapping("queryUpdate")
	public ModelAndView queryUpdate(User user){
		HashMap<String, Object> model=new HashMap<>(); 
		
		user=userService.queryUpdate(user.getTaid());
			model.put("user", user);
        System.out.println(user.getShowDate());
		return  new ModelAndView("view/saveorupdate", model);
		
	}
	//修改
	@RequestMapping("updateUser")
	@ResponseBody
	public void updateUser(User user){

		userService.updateUser(user);
	}

}
