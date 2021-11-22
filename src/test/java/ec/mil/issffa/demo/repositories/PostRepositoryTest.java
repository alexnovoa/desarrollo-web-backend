package ec.mil.issffa.demo.repositories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ec.mil.issffa.demo.models.Post;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PostRepositoryTest {
    
    @Autowired
    private PostRepository postRepository;
    
    @Test
    public void save(){
         Post post = new Post();
         post.setTitle("titulo demo");
         Assert.assertEquals(post.getTitle(), postRepository.save(post).getTitle());
       }

}
