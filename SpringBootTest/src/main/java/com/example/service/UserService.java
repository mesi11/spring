package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.repository.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository userRepository;

	public List<User> findAll(){
		return userRepository.findAll();
	}

//	public Page<User> findAll(Pageable pageable){
//		return userRepository.findAllOrderByName(pageable);
//	}
}
