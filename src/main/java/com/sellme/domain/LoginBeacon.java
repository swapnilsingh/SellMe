/**
 * 
 */
package com.sellme.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author "Swapnil Singh"
 *
 */
public class LoginBeacon {

    private StatusBean statusBean;
    private String sessionToken;
    
    @JsonProperty
    public StatusBean getStatusBean() {
        return statusBean;
    }
    public void setStatusBean(StatusBean statusBean) {
        this.statusBean = statusBean;
    }
    @JsonProperty
    public String getSessionToken() {
        return sessionToken;
    }
    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }
    
}
