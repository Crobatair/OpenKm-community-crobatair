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
    
    
    public List<User> getAllUsuarios();
    public List<User> getAllUsersByRole (String rol);
    
    
    public List<Role> getAllRoles();
    public List<Role> getAllRolesByUser(String userId);
    
    public List<Role> getAllGrantRoleList(String nodeId);
    public List<User> getAllGrandedUserList(String nodeId);
    
    public User getUserById(String userId);
    
    
    
}
