package com.reservas.sucursalschedule;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reservas.sucursal.Sucursal;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalTime;
import java.util.Date;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Day is required")
    @NotNull(message = "Not null")
    @Column(name="day")
    private String day;

    @NotBlank(message = "Open is required")
    @NotNull(message = "Not null")
    @Column(name = "startService")
    private LocalTime startService;

    @NotBlank(message = "End is required")
    @NotNull(message = "Not null")
    @Column(name="endService")
    private LocalTime endService;

    @Column(name = "status",columnDefinition = "boolean default false")
    private Boolean status;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Sucursal.class, optional = false)
    @JoinColumn(name = "sucursal_id", referencedColumnName = "id")
    private Sucursal sucursal;

}
