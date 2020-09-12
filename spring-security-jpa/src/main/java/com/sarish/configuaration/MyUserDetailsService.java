package com.sarish.configuaration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sarish.model.MyUserDetails;
import com.sarish.model.User;
import com.sarish.repository.UserRepository;
@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	UserRepository repository;
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = repository.findByUserName(userName);
		user.orElseThrow(()->new UsernameNotFoundException("Not Found: "+userName));
		return user.map(MyUserDetails::new).get();
	}

}
