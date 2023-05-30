package com.reservas.sucursal;

import com.reservas.booking.Booking;
import com.reservas.configrestaurant.ConfigRestaurant;
import com.reservas.sucursalmap.Maps;
import com.reservas.sucursalschedule.Schedule;
import com.reservas.table.TableRest;
import jakarta.persistence.*;
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
@ToString
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

    @NotBlank(message = "Name is required")
    @NotNull(message = "Not null")
    @Column(name = "observation")
    private String observation;

    @NotBlank(message = "Name is required")
    @NotNull(message = "Not null")
    @Column(name="address")
    private String address;

    @NotBlank(message = "Name is required")
    @NotNull(message = "Not null")
    @Column(name="location")
    private String location;

    @NotBlank(message = "Name is required")
    @NotNull(message = "Not null")
    @Column(name = "postalCode")
    private String postalCode;

    @Pattern(regexp = "/^[\\(]?[\\+]?(\\d{2}|\\d{3})[\\)]?[\\s]?((\\d{6}|\\d{8})|(\\d{3}[\\*\\.\\-\\s]){3}|(\\d{2}[\\*\\.\\-\\s]){4}|(\\d{4}[\\*\\.\\-\\s]){2})|\\d{8}|\\d{10}|\\d{12}$/;", message = "Format not reconized")
    @Column(name = "phone")
    private String phone;

    @Column(name = "smoking",columnDefinition = "boolean default false")
    private Boolean smoking;


    @Column(name = "in_side",columnDefinition = "boolean default true")
    private Boolean in_side;

    @NotBlank(message = "Name is required")
    @NotNull(message = "Not null")
    @Column(name = "timeSeat")
    private LocalTime timeSeat;

    @Column(name = "overBooking",columnDefinition = "boolean default false")
    private Boolean overBooking;

    @NotBlank(message = "Name is required")
    @NotNull(message = "Not null")
    @Column(name = "maxWaiting")
    private LocalTime maxWaiting;


    @Column(name = "status",columnDefinition = "boolean default true")
    private Boolean status;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "configRestaurant_id", referencedColumnName = "id")
    private ConfigRestaurant configRestaurant;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "sucursal_id", referencedColumnName = "id")
    private List<TableRest> tables;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "maps_id", referencedColumnName = "id")
    private Maps maps;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "sucursal_id", referencedColumnName = "id")
    private List<Booking> bookings;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "sucursal_id", referencedColumnName = "id")
    private List<Schedule> schedules;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date created;

    @UpdateTimestamp
    @Column(name = "updated_at",updatable = true)
    private Date updated;
}
