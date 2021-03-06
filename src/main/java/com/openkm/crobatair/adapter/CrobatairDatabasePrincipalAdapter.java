/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openkm.crobatair.adapter;

import com.openkm.bean.Mail;
import com.openkm.core.AccessDeniedException;
import com.openkm.core.DatabaseException;
import com.openkm.core.PathNotFoundException;
import com.openkm.core.RepositoryException;
import com.openkm.crobatair.module.CrobatairAuthModule;
import com.openkm.dao.AuthDAO;
import com.openkm.dao.bean.Role;
import com.openkm.dao.bean.User;
import com.openkm.principal.DatabasePrincipalAdapter;
import com.openkm.principal.PrincipalAdapterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ale
 */
public class CrobatairDatabasePrincipalAdapter implements CrobatairAuthModule{
    private static Logger log = LoggerFactory.getLogger(DatabasePrincipalAdapter.class);

    @Override
    public List<User> getUsers(String token) throws PrincipalAdapterException {
        List<User> resultado = new ArrayList<>();
        try {
            resultado = AuthDAO.findAllUsers(Boolean.FALSE);
        } catch (DatabaseException ex) {
            java.util.logging.Logger.getLogger(CrobatairDatabasePrincipalAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    
    @Override
    public Map<String, Integer> getGrantedUsers(String token, String nodeId) throws PathNotFoundException, AccessDeniedException, RepositoryException, DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void grantRole(String token, String nodeId, String role, int permissions, boolean recursive) throws PathNotFoundException, AccessDeniedException, RepositoryException, DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void revokeRole(String token, String nodeId, String role, int permissions, boolean recursive) throws PathNotFoundException, AccessDeniedException, RepositoryException, DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, Integer> getGrantedRoles(String token, String nodeId) throws PathNotFoundException, AccessDeniedException, RepositoryException, DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public List<Role> getRoles(String token) throws PrincipalAdapterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getUsersByRole(String token, String role) throws PrincipalAdapterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Role> getRolesByUser(String token, String user) throws PrincipalAdapterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mail getMail(String token, User user) throws PrincipalAdapterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createUser(String token, User user) throws PrincipalAdapterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(String token, User user) throws PrincipalAdapterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUser(String token, User user) throws PrincipalAdapterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createRole(String token, Role rol) throws PrincipalAdapterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteRole(String token, Role rol) throws PrincipalAdapterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateRole(String token, Role rol) throws PrincipalAdapterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void assignRole(String token, User user, Role rol) throws PrincipalAdapterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeRole(String token, User user, Role rol) throws PrincipalAdapterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}
