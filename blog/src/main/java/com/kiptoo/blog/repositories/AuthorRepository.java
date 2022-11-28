package com.kiptoo.blog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kiptoo.blog.entities.Author;

public interface AuthorRepository extends CrudRepository<Author,Long>{

    
}
