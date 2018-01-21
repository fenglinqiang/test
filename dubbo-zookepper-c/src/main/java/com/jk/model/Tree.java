/** 
 * <pre>项目名称:dome-tree 
 * 文件名称:Tree.java 
 * 包名:com.jk.vo.tree 
 * 创建日期:2017年12月21日上午11:38:36 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model;

import java.io.Serializable;
import java.util.List;

/** 
 * <pre>项目名称：dome-tree    
 * 类名称：Tree    
 * 类描述：    
 * 创建人：冯林强_java@126.com    
 * 创建时间：2017年12月21日 上午11:38:36    
 * 修改人：冯林强_java@126.com  
 * 修改时间：2017年12月21日 上午11:38:36    
 * 修改备注：       
 * @version </pre>    
 */
public class Tree implements Serializable{

	private static final long serialVersionUID = 1745183569533161116L;

	private  Integer  id;

	private   String  text;

	private   String  url;

	private   Integer  pid;

	private List<Tree> nodes;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public List<Tree> getNodes() {
		return nodes;
	}

	public void setNodes(List<Tree> nodes) {
		this.nodes = nodes;
	}


}
