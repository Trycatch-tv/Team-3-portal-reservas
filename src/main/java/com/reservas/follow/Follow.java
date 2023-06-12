package com.reservas.follow;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reservas.client.Clientes;
import com.reservas.configrestaurant.ConfigRestaurant;
import jakarta.persistence.*;
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
@Table(name = "follow")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Clientes.class,optional = false)
    @JoinColumn(name = "clientes_id", referencedColumnName = "id")
    private Clientes clientes;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ConfigRestaurant.class,optional = false)
    @JoinColumn(name = "config_restaurant_id", referencedColumnName = "id")
    private ConfigRestaurant configRestaurant;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date created;

    @UpdateTimestamp
    @Column(name = "updated_at",updatable = true)
    private Date updated;
}
