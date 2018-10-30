package com.Telnet.Restoran.security;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.Telnet.Restoran.entity.ClientEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ClientPrincipal implements UserDetails{
	
	private int client_id; 
	
	private String name;
	
	private String lastname;
	
	private String username;
	@JsonIgnore
	private String password;
	@JsonIgnore
	private String email;

	//private String role;
	
	List<GrantedAuthority> listOfAuthorities;
	
	private GrantedAuthority authorities;
	
	
	public ClientPrincipal(int client_id, String name, String lastname, String username, String password, String email,
			GrantedAuthority authorities) {
		super();
		this.client_id = client_id;
		this.name = name;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.authorities = authorities;
	}
	
	public int getClient_id() {
		return client_id;
	}

	public String getName() {
		return name;
	}

	public String getLastname() {
		return lastname;
	}
	public String getEmail() {
		return email;
	}

	public static ClientPrincipal create(ClientEntity client) {
		GrantedAuthority authorities = new SimpleGrantedAuthority(client.getRole());
		return new ClientPrincipal(client.getClient_id(), client.getName(), client.getLastname(), client.getUsername(), client.getPassword(), client.getEmail(), authorities);
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		listOfAuthorities.add(authorities);
		return listOfAuthorities ;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientPrincipal that=(ClientPrincipal) o;
        return Objects.equals(client_id, that.client_id);
}
	 @Override
	    public int hashCode() {

	        return Objects.hash(client_id);
	    }
}