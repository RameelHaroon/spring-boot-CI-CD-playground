package com.example.BasicCRUD.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    @Column(length = 36, updatable = false, nullable = false, name = "id")
    private UUID id;

    @Version
    private Integer version;
    private String name;

    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}
