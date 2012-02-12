/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yaid.files;

import com.yaid.user.UserDetailsBean;
import java.util.List;

/**
 *
 * @author vignesh
 */
public interface YAIDFileHandler {
    
    public List<String> ListDirectaries(UserDetailsBean user,String path);
    
}
