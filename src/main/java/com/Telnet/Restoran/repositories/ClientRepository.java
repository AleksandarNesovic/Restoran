package com.Telnet.Restoran.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Telnet.Restoran.entity.ClientEntity;
import com.Telnet.Restoran.entity.Role;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Integer>{

//	@Transactional
//	@Modifying
//	@Query(value="UPDATE ClientEntity c SET c.name=:name, c.lastname=:lastname, c.username=:username, c.password=:password,c.role=:role,c.email=:email, c.role_id=:role_id WHERE c.client_id=:client_id")
//	public void updateClient(@Param("client_id") int client_id,@Param("name") String name,@Param("lastname") String lastname,@Param("username") String username,@Param("password") String password,@Param("role") String role,@Param("email") String email,@Param("role_id") Role role_id);

	Optional<ClientEntity> findByUsername(String username);
}
