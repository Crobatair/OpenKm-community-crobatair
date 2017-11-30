/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openkm.crobatair.adapter;

import com.openkm.dao.bean.Role;
import com.openkm.dao.bean.User;
import java.util.List;

/**
 *
 * @author Ale
 */
public interface CrobatairAdapter {
    
    /**
     * 
     * @param token
     * @return 
     */
    public List<User> getUsers(String token);
    
    /**
     * 
     * @param rol
     * @return 
     */
    public List<User> getUsersByRole (String token, String rol);
    
    /**
     * 
     * @return 
     */
    public List<Role> getRoles(String token);
    
    /**
     * 
     * @param userId
     * @return 
     */
    public List<Role> getRolesByUser(String token, String userId);
    
    
    /**
     * 
     * @param nodeId
     * @return 
     */
    public List<Role> getGrantRoleList(String token, String nodeId);
    
    
    /**
     * 
     * @param nodeId
     * @return 
     */
    public List<User> getGrandedUserList(String token, String nodeId);  
    
    
    /**
     * 
     * @param userId
     * @return 
     */
    public User getUserById(String token, String userId);
    
    
    
}
