package com.jk.service;

import com.jk.model.Tree;
import com.jk.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

	/** <pre>userService(这里用一句话描述这个方法的作用)   
	 * 创建人：冯林强_java@126.com     
	 * 创建时间：2018年1月18日 上午10:50:23    
	 * 修改人：冯林强_java@126.com      
	 * 修改时间：2018年1月18日 上午10:50:23    
	 * 修改备注： 
	 * @param pageSize
	 * @param start
	 * @param user
	 * @return</pre>    
	 */
	String userService(Integer pageSize, Integer start, User user);

	/** <pre>queryUpdate(这里用一句话描述这个方法的作用)   
	 * 创建人：冯林强_java@126.com     
	 * 创建时间：2018年1月18日 下午5:58:18    
	 * 修改人：冯林强_java@126.com      
	 * 修改时间：2018年1月18日 下午5:58:18    
	 * 修改备注： 
	 * @param taid
	 * @return</pre>    
	 */
	User queryUpdate(Integer taid);

	/** <pre>updateUser(这里用一句话描述这个方法的作用)   
	 * 创建人：冯林强_java@126.com     
	 * 创建时间：2018年1月18日 下午6:47:46    
	 * 修改人：冯林强_java@126.com      
	 * 修改时间：2018年1月18日 下午6:47:46    
	 * 修改备注： 
	 * @param user</pre>    
	 */
	void updateUser(User user);

	List<Tree> findTree(int i);
}
