package com.app.lightscroll_api.lightscroll_api.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Novel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String genre;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}