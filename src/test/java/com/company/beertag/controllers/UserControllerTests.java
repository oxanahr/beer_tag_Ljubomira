package com.company.beertag.controllers;


import com.company.beertag.models.users.User;
import com.company.beertag.models.users.UserType;
import com.company.beertag.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {
    @MockBean
    UserService mockService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void add_Should_Return_StatusOk_When_User_IsValid() throws Exception {
        //Arrange
        User user=new User(1,"Martin", UserType.VISITOR,"12345");

        //Act
        mockMvc.perform(MockMvcRequestBuilders
        .post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonHelper.convertObjectToJson(user)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void add_Should_Return_StatusBadRequest_When_IdIsNegative() throws Exception {
        //Arrange
        User user=new User(-1,"Martin", UserType.VISITOR,"12345");

        //Act
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonHelper.convertObjectToJson(user)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void add_Should_Return_StatusBadRequest_When_NameIsShort() throws Exception {
        //Arrange
        User user=new User(1,"M", UserType.VISITOR,"12345");

        //Act
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonHelper.convertObjectToJson(user)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void add_Should_Return_StatusBadRequest_When_NameIsLong() throws Exception {
        //Arrange
        User user=new User(1,"MartinMartinMartinMartinMartinMartin", UserType.VISITOR,"12345");

        //Act
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonHelper.convertObjectToJson(user)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}
