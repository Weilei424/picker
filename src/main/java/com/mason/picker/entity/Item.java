package com.mason.picker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "name")
    @NotBlank(message = "Item name cannot be blank")
    private String name;

    @ManyToOne
    private User user;
}
