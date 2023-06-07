package com.reservas.sucursalmap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.reservas.sucursal.Sucursal;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "maps")
public class Maps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @NotNull(message = "Not null")
    @Column(name="name")
    private String name;

    @NotBlank(message = "Description is required")
    @NotNull(message = "Not null")
    @Column(name = "description")
    private String description;

    @OneToOne(mappedBy = "maps", fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value="maps")
    private Sucursal sucursal;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date created;

    @UpdateTimestamp
    @Column(name = "updated_at",updatable = true)
    private Date updated;
}
