package com.reservas.categorydish;

import com.reservas.auditable.AuditableEntities;
import com.reservas.dish.Dish;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@ToString
@Table(name = "category_dish")
public class CategoryDish extends AuditableEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @NotNull(message = "Not null")
    @Column(name="name", unique = true)
    private String name;

    @NotBlank(message = "Name is required")
    @NotNull(message = "Not null")
    @Column(name = "description")
    private String description;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Dish.class)
    @JoinColumn(name = "categorydish_id", referencedColumnName = "id")
    private List<Dish> dishes;

}
