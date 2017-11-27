/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openkm.crobatair.adapter;

import com.openkm.core.Config;
import com.openkm.dao.bean.Role;
import com.openkm.dao.bean.User;
import com.openkm.module.common.CommonAuthModule;
import com.openkm.principal.PrincipalAdapter;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ale
 */
public class CrobatairAuthModule implements CrobatairAdapter{
    private static Logger log = LoggerFactory.getLogger(CommonAuthModule.class);
    private static CrobatairAdapter crobatairAdapter = null;
    
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        /**
	 * Singleton pattern for global Crobatair Adapter.
	 */
	public static synchronized CrobatairAdapter getCrobatairAdapter() throws CrobatairAdapterException{
		if (crobatairAdapter == null) {
			try {
				log.info("CrobatairAdapter: {}", Config.CROBATAIR_ADAPTER);
				Object object = Class.forName(Config.CROBATAIR_ADAPTER).newInstance();
				crobatairAdapter = (CrobatairAdapter) object;
			} catch (ClassNotFoundException e) {
				log.error(e.getMessage(), e);
				throw new CrobatairAdapterException(e.getMessage(), e);
			} catch (InstantiationException e) {
				log.error(e.getMessage(), e);
				throw new CrobatairAdapterException(e.getMessage(), e);
			} catch (IllegalAccessException e) {
				log.error(e.getMessage(), e);
				throw new CrobatairAdapterException(e.getMessage(), e);
			}
		}

		return crobatairAdapter;
	}
        
        
        
        //Add all method to implement here :´v 

    @Override
    public List<User> getAllUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAllUsersByRole(String rol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Role> getAllRoles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Role> getAllRolesByUser(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Role> getAllGrantRoleList(String nodeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAllGrandedUserList(String nodeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUserById(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
