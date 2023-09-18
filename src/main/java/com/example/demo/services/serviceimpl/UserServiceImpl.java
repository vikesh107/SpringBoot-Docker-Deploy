package com.example.demo.services.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitys.User;
import com.example.demo.exceptions.ResorceNotFountException;
import com.example.demo.payloads.UserDto;
import com.example.demo.repos.UserRepo;
import com.example.demo.services.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private  UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public UserDto createUser(UserDto dto) {
		System.out.println("Ye chl raha hai ki nahi ====== +++++++");
		User user = this.userDtoToUser(dto);
		User savedUser = this.userRepo.save(user);
		return this.userToUserDto(savedUser); //yaha  na show karenga ye
	}

	@Override
	public UserDto updateUser(UserDto dto, Integer id) {
		User user = this.userRepo.findById(id).orElseThrow(()-> new ResorceNotFountException("User", "Id",id));
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setAbout(dto.getAbout());
		
		User updateUser = this.userRepo.save(user); //yaha par jo user save hua hai usko update kar ra database me
		
		return this.userToUserDto(updateUser);
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(id).orElseThrow(()->new ResorceNotFountException("User", "Id",id));
		this.userRepo.delete(user);

	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> userlist = this.userRepo.findAll();
		List<UserDto> listOfUserDto = userlist.stream().map(user -> this.userToUserDto(user)).collect(Collectors.toList());
		return listOfUserDto;
	}

	@Override
	public UserDto getUserById(Integer id) {
		User user = this.userRepo.findById(id).orElseThrow(()-> new ResorceNotFountException("User", "Id",id)); //is line se id se chl ke user ki details mil jayengi jo ki user object me store ho jayenga simple 
		return this.userToUserDto(user);
	}
	
	public User userDtoToUser(UserDto userDto)
	{
		User user = this.modelMapper.map(userDto, User.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		return user;
	}
	
	public UserDto userToUserDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
		return userDto;
	}

}
