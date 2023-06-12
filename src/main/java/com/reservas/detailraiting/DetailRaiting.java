package com.reservas.detailraiting;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reservas.client.Clientes;
import com.reservas.raiting.Raiting;
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
@Table(name = "detail_raiting")
public class DetailRaiting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Comment is required")
    @NotNull(message = "Not null")
    @Column(name = "comments")
    private String comments;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,optional = false,targetEntity = Clientes.class)
    @JoinColumn(name = "clientes_id", referencedColumnName = "id")
    private Clientes clientes;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,optional = false, targetEntity = Raiting.class)
    @JoinColumn(name = "raiting_id", referencedColumnName = "id")
    private Raiting raiting;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date created;

    @UpdateTimestamp
    @Column(name = "updated_at",updatable = true)
    private Date updated;

}
