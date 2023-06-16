package com.reservas.client;


import com.reservas.auditable.AuditableEntities;
import com.reservas.booking.Booking;
import com.reservas.configrestaurant.ConfigRestaurant;
import com.reservas.detailraiting.DetailRaiting;
import com.reservas.follow.Follow;
import com.reservas.profile.Profile;
import com.reservas.raiting.Raiting;
import com.reservas.role.Roless;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "clientes")
public class Clientes extends AuditableEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email(message = "Invalid email")
    @NotBlank(message = "Name is required")
    @NotNull(message = "Not null")
    @Column(name="email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;



    @OneToOne(mappedBy = "clientes",targetEntity = Profile.class)
    private Profile profile;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Raiting.class)
    @JoinColumn(name = "clientes_id", referencedColumnName = "id")
    private List<Raiting> raiting;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Follow.class)
    @JoinColumn(name = "clientes_id", referencedColumnName = "id")
    private List<Follow> follows;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = DetailRaiting.class )
    @JoinColumn(name = "clientes_id", referencedColumnName = "id")
    private List<DetailRaiting> detailRaitings;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Booking.class)
    @JoinColumn(name = "clientes_id", referencedColumnName = "id")
    private List<Booking> bookings;



    @ManyToMany(mappedBy = "clientes",fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Roless> roless;



    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ConfigRestaurant.class)
    @JoinColumn(name = "clientes_id", referencedColumnName = "id")
    private List<ConfigRestaurant> configRestaurants;

}
