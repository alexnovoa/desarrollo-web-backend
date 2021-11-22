package ec.mil.issffa.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.mil.issffa.demo.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByTitle(String title);
}
