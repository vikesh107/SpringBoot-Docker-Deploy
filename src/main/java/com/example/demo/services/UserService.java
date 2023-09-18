package com.example.demo.services;

import java.util.List;

import com.example.demo.payloads.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto dto);
	UserDto updateUser(UserDto dto,Integer id);
	void  deleteUser(Integer id);
	List<UserDto> getAllUser();
	UserDto getUserById(Integer id);

}
