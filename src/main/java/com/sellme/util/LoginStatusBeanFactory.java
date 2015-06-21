/**
 * 
 */
package com.sellme.util;

import java.util.HashMap;
import java.util.Map;

import com.sellme.domain.LoginStatus;
import com.sellme.domain.Status;
import com.sellme.domain.StatusBean;

/**
 * @author "Swapnil Singh"
 *
 */
public class LoginStatusBeanFactory {

    private static final Map<LoginStatus, StatusBean> loginStatusBeans = new HashMap<LoginStatus, StatusBean>();

    static {
        loginStatusBeans.put(LoginStatus.USER_DOES_NOT_EXISTS,
                getUserExistanceStatusBean());
        loginStatusBeans.put(LoginStatus.USER_ALREADY_LOGGED_IN,
                getAlreadyLoggedInStatusBean());
        loginStatusBeans.put(LoginStatus.USER_SUCCESSFULLY_LOGGED_IN,
                getUserSuccessFullyLoggedInStatusBean());
        loginStatusBeans.put(LoginStatus.INVALID_CREDENTIALS,
                getInvalidCredentialsStatusBean());
        loginStatusBeans.put(LoginStatus.USER_DISABLED,
                getUserDisabledStatusBean());
    }

    private LoginStatusBeanFactory() {

    }

    /**
     * @return
     */
    private static StatusBean getUserDisabledStatusBean() {
        StatusBean statusBean = new StatusBean();
        statusBean
                .setMessage("User account is deactivated please contact Admin.");
        statusBean.setStatus(Status.UNSUCCESSFUL);
        return statusBean;
    }

    public static StatusBean getStatusBean(LoginStatus loginStatus) {
        return loginStatusBeans.get(loginStatus);
    }

    /**
     * @return
     */
    private static StatusBean getInvalidCredentialsStatusBean() {
        StatusBean statusBean = new StatusBean();
        statusBean.setMessage("Invalid Credentials!.");
        statusBean.setStatus(Status.UNSUCCESSFUL);
        return statusBean;
    }

    /**
     * @return
     */
    private static StatusBean getUserSuccessFullyLoggedInStatusBean() {
        StatusBean statusBean = new StatusBean();
        statusBean.setMessage("Welcome to Sell Me!");
        statusBean.setStatus(Status.SUCCESSFUL);
        return statusBean;
    }

    /**
     * @return
     */
    private static StatusBean getAlreadyLoggedInStatusBean() {
        StatusBean statusBean = new StatusBean();
        statusBean.setMessage("User already logged in some other device.");
        statusBean.setStatus(Status.UNSUCCESSFUL);
        return statusBean;
    }

    /**
 * 
 */
    private static StatusBean getUserExistanceStatusBean() {
        StatusBean statusBean = new StatusBean();
        statusBean.setMessage("User does not exists");
        statusBean.setStatus(Status.UNSUCCESSFUL);
        return statusBean;
    }
}
