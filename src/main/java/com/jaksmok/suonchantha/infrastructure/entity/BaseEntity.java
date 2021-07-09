package com.jaksmok.suonchantha.infrastructure.entity;


import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity<ID extends Serializable>  implements Serializable, Persistable<ID> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;


    @Override
    public ID getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return id == null;
    }

    @Column(name = "isDeleted", columnDefinition = "boolean default false")
    boolean isDeleted = false;


    @Transient
    public void softDelete(){
        this.isDeleted = true;
    }


    @Transient
    public void beforeSave(){

    }

    public void setId(ID id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
