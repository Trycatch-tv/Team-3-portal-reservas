package com.reservas.dish;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reservas.auditable.AuditableEntities;
import com.reservas.categorydish.CategoryDish;
import com.reservas.configrestaurant.ConfigRestaurant;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "dish")
public class Dish extends AuditableEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @NotNull(message = "Not null")
    @Column(name="name")
    private String name;

    @NotBlank(message = "Description is required")
    @NotNull(message = "Not null")
    @Column(name = "description")
    private String description;

    @PositiveOrZero
    @Column(name = "price")
    private Double price;

    @NotBlank(message = "Image is required")
    @NotNull(message = "Not null")
    @Column(name = "image")
    private String image;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = CategoryDish.class, optional = false)
    @JoinColumn(name = "categorydish_id", referencedColumnName = "id")
    private CategoryDish categoryDish;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = ConfigRestaurant.class, optional = false)
    @JoinColumn(name = "config_restaurant_id", referencedColumnName = "id")
    private ConfigRestaurant configRestaurant;

}
