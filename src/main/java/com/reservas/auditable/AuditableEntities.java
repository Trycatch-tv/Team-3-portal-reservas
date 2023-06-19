package com.reservas.auditable;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;


public class AuditableEntities {

    @Column( name = "client_id_updated",nullable = true)
    private Long clientIdUptated;
    @Column( name = "client_id_created",nullable = true)
    private Long clientIdCreated;

    @Column( name = "client_id_deleted",nullable = true)
    private Long clientIdDeleted;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date created;

    @UpdateTimestamp
    @Column(name = "updated_at",updatable = true)
    private Date updated;

    @UpdateTimestamp
    @Column(name = "deleted_at",updatable = true)
    private Date deleted;
}
