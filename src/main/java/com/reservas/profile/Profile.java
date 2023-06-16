package com.reservas.profile;


import com.fasterxml.jackson.annotation.JsonIgnore;

import com.reservas.client.Clientes;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.Date;
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @NotNull(message = "Not null")
    @Column(name="name")
    private String name;

    @NotBlank(message = "Lastname is required")
    @NotNull(message = "Not null")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Address is required")
    @NotNull(message = "Not null")
    @Column(name="address")
    private String address;

    @NotBlank(message = "Phone is required")
    @NotNull(message = "Not null")
    @Pattern(regexp = "^[0-9]{1,12}$", message = "Only numbers")
    @Column(name = "phone")
    private String phone;

    @Column(name="postal_code")
    private String postalCode;


    @Column(name="avatar")
    private String avatar;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Clientes.class, optional = false)
    @JoinColumn(name = "clientes_id", referencedColumnName = "id")
    private Clientes clientes;


}
