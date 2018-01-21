package com.jk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jk.model.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

	/** <pre>userDaocount(这里用一句话描述这个方法的作用)   
	 * 创建人：冯林强_java@126.com     
	 * 创建时间：2018年1月18日 上午10:52:51    
	 * 修改人：冯林强_java@126.com      
	 * 修改时间：2018年1月18日 上午10:52:51    
	 * 修改备注： 
	 * @param user
	 * @return</pre>    
	 */
	long userDaocount(@Param("user") User user);

	/** <pre>userDaofind(这里用一句话描述这个方法的作用)   
	 * 创建人：冯林强_java@126.com     
	 * 创建时间：2018年1月18日 上午10:52:55    
	 * 修改人：冯林强_java@126.com      
	 * 修改时间：2018年1月18日 上午10:52:55    
	 * 修改备注： 
	 * @param pageSize
	 * @param start
	 * @param user
	 * @return</pre>    
	 */
	List<User> userDaofind(@Param("pageSize") Integer pageSize, @Param("start") Integer start, @Param("user") User user);

	/** <pre>queryUpdate(这里用一句话描述这个方法的作用)   
	 * 创建人：冯林强_java@126.com     
	 * 创建时间：2018年1月18日 下午5:59:04    
	 * 修改人：冯林强_java@126.com      
	 * 修改时间：2018年1月18日 下午5:59:04    
	 * 修改备注： 
	 * @param taid
	 * @return</pre>    
	 */
	User queryUpdate(@Param("taid") Integer taid);

	/** <pre>updateUser(这里用一句话描述这个方法的作用)   
	 * 创建人：冯林强_java@126.com     
	 * 创建时间：2018年1月18日 下午6:48:47    
	 * 修改人：冯林强_java@126.com      
	 * 修改时间：2018年1月18日 下午6:48:47    
	 * 修改备注： 
	 * @param user</pre>    
	 */
	void updateUser(User user);

//	@Select("select tree_id as id,"
//			+ "tree_text as text,"
//			+ "tree_href as url,"
//			+ "tree_pid as pid"
//			+ " from a_tree"
//			+ " where tree_pid = #{i}")
	@Select("select * from a_tree where tree_pid = #{i}")
	@Results({
			@Result(property = "id",column = "tree_id"),
			@Result(property = "text",column = "tree_text"),
			@Result(property = "url",column = "tree_href"),
			@Result(property = "pid",column = "tree_pid")
	})
	List<com.jk.model.Tree> findTree(int i);
}
