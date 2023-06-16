package com.reservas.role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reservas.client.Clientes;
import jakarta.persistence.*;
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
@Table(name = "roless")
public class Roless {
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

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,targetEntity = Clientes.class)
    @JoinTable(name = "roless_clientes", joinColumns = @JoinColumn(name = "roless_id", referencedColumnName = "id")
            ,inverseJoinColumns = @JoinColumn(name = "cliente_id", referencedColumnName = "id"))
    private List<Clientes> clientes;

}
