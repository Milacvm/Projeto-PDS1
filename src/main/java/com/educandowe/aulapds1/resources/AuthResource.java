package com.educandowe.aulapds1.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandowe.aulapds1.dto.CredentialsDTO;
import com.educandowe.aulapds1.dto.TokenDTO;
import com.educandowe.aulapds1.services.AuthService;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {
	
	@Autowired
	private AuthService service;
	
	@PostMapping("/login")
	public ResponseEntity<TokenDTO> login(@RequestBody CredentialsDTO dto) {
		TokenDTO tokenDTO  = service.authenticate(dto);
	    return ResponseEntity.ok().body(tokenDTO);
	}
	

}
