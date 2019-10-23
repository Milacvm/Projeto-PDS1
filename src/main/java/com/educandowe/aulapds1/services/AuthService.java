package com.educandowe.aulapds1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.educandowe.aulapds1.dto.CredentialsDTO;
import com.educandowe.aulapds1.dto.TokenDTO;
import com.educandowe.aulapds1.security.JWTUtil;
import com.educandowe.aulapds1.services.exceptions.JWTAuthenticationException;


@Service
public class AuthService {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	public TokenDTO authenticate(CredentialsDTO dto) {
		try {
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken (dto.getEmail(), dto.getPassword());
	    authenticationManager.authenticate(authToken);
	    String token = jwtUtil.generateToken(dto.getEmail());
	    return new TokenDTO(dto.getEmail(),token);
	}catch (AuthenticationException e) {
	    throw new JWTAuthenticationException("Bad credentials");	
	}
  }
}