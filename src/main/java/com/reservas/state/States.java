package com.reservas.state;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.reservas.booking.Booking;
import jakarta.persistence.*;
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
@Table(name = "states")
public class States {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name requerid")
    @NotNull(message = "Not possible null")
    @Column(name="name", unique = true)
    private String name;

    @NotBlank(message = "Description requerid")
    @NotNull(message = "Not possible null")
    @Column(name = "description")
    private String description;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Booking.class)
    @JoinColumn(name = "states_id", referencedColumnName = "id")
    private List<Booking> bookings;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date created;

    @UpdateTimestamp
    @Column(name = "updated_at",updatable = true)
    private Date updated;
}
