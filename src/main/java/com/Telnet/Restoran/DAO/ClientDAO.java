package com.Telnet.Restoran.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Telnet.Restoran.entity.ClientEntity;
import com.Telnet.Restoran.repositories.ClientRepository;
import com.Telnet.Restoran.service.ClientService;

@Service
public class ClientDAO implements ClientService{

	@Autowired
	ClientRepository clientRepo;

	@Override
	public List<ClientEntity> getAllClients() {
		return clientRepo.findAll();
	}

	@Override
	public ClientEntity getClientById(int id) {
		return clientRepo.findById(id).get();
	}

	@Override
	public void insertClient(ClientEntity client) {
		clientRepo.save(client);
	}

	@Override
	public void updateClient(ClientEntity client, int id) {
		clientRepo.updateClient(id, client.getName(), client.getLastname(), client.getUsername(), client.getPassword(), client.getRole(), client.getEmail());
	}

	@Override
	public void deleteClient(int id) {
		clientRepo.deleteById(id);		
	}

}
