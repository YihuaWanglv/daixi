package com.iyihua.daixi.config.security;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.iyihua.daixi.mapper.UserMapper;
import com.iyihua.daixi.model.User;
import com.iyihua.daixi.model.base.CredentialsInfoHolder;
import com.iyihua.daixi.service.remote.UserRemote;
import com.iyihua.daixi.web.dto.UserDTO;

//@Component
public class MyRealm extends AuthorizingRealm {

	@Autowired
	UserRemote userService;

	@Autowired
	UserMapper userMapper;

	// @Autowired
	// CredentialsMatcher customCredentialsMatcher;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		UserDTO user = (UserDTO) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		List<String> roles = userMapper.findRoleNameByUserId(user.getId());
		info.addRoles(roles);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String username = usernamePasswordToken.getUsername();

		User user = userService.findUserByName(username);

		if (null != user) {
			CredentialsInfoHolder cih = new CredentialsInfoHolder(user.getPassword(), user.getSalt());
			return new SimpleAuthenticationInfo(user, cih, getName());
		}

		return null;
	}

}
