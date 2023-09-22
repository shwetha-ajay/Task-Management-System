package com.bytes.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bytes.main.TaskManagementSystemApplication;
import com.bytes.repo.UserRepository;
import com.bytes.utils.User;
import com.bytes.utils.UserRole;

@SpringBootTest(classes = TaskManagementSystemApplication.class)
public class UserServiceImplTests {
	@MockBean
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@Test
	void getAllUsers() {

		int userID = 4001;
		String name = "ram";
		String email = "ram22@gmail.com";
		String password = "ram123";
		UserRole roleID = new UserRole(101, "Admin");

		User user = new User(userID, name, email, password, roleID);

		Mockito.when(userRepository.findAll()).thenReturn(Arrays.asList(user));
		assertEquals(1, userService.getAllUsers().size());
	}

	
	@Test
	public void testGetUserIdByEmail() {		
		String testEmail = "test@example.com";
		int expectedUserId = 123;

		// Create a mock User object with the expected behavior
		User mockUser = new User();
		mockUser.setUserID(expectedUserId);

		Mockito.when(userRepository.findByEmail(testEmail)).thenReturn(mockUser);

		int actualUserId = userService.getUserIdByEmail(testEmail);

		// Assert
		assertEquals(expectedUserId, actualUserId);
	}

	
	@Test
	public void testGetUserIdByEmail_UserNotFound() {
		// Arrange
		String testEmail = "nonexistent@example.com";

		Mockito.when(userRepository.findByEmail(testEmail)).thenReturn(null);


		String email = "nonexistent11@example";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			userService.getUserIdByEmail(email);
		});

		assertTrue(exception.getMessage().contains("User not found"));

	}

	@Test
	public void testAddUser() {

		// Create a dummy Task object to pass to the method
		User testUser = new User();
		testUser.setUserID(1);
		testUser.setName("Sample Task");
		testUser.setEmail("sss@gmail.com");
		testUser.setPassword("ss123");

		userService.addUser(testUser);

		Mockito.verify(userRepository, times(1)).save(testUser);
	}

	@Test
	public void testDeleteAdmin() {
	
		int testUserId = 123;

		// Act
		userService.deleteAdmin(testUserId);

		// Assert
		Mockito.verify(userRepository, times(1)).deleteById(testUserId);
	}

	@Test
	public void testGetUserIds() {
		// Arrange
		List<Integer> expectedUserIds = Arrays.asList(1, 2, 3);

		// Stub the userRepository to return the expectedUserIds when findAllUserIds is
		// called
		Mockito.when(userRepository.findAllUserIds()).thenReturn(expectedUserIds);

		// Act
		List<Integer> actualUserIds = userService.getUserIds();

		// Assert
		assertEquals(expectedUserIds, actualUserIds);
	}

	
	@Test
	public void testAddAdmin() {
	
		User testAdmin = new User();

		userService.addAdmin(testAdmin);

		// Assert
		Mockito.verify(userRepository, times(1)).save(testAdmin);
	}
}
