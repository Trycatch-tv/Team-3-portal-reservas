package com.reservas.sucursal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.reservas.booking.Booking;
import com.reservas.configrestaurant.ConfigRestaurant;
import com.reservas.sucursalmap.Maps;
import com.reservas.sucursalschedule.Schedule;
import com.reservas.table.TableRest;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString(exclude = "sucursal")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "sucursal")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @NotNull(message = "Not null")
    @Column(name="name")
    private String name;

    @NotBlank(message = "Cooment is required")
    @NotNull(message = "Not null")
    @Column(name = "observation")
    private String observation;

    @NotBlank(message = "Address is required")
    @NotNull(message = "Not null")
    @Column(name="address")
    private String address;

    @NotBlank(message = "Location is required")
    @NotNull(message = "Not null")
    @Column(name="location")
    private String location;

    @Column(name = "postal_code")
    private String postalCode;

    @NotBlank(message = "Phone is required")
    @NotNull(message = "Not null")
    @Pattern(regexp = "^[0-9]{1,12}$", message = "Only numbers")
    @Column(name = "phone")
    private String phone;

    @Column(name = "smoking",columnDefinition = "boolean default false")
    @Pattern(regexp = "^(true|false)$", message = "restartable field allowed input: true or false")
    private Boolean smoking;

    @Column(name = "terraza",columnDefinition = "boolean default true")
    @Pattern(regexp = "^(true|false)$", message = "restartable field allowed input: true or false")
    private Boolean terraza;

    @NotBlank(message = "Time to seat is required")
    @NotNull(message = "Not null")
    @Column(name = "time_seat")
    private LocalTime timeSeat;

    @Column(name = "overBooking",columnDefinition = "boolean default false")
    @Pattern(regexp = "^(true|false)$", message = "restartable field allowed input: true or false")
    private Boolean overBooking;

    @NotBlank(message = "Wich time to wait reserve in minutes")
    @NotNull(message = "Not null")
    @Column(name = "max_waiting")
    private LocalTime maxWaiting;

    @Pattern(regexp = "^(true|false)$", message = "restartable field allowed input: true or false")
    @Column(name = "status",columnDefinition = "boolean default true")
    private Boolean status;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER, targetEntity = ConfigRestaurant.class)
    @JoinColumn(name = "config_restaurant_id", referencedColumnName = "id")
    private ConfigRestaurant configRestaurant;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, targetEntity = TableRest.class)
    @JoinColumn(name = "sucursal_id", referencedColumnName = "id")
    private List<TableRest> tables;


    @OneToOne(mappedBy = "sucursal", fetch = FetchType.EAGER, targetEntity = Maps.class)
    private Maps maps;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Booking.class)
    @JoinColumn(name = "sucursal_id", referencedColumnName = "id")
    private List<Booking> bookings;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Schedule.class)
    @JoinColumn(name = "sucursal_id", referencedColumnName = "id")
    private List<Schedule> schedules;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date created;

    @UpdateTimestamp
    @Column(name = "updated_at",updatable = true)
    private Date updated;
}
