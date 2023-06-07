package com.reservas.profile;

import com.reservas.client.Client;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @NotNull(message = "Not null")
    @Column(name="names")
    private String names;

    @NotBlank(message = "Lastname is required")
    @NotNull(message = "Not null")
    @Column(name = "lastName")
    private String lastName;

    @NotBlank(message = "Address is required")
    @NotNull(message = "Not null")
    @Column(name="address")
    private String address;

    @NotBlank(message = "Phone is required")
    @NotNull(message = "Not null")
    @Pattern(regexp = "/^[\\(]?[\\+]?(\\d{2}|\\d{3})[\\)]?[\\s]?((\\d{6}|\\d{8})|(\\d{3}[\\*\\.\\-\\s]){3}|(\\d{2}[\\*\\.\\-\\s]){4}|(\\d{4}[\\*\\.\\-\\s]){2})|\\d{8}|\\d{10}|\\d{12}$/;", message = "Format not reconized")
    @Column(name = "phone")
    private String phone;

    @Column(name="postalCode")
    private String postalCode;


    @Column(name="avatar")
    private String avatar;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date created;

    @UpdateTimestamp
    @Column(name = "updated_at",updatable = true)
    private Date updated;
}
