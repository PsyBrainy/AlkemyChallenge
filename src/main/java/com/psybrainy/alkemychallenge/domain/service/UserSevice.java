package com.psybrainy.alkemychallenge.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.psybrainy.alkemychallenge.persistence.crud.RolCrudRepository;
import com.psybrainy.alkemychallenge.persistence.crud.UserCrudRepository;
import com.psybrainy.alkemychallenge.persistence.entity.UserEntity;

@Service
public class UserSevice implements UserDetailsService{
	
	@Autowired
    private UserCrudRepository userRepo;
	
	@Autowired
    private RolCrudRepository rolRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity user = userRepo.findByUsername(username);
		
		List<GrantedAuthority> rol = new ArrayList<>();
		rol.add(new SimpleGrantedAuthority(rolRepo.findByUserId(user.getId()).getRol()));
		
		return new User(user.getUsername(),user.getPassword(),rol);
	}

}
