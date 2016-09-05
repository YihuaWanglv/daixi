//package com.iyihua.daixi.service;
//
//import java.security.NoSuchAlgorithmException;
//import java.security.spec.InvalidKeySpecException;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.script.DigestUtils;
//import org.springframework.stereotype.Service;
//import org.springframework.util.Assert;
//
//import com.iyihua.daixi.mapper.UserMapper;
//import com.iyihua.daixi.model.User;
//import com.iyihua.daixi.repository.UserRepository;
//import com.iyihua.daixi.service.remote.UserRemote;
//import com.iyihua.daixi.util.PasswordSecureHash;
//import com.iyihua.daixi.web.dto.UserDTO;
//
//
//
//
//@Service
//public class UserService implements UserRemote {
//
//	@Autowired private UserRepository userRepository;
//	@Autowired private UserMapper userMapper;
//	
//	@Override
//	public UserDTO findUserById(Long id) {
//		Assert.notNull(id, "userId can not be null!");
//		UserDTO result = null;
//		User user = userRepository.findOne(id);
//		if (user != null) {
//			result = new UserDTO();
//			BeanUtils.copyProperties(user, result);
////			UserConfig uc = userConfigRepository.findOne(user.getUserConfigId());
//		}
//		return result;
//	}
//
//	@Override
//	public UserDTO createUser(UserDTO user) throws NoSuchAlgorithmException, InvalidKeySpecException {
//		Assert.notNull(user, "User can not be null!");
//		User save = new User();
//		BeanUtils.copyProperties(user, save);
//		String salt = PasswordSecureHash.createRandom();
//		save.setPassword(PasswordSecureHash.hashEncrypt(user.getPassword(), salt));
//		save.setSalt(salt);
//		save.setCode(DigestUtils.sha1DigestAsHex(user.getCode()+salt));
//		save = userRepository.save(save);
//		BeanUtils.copyProperties(save, user);
//		return user;
//	}
//
//	@Override
//	public void deleteUser(Long id) {
//		userRepository.delete(id);
//	}
//
//	@Override
//	public UserDTO findUserByName(String username) {
//		UserDTO result = null;
//		User user = userRepository.findByName(username);
//		if (user != null) {
//			result = new UserDTO();
//			BeanUtils.copyProperties(user, result);
//		}
//		return result;
//	}
//
//
//	@Override
//	public UserDTO updateUser(UserDTO user, Boolean isUpdateSelected) throws NoSuchAlgorithmException, InvalidKeySpecException {
//		Assert.notNull(user, "User can not be null!");
//		User save = new User();
//		BeanUtils.copyProperties(user, save);
//		if (isUpdateSelected != null && isUpdateSelected) {
//			int r = userMapper.updateUserSelective(save);
//			if (r <= 0) {
//				return null;
//			}
//		} else {
//			save = userRepository.save(save);
//		}
//		return user;
//	}
//
//
//	
//
//}
