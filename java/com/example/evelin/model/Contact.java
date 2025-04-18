package com.example.evelin.model;

import com.example.evelin.model.entity.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String massage;
    @OneToOne
    private Profile profile_id;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = false)
    private Integer reply;

}
