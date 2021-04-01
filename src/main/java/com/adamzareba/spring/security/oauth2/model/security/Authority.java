package com.adamzareba.spring.security.oauth2.model.security;

import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "AUTHORITY", uniqueConstraints = {@UniqueConstraint(columnNames = {"NAME"})})
@Setter
@EqualsAndHashCode(of = "id")
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Override
    public String getAuthority() {
        return getName();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
