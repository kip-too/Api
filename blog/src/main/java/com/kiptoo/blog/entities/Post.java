package com.kiptoo.blog.entities;

import java.time.LocalDateTime;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String content;

    @Column
    private String title;

    @Column
    private String synopsis;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Column
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime dateTime;
}
