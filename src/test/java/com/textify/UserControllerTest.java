package com.textify;

import static org.assertj.core.api.Assertions.*;
import com.textify.entity.User;
import com.textify.repo.UserRepo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    public static final String API_V1_USERS = "api/v1/users";

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    UserRepo userRepo;

    @BeforeEach
    public void clean(){
        userRepo.deleteAll();
    }

    @Test
    public void testPostUserOK(){
        User user = generateValidUser();
        ResponseEntity<Object> response = testRestTemplate.postForEntity(API_V1_USERS, user, Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    @Test
    public void testPostUserToDatabase(){
        User user = generateValidUser();
        testRestTemplate.postForEntity(API_V1_USERS,user,Object.class);
    }

/*    @Test
    public void testPostUserSuccessMessage(){
        User user = generateValidUser();
        ResponseEntity<Object> response = testRestTemplate.postForEntity(API_V1_USERS, user, Object.class);
        assertThat(response.getBody().getMessage()).isNotNull();
    }*/

    @Test
    public void TestHashingOfPassword(){
        User user = generateValidUser();
        ResponseEntity<Object> response = testRestTemplate.postForEntity(API_V1_USERS, user, Object.class);
        List<User> users = userRepo.findAll();
        User inDB = users.get(0);
        assertThat(inDB.getPassword()).isNotEqualTo(user.getPassword());
    }


    private User generateValidUser() {
        User user = new User();
        user.setUsername("Manfred");
        user.setNickname("Gamerlamer");
        user.setPassword("98765");
        return user;
    }


    }

