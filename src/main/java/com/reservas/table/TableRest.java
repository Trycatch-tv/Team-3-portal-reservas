package com.reservas.table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reservas.booking.Booking;
import com.reservas.sucursal.Sucursal;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@Table(name = "table_rest")
public class TableRest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is requerid")
    @NotNull(message = "Not possible null")
    @Column(name="name")
    private String name;

    @Column(name = "description")
    private String description;

    @NotBlank(message = "Date requerid")
    @NotNull(message = "Not possible null")
    @Column(name = "position")
    private String position;

    @Min(value = 2, message = "Minimun 2 space")
    @Max(value = 5,message = "Maxmun o space")
    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "status",columnDefinition = "boolean default true")
    private Boolean status;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Sucursal.class,optional = false)
    @JoinColumn(name = "sucursal_id", referencedColumnName = "id")
    private Sucursal sucursal;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Booking.class)
    @JoinColumn(name = "tables_id", referencedColumnName = "id")
    private List<Booking> bookings;

}
