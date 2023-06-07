package com.reservas.dish;

import com.reservas.categorydish.CategoryDish;
import com.reservas.configrestaurant.ConfigRestaurant;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "dish")
public class Dish {
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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "categorydish_id", referencedColumnName = "id")
    private CategoryDish categoryDish;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "configRestaurant_id", referencedColumnName = "id")
    private ConfigRestaurant configRestaurant;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date created;

    @UpdateTimestamp
    @Column(name = "updated_at",updatable = true)
    private Date updated;
}
