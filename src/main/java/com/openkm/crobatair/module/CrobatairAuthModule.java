/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openkm.crobatair.module;

import com.openkm.bean.Mail;
import com.openkm.core.AccessDeniedException;
import com.openkm.core.DatabaseException;
import com.openkm.core.PathNotFoundException;
import com.openkm.core.RepositoryException;
import com.openkm.dao.bean.Role;
import com.openkm.dao.bean.User;
import com.openkm.principal.PrincipalAdapterException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ale
 */
public interface CrobatairAuthModule {

    /**
     * Get user permissions from am item (document or folder).
     *
     * @param token
     * @param nodeId The complete path to the node or its UUID.
     * @return A hashmap with pairs of user / permissions.
     * @throws PathNotFoundException If the node defined by nodePath do not exists.
     * @throws AccessDeniedException If the authorization information is not valid.
     * @throws RepositoryException If there is any error accessing to the repository.
     * @throws com.openkm.core.DatabaseException
     */
    public Map<String, Integer> getGrantedUsers(String token, String nodeId) throws PathNotFoundException, AccessDeniedException,
                    RepositoryException, DatabaseException;

    /**
     * Grant role permissions for a node.
     *
     * @param token
     * @param nodeId The complete path to the node or its UUID.
     * @param role Role name which permissions are changed.
     * @param permissions A mask with the permissions to be added.
     * @param recursive If the nodePath indicates a folder, the permissions can
     *        be applied recursively.
     * @throws PathNotFoundException If the node defined by nodePath do not exists.
     * @throws AccessDeniedException If the authorization information is not valid.
     * @throws RepositoryException If there is any error accessing to the repository.
     * @throws com.openkm.core.DatabaseException
     */
    public void grantRole(String token, String nodeId, String role, int permissions, boolean recursive) throws PathNotFoundException,
                    AccessDeniedException, RepositoryException, DatabaseException;

    /**
     * Revoke role permissions from a node.
     *
     * @param token
     * @param nodeId The complete path to the node or its UUID.
     * @param role Role name which permissions are changed.
     * @param permissions A mask with the permissions to be removed.
     * @param recursive If the nodePath indicates a folder, the
     *        permissions can be applied recursively.
     * @throws PathNotFoundException If the node defined by nodePath do not exists.
     * @throws AccessDeniedException If the authorization information is not valid.
     * @throws RepositoryException If there is any error accessing to the repository.
     * @throws com.openkm.core.DatabaseException
     */
    public void revokeRole(String token, String nodeId, String role, int permissions, boolean recursive) throws PathNotFoundException,
                    AccessDeniedException, RepositoryException, DatabaseException;

    /**
     * Get roles permissions from am item (document or folder).
     *
     * @param nodeId The complete path to the node or its UUID.
     * @return A hashmap with pairs of role / permissions.
     * @throws PathNotFoundException If the node defined by nodePath do not exists.
     * @throws AccessDeniedException If the authorization information is not valid.
     * @throws RepositoryException If there is any error accessing to the repository.
     */
    public Map<String, Integer> getGrantedRoles(String token, String nodeId) throws PathNotFoundException, AccessDeniedException,
                    RepositoryException, DatabaseException;

    /**
     * Retrieves a list of repository users
     * @param token
     * @return 
     * @throws com.openkm.principal.PrincipalAdapterException 
    */
    public List<User> getUsers(String token) throws PrincipalAdapterException;
    /**
     * Retrieves a list of repository roles.
     * @param token
     * @return 
     */
    public List<Role> getRoles(String token) throws PrincipalAdapterException;

    /**
     * Retrieves a list of users by role.
     * @param token
     * @param role
     * @return 
     * @throws com.openkm.principal.PrincipalAdapterException 
     */
    public List<User> getUsersByRole(String token, String role) throws PrincipalAdapterException;

    /**
     * Retrieves a list of roles by user.
     *
     * @param token
     * @param user
     * @return A repository user.
     * @throws com.openkm.principal.PrincipalAdapterException
     */
    public List<Role> getRolesByUser(String token, String user) throws PrincipalAdapterException;

    /**
     * Retrieves the mail from an user.
     * @param token
     * @param user
     * @return 
     * @throws com.openkm.principal.PrincipalAdapterException
     */
    public Mail getMail(String token, User user) throws PrincipalAdapterException;

    /*
     * ------------------------------------------------------------------
     * These methods only works if using the OpenKM user database.
     * ------------------------------------------------------------------
     */

    /**
     * Method to create a new user
     * @param token
     * @param user
     * @throws PrincipalAdapterException If any error occurs.
     */
    public void createUser(String token, User user)throws PrincipalAdapterException;

    /**
     * Method to create a delete a user
     *
     * @param token
     * @param user A user id.
     * @throws PrincipalAdapterException If any error occurs.
     */
    public void deleteUser(String token, User user) throws PrincipalAdapterException;

    /**
     * Update user information
     * @param token
     * @param user
     * @throws PrincipalAdapterException If any error occurs.
     */
    public void updateUser(String token, User user) throws PrincipalAdapterException;

    /**
     * Method to create a new role
     * @param token
     * @param rol
     * @throws PrincipalAdapterException If any error occurs.
     */
    public void createRole(String token, Role rol) throws PrincipalAdapterException;

    /**
     * Method to create a delete a role
     * @param token
     * @param rol
     * @throws PrincipalAdapterException If any error occurs.
     */
    public void deleteRole(String token, Role rol) throws PrincipalAdapterException;

    /**
     * Update role information
     *
     * @param token
     * @param rol
     * @throws PrincipalAdapterException If any error occurs.
     */
    public void updateRole(String token, Role rol) throws PrincipalAdapterException;

    /**
     * Method to assign a role
     * @param token
     * @param user
     * @param rol
     * @throws PrincipalAdapterException If any error occurs.
     */
    public void assignRole(String token, User user, Role rol) throws PrincipalAdapterException;

    /**
     * Method to remove a role
     * @param token
     * @param user
     * @param rol
     * @throws PrincipalAdapterException If any error occurs.
     */
    public void removeRole(String token, User user, Role rol) throws PrincipalAdapterException;
}
