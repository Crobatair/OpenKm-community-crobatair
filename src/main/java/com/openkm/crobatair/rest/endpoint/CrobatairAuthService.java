
package com.openkm.crobatair.rest.endpoint;

import com.openkm.crobatair.adapter.CrobatairAdapterException;
import com.openkm.crobatair.db.CrobatairDbAuthModule;
import com.openkm.dao.bean.Role;
import com.openkm.module.AuthModule;
import com.openkm.module.ModuleManager;
import com.openkm.principal.PrincipalAdapterException;
import com.openkm.rest.GenericException;
import com.openkm.rest.util.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.openkm.dao.bean.User;
import java.util.ArrayList;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class CrobatairAuthService {
    private static Logger log = LoggerFactory.getLogger(CrobatairAuthService.class);

    @GET
    @Path("/getUsers")
    public List<User> getUsers() throws GenericException {
        List<User> resultado = null;
            try {
                log.debug("getUsers()");
                CrobatairDbAuthModule am = ModuleManager.getCrobatairAuthModule();
                if (am != null) {
                    resultado = am.getUsers(null);
                    if (resultado != null) {
                        return resultado;
                    } else {
                        resultado = new ArrayList();
                    }
                }
                    log.debug("getAllUsuarios: void");
            } catch (CrobatairAdapterException e) {
                    throw new GenericException(e);
            }
        return resultado;
    }

    @GET
    @Path("/getUsersByRole/{role}")
    public List<User> getUsersByRole(@PathParam("role") String role) throws GenericException, PrincipalAdapterException {
        List<User> resultado = null;
            try {
                log.debug("getUsersByRole()");
                CrobatairDbAuthModule am = ModuleManager.getCrobatairAuthModule();
                if (am != null) {
                    resultado = am.getUsersByRole(null, role);
                    if (resultado != null) {
                        return resultado;
                    } else {
                        resultado = new ArrayList();
                    }

                } else {
                }
                    log.debug("getUsersByRole: List<User>");
            } catch (CrobatairAdapterException e) {
                    throw new GenericException(e);
            }
        return resultado;
    }    
        
    @GET
    @Path("/getRoles")
    public List<Role> getRoles() throws GenericException, PrincipalAdapterException {
        List<Role> resultado = null;
            try {
                log.debug("getUsers()");
                CrobatairDbAuthModule am = ModuleManager.getCrobatairAuthModule();
                if (am != null) {
                    resultado = am.getRoles(null);
                    if (resultado != null) {
                        return resultado;
                    } else {
                        resultado = new ArrayList();
                    }

                } else {
                }
                    log.debug("getRoles: void");
            } catch (CrobatairAdapterException e) {
                    throw new GenericException(e);
            }
        return resultado;
    }

    @GET
    @Path("/getRolesByUser/{user}")
    public List<Role> getRolesByUser(@PathParam("user") String user) throws GenericException, PrincipalAdapterException {
        List<Role> resultado = null;
            try {
                log.debug("getUsersByRole()");
                CrobatairDbAuthModule am = ModuleManager.getCrobatairAuthModule();
                if (am != null) {
                    resultado = am.getRolesByUser(null, user);
                    if (resultado != null) {
                        return resultado;
                    } else {
                        resultado = new ArrayList();
                    }

                } else {
                }
                    log.debug("getUsersByRole: List<User>");
            } catch (CrobatairAdapterException e) {
                    throw new GenericException(e);
            }
        return resultado;
    }    




}
