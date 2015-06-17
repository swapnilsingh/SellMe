/**
 *
 */
package com.sellme.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Swapnil Singh
 *
 */
public class StatusBean {

    private String message;
    private Status status;

    /**
     *
     */
    public StatusBean() {
    }

    /**
     * @param message
     * @param status
     */
    public StatusBean(String message, Status status) {
        this.message = message;
        this.status = status;
    }

    @JsonProperty
    public final String getMessage() {
        return message;
    }

    public final void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty
    public final Status getStatus() {
        return status;
    }

    public final void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StatusBean [message=" + message + ", status=" + status + "]";
    }

}
