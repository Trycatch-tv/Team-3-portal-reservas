package com.reservas.autority;

import com.reservas.role.Roles;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name required to rol")
    @Column(name="name", unique = true)
    private String name;

    @NotBlank(message = "Description important to rol")
    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "authorities")
    private List<Roles> roles;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date created;

    @UpdateTimestamp
    @Column(name = "updated_at",updatable = true)
    private Date updated;

}
