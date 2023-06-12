package com.reservas.configrestaurant;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.reservas.client.Clientes;
import com.reservas.dish.Dish;
import com.reservas.follow.Follow;
import com.reservas.raiting.Raiting;
import com.reservas.sucursal.Sucursal;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "config_restaurant")
public class ConfigRestaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @NotNull(message = "Not null")
    @Column(name="name")
    private String name;

    @NotBlank(message = "Name is required")
    @NotNull(message = "Not null")
    @Column(name = "slogan")
    private String slogan;

    @Column(name = "logo")
    private String logo;

    @Column(name = "banner")
    private String banner;

    @NotBlank(message = "Name is required")
    @NotNull(message = "Not null")
    @Column(name = "description")
    private String description;

    @NotBlank(message = "Address is required")
    @NotNull(message = "Not null")
    @Column(name="address")
    private String address;


    @Column(name = "postal_code")
    private String postalCode;


    @Min(value = 0,  message = "0% discount minimun")
    @Max(value = 100,message = "100% discount maximun")
    @Column(name = "discount")
    private Double discount;


    @Column(name = "media_raiting",columnDefinition = "Decimal(10,2) default '0.00'" )
    private Double mediaRaiting;

    @Column(name = "count_raiting",columnDefinition = "Decimal(10,2) default '0.00'" )
    private Double countRaiting;

    @Pattern(regexp = "^[0-9]{1,12}$", message = "Only numbers")
    @Column(name = "phone")
    private String phone;

    @NotBlank(message = "Code ecommerce is required")
    @NotNull(message = "Not null")
    @Column(name = "code_trade")
    private String codeTrade;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    @NotNull(message = "Not null")
    @Column(name = "email")
    private String email;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Clientes.class)
    @JoinColumn(name = "clientes_id", referencedColumnName = "id")
    private Clientes clientes;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Sucursal.class)
    @JoinColumn(name = "config_restaurant_id", referencedColumnName = "id")
    private List<Sucursal> sucursals;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Dish.class )
    @JoinColumn(name = "config_restaurant_id", referencedColumnName = "id")
    private List<Dish> dishes;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Follow.class)
    @JoinColumn(name = "config_restaurant_id", referencedColumnName = "id")
    private List<Follow> follows;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Raiting.class)
    @JoinColumn(name = "config_estaurant_id", referencedColumnName = "id")
    private List<Raiting> raiting;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date created;

    @UpdateTimestamp
    @Column(name = "updated_at",updatable = true)
    private Date updated;
}
