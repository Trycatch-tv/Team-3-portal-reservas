package com.reservas.configrestaurant;

import com.reservas.client.Client;
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


    @Column(name = "media_raiting")
    private Double mediaRaiting;

    @Column(name = "count_raiting")
    private Double countRaiting;

    @Pattern(regexp = "/^[\\(]?[\\+]?(\\d{2}|\\d{3})[\\)]?[\\s]?((\\d{6}|\\d{8})|(\\d{3}[\\*\\.\\-\\s]){3}|(\\d{2}[\\*\\.\\-\\s]){4}|(\\d{4}[\\*\\.\\-\\s]){2})|\\d{8}|\\d{10}|\\d{12}$/;", message = "Format not reconized")
    @Column(name = "phone")
    private LocalDate phone;

    @NotBlank(message = "Code ecommerce is required")
    @NotNull(message = "Not null")
    @Column(name = "code_trade")
    private String codeTrade;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    @NotNull(message = "Not null")
    @Column(name = "email")
    private String email;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "configRestaurant_id", referencedColumnName = "id")
    private List<Sucursal> sucursals;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "configRestaurant_id", referencedColumnName = "id")
    private List<Dish> dishes;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "configRestaurant_id", referencedColumnName = "id")
    private List<Follow> follows;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "configRestaurant_id", referencedColumnName = "id")
    private List<Raiting> raiting;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date created;

    @UpdateTimestamp
    @Column(name = "updated_at",updatable = true)
    private Date updated;
}
