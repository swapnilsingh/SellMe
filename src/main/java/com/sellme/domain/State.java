/**
 *
 */
package com.sellme.domain;

/**
 * @author Swapnil Singh
 *
 */
public enum State {
    MADHYA_PRADESH(8414), INVALID_STATE;
    private long stateCode;

    /**
     * @param stateCode
     */
    private State(long stateCode) {
        this.stateCode = stateCode;
    }

    private State() {
    }

    public static State getStateType(long stateCode) {
        State stateType = State.INVALID_STATE;
        for (State state : values()) {
            if (state.stateCode == stateCode) {
                stateType = state;
            }
        }
        return stateType;
    }

    public final long getStateCode() {
        return stateCode;
    }
}
