package com.Telnet.Restoran.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Telnet.Restoran.DAO.ClientDAO;
import com.Telnet.Restoran.entity.ClientEntity;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	ClientDAO clientDAO;
	
	@GetMapping
	public List<ClientEntity> getAllClients(){
		return clientDAO.getAllClients();
	}
	@GetMapping("/{id}")
	public ClientEntity getClientById(@PathVariable int id) {
		return clientDAO.getClientById(id);
	}
	@PostMapping
	public void insertClient(@RequestBody ClientEntity client) {
		clientDAO.insertClient(client);
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
