package com.macropay.msapp.security.service;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public AuthenticationService() {
		
	}
	/*
    @SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsAuthentication() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	
    	if(Objects.isNull(authentication) 
    			|| !(authentication.getDetails() instanceof OAuth2AuthenticationDetails)) {
    		return Collections.emptyMap();
    	}
    	
    	OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
        return (Map<String, Object>) details.getDecodedDetails();
    }
    */
    /*
    public String getPrincipal() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	return (String) authentication.getPrincipal();
    }
	*/
}
