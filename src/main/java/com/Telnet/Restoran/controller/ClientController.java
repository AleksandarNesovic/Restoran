package com.Telnet.Restoran.controller;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Telnet.Restoran.DAO.ClientDAO;
import com.Telnet.Restoran.entity.ClientEntity;
import com.Telnet.Restoran.entity.Role;
import com.Telnet.Restoran.exceptions.AppException;
import com.Telnet.Restoran.model.RoleName;
import com.Telnet.Restoran.payload.ApiResponse;
import com.Telnet.Restoran.payload.SignUpRequest;
import com.Telnet.Restoran.repositories.ClientRepository;
import com.Telnet.Restoran.repositories.RoleRepository;

@RestController
@RequestMapping("/clients")
@Secured("ROLE_ADMIN")
public class ClientController {

	@Autowired
	ClientDAO clientDAO;

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping
	public List<ClientEntity> getAllClients(){
		return clientDAO.getAllClients();
	}
	@GetMapping("/{id}")
	public ClientEntity getClientById(@PathVariable int id) {
		return clientDAO.getClientById(id);
	}
	
	@PostMapping
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		if(clientRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}
		ClientEntity client=new ClientEntity(signUpRequest.getName(), signUpRequest.getLastname(), signUpRequest.getUsername(), signUpRequest.getPassword(), signUpRequest.getRole(), signUpRequest.getEmail());
		
		client.setPassword(passwordEncoder.encode(client.getPassword()));
		
		Role clientRole=roleRepository.findByName(RoleName.ROLE_USER).orElseThrow(() -> new AppException("Client role not set."));
		
		client.setRoles(Collections.singleton(clientRole));

		
		ClientEntity result=clientRepository.save(client);
		URI location=ServletUriComponentsBuilder.fromCurrentContextPath().path("/clients/{username}")
				.buildAndExpand(result.getUsername()).toUri();
		
		return ResponseEntity.created(location).body(new ApiResponse(true, "Client registered successfully"));
	}
	@PutMapping("/{id}")
	public void updateClient(@RequestBody ClientEntity client,@PathVariable int id) {
		clientDAO.updateClient(client, id);
	}
	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable int id) {
		clientDAO.deleteClient(id);
	}


}
