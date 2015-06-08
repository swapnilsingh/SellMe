/**
 * 
 */
package com.sellme.dao;

import org.skife.jdbi.v2.sqlobject.SqlUpdate;

/**
 * @author Swapnil Singh
 *
 */
public interface UserDAO {

    @SqlUpdate("")
    void createUser();
    
}
