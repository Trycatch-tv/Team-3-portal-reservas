package com.reservas.booking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.reservas.auditable.AuditableEntities;
import com.reservas.client.Clientes;
import com.reservas.state.States;
import com.reservas.sucursal.Sucursal;
import com.reservas.table.TableRest;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "booking")
public class Booking extends AuditableEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Date requerid")
    @NotNull(message = "Time not possible null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name="date_book")
    private LocalDate dateBook;

    @Positive(message = "Only positive numbers")
    @Min(value = 1,message = "Mínumun 1 people")
    @NotNull(message = "Not null numbers people")
    @Column(name="people")
    private Integer people;

    @NotNull(message = "Not null")
    @NotBlank(message = "Data time is necesary")
    @Column(name = "time_book")
    private LocalTime timeBook;

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = TableRest.class, optional = false)
    @JoinColumn(name = "tables_id", referencedColumnName = "id")
    private TableRest tableRest;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = States.class, optional = false)
    @JoinColumn(name = "states_id", referencedColumnName = "id")
    private States states;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Clientes.class, optional = false)
    @JoinColumn(name = "clientes_id", referencedColumnName = "id")
    private Clientes clientes;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Sucursal.class, optional = false)
    @JoinColumn(name = "sucursal_id", referencedColumnName = "id")
    private Sucursal sucursal;

}
