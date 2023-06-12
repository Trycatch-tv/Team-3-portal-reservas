package com.reservas.raiting;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.reservas.client.Clientes;
import com.reservas.configrestaurant.ConfigRestaurant;
import com.reservas.detailraiting.DetailRaiting;
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
@Table(name = "raiting")
public class Raiting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 0,message = "Minimun 0")
    @Max(value = 10,message = "Maximun 10")
    @Column(name="score")
    private Integer score;

    @NotBlank(message = "Commnet requerid")
    @NotNull(message = "Not possible null")
    @Column(name = "comments")
    private String comments;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = DetailRaiting.class)
    @JoinColumn(name = "raiting_id", referencedColumnName = "id")
    private List<DetailRaiting> detailRaitings;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ConfigRestaurant.class,optional = false)
    @JoinColumn(name = "config_restaurant_id", referencedColumnName = "id")
    private ConfigRestaurant configRestaurant;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Clientes.class)
    @JoinColumn(name = "clientes_id", referencedColumnName = "id")
    private Clientes clientes;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date created;

    @UpdateTimestamp
    @Column(name = "updated_at",updatable = true)
    private Date updated;
}
