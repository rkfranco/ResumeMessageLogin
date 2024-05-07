package org.acme.models.entities;

import jakarta.persistence.*;
import org.acme.models.forms.UserForm;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String password;

    public User() {
    }

    public User(UserForm form) {
        this.name = form.name();
        this.password = form.password();
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
