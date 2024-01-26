package com.example.springboot;

import com.example.springboot.dao.*;
import com.example.springboot.model.*;
import com.example.springboot.repository.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostDaoTest {

    @Mock
    private PostRepository postRepository;
    private PostDao SUT;

    @BeforeEach
    void setup() {
        this.SUT = new PostDao(postRepository);
    }

    @Test
    void shouldAddPostToRepository() {
        Post post = new Post();
        post.setID(1L);
        post.setTitle("Test Post");
        post.setDescription("Dit is een test description");
        post.setLink("www.google.com");

        User user = new User();
        user.setID(1L);

        post.setUser(user);

        when(postRepository.save(post)).thenReturn(post);

        Post addedPost = SUT.addPost(post);

        assertNotNull(addedPost);
        assertEquals(addedPost, post);
    }

}