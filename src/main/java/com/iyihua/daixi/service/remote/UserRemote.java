
package com.iyihua.daixi.service.remote;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import com.iyihua.daixi.web.dto.UserDTO;



public interface UserRemote {

	public UserDTO findUserById(Long id);
	
	public UserDTO createUser(UserDTO user) throws NoSuchAlgorithmException, InvalidKeySpecException;
	
	public void deleteUser(Long id); 
	
	public UserDTO findUserByName(String username);
	
	public UserDTO updateUser(UserDTO user, Boolean isUpdateSelected) throws NoSuchAlgorithmException, InvalidKeySpecException;
	

}
