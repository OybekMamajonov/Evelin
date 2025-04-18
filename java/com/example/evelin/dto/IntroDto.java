package com.example.evelin.dto;

import com.example.evelin.model.Attach;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntroDto {

    private String title;
    @Column(nullable = false)
    private String description;
    @OneToOne
    private Integer image_id;

}
