/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openkm.crobatair.db;

import com.openkm.bean.Mail;
import com.openkm.core.AccessDeniedException;
import com.openkm.core.Config;
import com.openkm.core.DatabaseException;
import com.openkm.core.PathNotFoundException;
import com.openkm.core.RepositoryException;
import com.openkm.crobatair.adapter.CrobatairAdapter;
import com.openkm.crobatair.adapter.CrobatairAdapterException;
import com.openkm.crobatair.module.CrobatairAuthModule;
import com.openkm.dao.AuthDAO;
import com.openkm.dao.bean.Role;
import com.openkm.dao.bean.User;
import com.openkm.principal.PrincipalAdapterException;
import com.openkm.spring.PrincipalUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;

/**
 *
 * @author Ale
 */
public class CrobatairDbAuthModule implements CrobatairAuthModule{
    private static Logger log = LoggerFactory.getLogger(CrobatairDbAuthModule.class);
    private static CrobatairAdapter crobatairAdapter = null;
    
    //Add all method to implement here :´v 
    @Override
    /**
     * 
     */
    public List<User> getUsers(String token) {
        List<User> users = new ArrayList<>();
        Authentication oldAuth = null;

        try {
            if (token == null) {
                    PrincipalUtils.getAuthentication();
            } else {
                    oldAuth = PrincipalUtils.getAuthentication();
                    PrincipalUtils.getAuthenticationByToken(token);
            }
            ///// Aqui que saltare llamar a common :v ... y llamare directamente al DatabasePrincipalAdapter
            users = AuthDAO.findAllUsers(Boolean.FALSE);
        } catch (AccessDeniedException e) {
            log.info(e.getMessage());System.out.println(e.getMessage());
        } catch (DatabaseException ex) {
            java.util.logging.Logger.getLogger(CrobatairDbAuthModule.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (token != null) {
                    PrincipalUtils.setAuthentication(oldAuth);
            }
        }

        return users;
    }
    
    @Override
    public List<User> getUsersByRole(String token, String role) throws PrincipalAdapterException {
        List<User> users = new ArrayList<>();
        Authentication oldAuth = null;
        try {
            if (token == null) {
                    PrincipalUtils.getAuthentication();
            } else {
                    oldAuth = PrincipalUtils.getAuthentication();
                    PrincipalUtils.getAuthenticationByToken(token);
            }
            ///// Aqui que saltare llamar a common :v ... y llamare directamente al DatabasePrincipalAdapter
            users = AuthDAO.findUsersByRole(role, Boolean.FALSE);
        } catch (AccessDeniedException e) {
            log.info(e.getMessage());System.out.println(e.getMessage());
        } catch (DatabaseException ex) {
            java.util.logging.Logger.getLogger(CrobatairDbAuthModule.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (token != null) {
                    PrincipalUtils.setAuthentication(oldAuth);
            }
        }

        return users;
    }

    @Override
    public List<Role> getRoles(String token) throws PrincipalAdapterException {
        List<Role> respuesta = new ArrayList<>();
        Authentication oldAuth = null;
        try {
            if (token == null) {
                    PrincipalUtils.getAuthentication();
            } else {
                    oldAuth = PrincipalUtils.getAuthentication();
                    PrincipalUtils.getAuthenticationByToken(token);
            }
            ///// Aqui que saltare llamar a common :v ... y llamare directamente al DatabasePrincipalAdapter
            respuesta = AuthDAO.findAllRoles();
        } catch (AccessDeniedException e) {
            log.info(e.getMessage());System.out.println(e.getMessage());
        } catch (DatabaseException ex) {
            java.util.logging.Logger.getLogger(CrobatairDbAuthModule.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (token != null) {
                    PrincipalUtils.setAuthentication(oldAuth);
            }
        }
        return respuesta;
    }

    @Override
    public List<Role> getRolesByUser(String token, String user) throws PrincipalAdapterException {
        List<Role> respuesta = new ArrayList<>();
        Authentication oldAuth = null;
        try {
            if (token == null) {
                    PrincipalUtils.getAuthentication();
            } else {
                    oldAuth = PrincipalUtils.getAuthentication();
                    PrincipalUtils.getAuthenticationByToken(token);
            }
            ///// Aqui que saltare llamar a common :v ... y llamare directamente al DatabasePrincipalAdapter
            respuesta = AuthDAO.findRolesByUser(user, Boolean.FALSE);
        } catch (AccessDeniedException e) {
            log.info(e.getMessage());System.out.println(e.getMessage());
        } catch (DatabaseException ex) {
            java.util.logging.Logger.getLogger(CrobatairDbAuthModule.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (token != null) {
                    PrincipalUtils.setAuthentication(oldAuth);
            }
        }
        return respuesta;
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
