package com.mason.picker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "item", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id"})
})
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "name")
    @NotBlank(message = "Item name cannot be blank")
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
