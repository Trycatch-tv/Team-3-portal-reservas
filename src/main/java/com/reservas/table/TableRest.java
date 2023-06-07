package com.reservas.table;

import com.reservas.booking.Booking;
import com.reservas.sucursal.Sucursal;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@Table(name = "table_rest")
public class TableRest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is requerid")
    @NotNull(message = "Not possible null")
    @Column(name="name", unique = true)
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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "sucursal_id", referencedColumnName = "id")
    private Sucursal sucursal;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tables_id", referencedColumnName = "id")
    private List<Booking> bookings;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date created;

    @UpdateTimestamp
    @Column(name = "updated_at",updatable = true)
    private Date updated;
}
