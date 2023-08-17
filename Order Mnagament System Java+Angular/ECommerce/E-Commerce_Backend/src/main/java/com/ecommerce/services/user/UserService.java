package com.ecommerce.services.user;


import com.ecommerce.dto.SignupRequest;
import com.ecommerce.dto.UserDto;
import com.ecommerce.entity.User;
import com.ecommerce.responce.GeneralResponse;

public interface UserService {

     User createUser(SignupRequest signupRequest) throws Exception;

     Boolean hasUserWithEmail(String email);

     void createAdminAccount();

     UserDto getUser(Long userId);
}
