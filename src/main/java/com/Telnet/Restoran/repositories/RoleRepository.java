package com.Telnet.Restoran.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Telnet.Restoran.entity.Role;
import com.Telnet.Restoran.model.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

	Optional<Role> findByName(RoleName roleName);
}
