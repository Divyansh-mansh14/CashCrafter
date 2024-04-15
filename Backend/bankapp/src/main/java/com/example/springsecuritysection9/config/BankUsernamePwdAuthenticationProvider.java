package com.example.springsecuritysection9.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.springsecuritysection9.model.Authority;
import com.example.springsecuritysection9.model.Customer;
import com.example.springsecuritysection9.repository.CustomerRepository;

@Component
public class BankUsernamePwdAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		
		List<Customer> customer = customerRepository.findByEmail(username);
		
		if(customer.size() > 0) {
			if(passwordEncoder.matches(pwd, customer.get(0).getPwd())) {
				return new UsernamePasswordAuthenticationToken(username, pwd, getGrantedAuthorities(customer.get(0).getAuthorities()));
			} else {
				throw new BadCredentialsException("Invalid Credentials");
			}
		} else {
			throw new BadCredentialsException("No User Registered with this details!");
		}
	}
	
	public List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for(Authority authority : authorities) {
			grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
		}
		return grantedAuthorities;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		//This is used for username password Authentication
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
