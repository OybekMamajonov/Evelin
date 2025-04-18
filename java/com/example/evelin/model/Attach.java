package com.example.evelin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Attach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String origin_name;
    @Column(nullable = false)
    private String size;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String path;
    @Column(nullable = false)
    private String duration;
    @CreatedDate
    private LocalDateTime created_date=LocalDateTime.now();

}
