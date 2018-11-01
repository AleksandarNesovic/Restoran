package com.Telnet.Restoran.service;

import java.util.List;

import com.Telnet.Restoran.entity.ClientEntity;

public interface ClientService {

	public List<ClientEntity> getAllClients();
	
	public ClientEntity getClientById(int id);
	
	public void insertClient(ClientEntity client);
	
//	public void updateClient(ClientEntity client,int id);
	
	public void deleteClient(int id);
}
