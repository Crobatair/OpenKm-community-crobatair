
package com.openkm.crobatair.rest.endpoint;

import com.openkm.crobatair.adapter.CrobatairAdapterException;
import com.openkm.crobatair.db.CrobatairDbAuthModule;
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
import java.util.Map;
import java.util.Map.Entry;



@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class CrobatairAuthService {
	private static Logger log = LoggerFactory.getLogger(CrobatairAuthService.class);

	@GET
	@Path("/getUsers")
	public List<User> getAllUsuarios() throws GenericException {
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
                        
                    } else {
                    }
			log.debug("getAllUsuarios: void");
		} catch (CrobatairAdapterException e) {
			throw new GenericException(e);
		}
            return resultado;
	}

}
