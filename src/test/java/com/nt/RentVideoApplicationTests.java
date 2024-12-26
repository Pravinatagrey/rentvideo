package com.nt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.nt.controller.exchanges.request.RegisterRequest;
import com.nt.controller.exchanges.response.AuthResponse;
import com.nt.entity.User;
import com.nt.entity.enums.Role;
import com.nt.repository.UserRepository;
import com.nt.service.AuthService;

@SpringBootTest
class RentVideoApplicationTests {

	 @Autowired
	 private AuthService userService;
	 
	 

	 @MockBean
	 private UserRepository userRepository;
	 
	@Test
	void contextLoads() {
		 assertTrue(true, "Context loads successfully");
	}
	
	 @Test
	    void testRegisterUser() {
		 //using builder design pattern
	        User user = User.builder()
	                .email("pravin@gmail.com")
	                .password("pravin")
	                .firstName("Pravin")
	                .lastName("Atagrey")	
	                .role(Role.CUSTOMER)
	                .build();

	        when(userRepository.save(any(User.class))).thenReturn(user);
	    RegisterRequest ruser=RegisterRequest.builder().email("pravin@gmail.com")
		                .password("pravin")
		                .firstName("Pravin")
		                .lastName("Atagrey")	
		                .role(Role.CUSTOMER)
		                .build();
	        	
	        AuthResponse registeredUser = userService.register(ruser);

	        assertNotNull(registeredUser);
	        assertEquals(user.getRole(),ruser.getRole());
	        assertEquals("Success", registeredUser.getMessage());
	     //   verify(userRepository, times(1)).save(user);
	    }

	    @Test
	    void testFindUserByEmail() {
	        User user = User.builder()
	                .email("pravin@gmail.com")
	                .password("pravin")
	                .firstName("Pravin")
	                .lastName("Atagrey")
	         
	                .build();

	        when(userRepository.findByEmail("pravin@gmail.com")).thenReturn(user);

	        User result = userService.findByEmail("pravin@gmail.com");

	        assertTrue(result==null?false:true);
	        assertEquals("pravin@gmail.com", result.getEmail());
	        verify(userRepository, times(1)).findByEmail("pravin@gmail.com");
	    }

	    @Test
	    void testUserNotFound() {
	    	User user=null;
	        when(userRepository.findByEmail("test@gmail.com")).thenReturn(user);

	        User result = userService.findByEmail("test@gmail.com");

	        assertFalse(result==null?false:true);
	        verify(userRepository, times(1)).findByEmail("test@gmail.com");
	    }

}
