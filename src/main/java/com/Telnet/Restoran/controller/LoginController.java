package com.Telnet.Restoran.controller;

import javax.json.Json;
import javax.validation.Valid;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Telnet.Restoran.payload.JwtAuthenticationResponse;
import com.Telnet.Restoran.payload.LoginRequest;
import com.Telnet.Restoran.repositories.ClientRepository;
import com.Telnet.Restoran.security.JwtTokenProvider;


@RestController
@RequestMapping("webapi/clients")
public class LoginController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	ClientRepository clientRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtTokenProvider tokenProvider;
	
	@PostMapping(value="/login", produces= MediaType.APPLICATION_JSON)
	public ResponseEntity<String> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                        )
                );
		SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = "Bearer "+tokenProvider.generateToken(authentication);
        
        System.out.println(jwt);
        return new ResponseEntity<String> (Json.createValue(jwt).toString(),HttpStatus.OK);
    }
}
