package com.kiptoo.blog.repositories;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.kiptoo.blog.entities.Post;

public interface PostRepository extends PagingAndSortingRepository<Post,Long>{

    Optional<Post> findById(long id);

    long count();
    
}
