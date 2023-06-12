package com.reservas.client;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email(message = "Invalid email")
    @NotBlank(message = "Name is required")
    @NotNull(message = "Not null")
    @Column(name="email")
    private String email;

    @Column(name = "password")
    private String password;


    @JsonManagedReference
    @OneToOne(mappedBy = "clientes",targetEntity = Profile.class)
    private Profile profile;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Raiting.class)
    @JoinColumn(name = "clientes_id", referencedColumnName = "id")
    private List<Raiting> raiting;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Follow.class)
    @JoinColumn(name = "clientes_id", referencedColumnName = "id")
    private List<Follow> follows;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = DetailRaiting.class )
    @JoinColumn(name = "clientes_id", referencedColumnName = "id")
    private List<DetailRaiting> detailRaitings;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Booking.class)
    @JoinColumn(name = "clientes_id", referencedColumnName = "id")
    private List<Booking> bookings;


    @JsonManagedReference
    @ManyToMany(mappedBy = "clientes",fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Roless> roless;


    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ConfigRestaurant.class)
    @JoinColumn(name = "clientes_id", referencedColumnName = "id")
    private List<ConfigRestaurant> configRestaurants;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date created;

    @UpdateTimestamp
    @Column(name = "updated_at",updatable = true)
    private Date updated;
}
