package com.jyalla.demo;

import static org.junit.Assert.assertTrue;
import java.util.UUID;
import org.junit.Ignore;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import com.jyalla.demo.modal.User;
import com.jyalla.demo.service.UserService;


@TestMethodOrder(OrderAnnotation.class)
public class ExceptionHandlerTest extends BaseClass {


    @Autowired
    UserService userService;

    static UUID employeeId;

    @Test
    @Order(1)
    public void getAllUsers() {
        assertTrue(userService.getAllUsers()
                .size() > 0);
    }

    @Test
    @Order(2)
    public void saveUser() {
        User user = new User();
        user.setEmail("servicetest@test.com");
        user.setUsername("hello");
        user.setPhoneNo("6752398751");
        User savedUser = userService.save(user);
        assertTrue(savedUser != null);
        employeeId = savedUser.getId();
    }

    @Test
    @Order(3)
    public void getUserById() {
        assertTrue(userService.getSingleUser(employeeId) != null);
    }

    @Ignore
    @Order(6)
    public void saveUser_MissingName() {
        User user = new User();
        user.setEmail("servicetest@test.com"); // user.setUsername("hello");
        user.setPhoneNo("6752398751");
        assertTrue(userService.save(user) != null);
    }

    @Ignore
    @Order(7)
    public void saveUser_MissingPhone() {
        User user = new User();
        user.setEmail("servicetest@test.com");
        user.setUsername("hello"); //
        user.setPhoneNo("6752398751");
        assertTrue(userService.save(user) != null);
    }

    @Test
    @Order(4)
    public void modifyUser() {
        User user = userService.getSingleUser(employeeId);
        user.setPhoneNo("123");
        User savedUser = userService.save(user);
        assertTrue(savedUser.getPhoneNo()
                .equalsIgnoreCase("123"));
    }

    @Test
    @Order(5)
    public void deleteUser() {
        User user = userService.getSingleUser(employeeId);
        userService.delete(user);
        assertTrue(userService.getSingleUser(employeeId) == null);
    }

}
