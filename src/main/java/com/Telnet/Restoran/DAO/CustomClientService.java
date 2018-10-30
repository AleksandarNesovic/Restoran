package com.Telnet.Restoran.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Telnet.Restoran.entity.ClientEntity;
import com.Telnet.Restoran.exceptions.ResourceNotFoundException;
import com.Telnet.Restoran.repositories.ClientRepository;
import com.Telnet.Restoran.security.ClientPrincipal;

@Service
public class CustomClientService implements UserDetailsService{

	@Autowired
	ClientRepository clientRepo;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ClientEntity client=clientRepo.findByUsername(username).orElseThrow(() ->
        new UsernameNotFoundException("User not found with username or email : " + username)
);
		return ClientPrincipal.create(client);
	}
	
	@Transactional
	public UserDetails loadUserById(int id) {
		ClientEntity client=clientRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client", "id", id));
	return ClientPrincipal.create(client);
	}
}
