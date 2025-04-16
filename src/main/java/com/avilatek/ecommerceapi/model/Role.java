package com.avilatek.ecommerceapi.model;

import com.avilatek.ecommerceapi.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Role {
    @Id
    @UuidGenerator
    private UUID id;
    private String name;

    public Role() {}

    public Role(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users = new HashSet<>();
}