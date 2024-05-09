package org.acme.models.entities;

import jakarta.persistence.*;
import org.acme.models.forms.LoginForm;
import org.acme.models.forms.UserForm;

import java.security.MessageDigest;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String password;

    public User() {
    }

    public User(UserForm form) throws Exception {
        this.name = form.name();
        this.password = new String(MessageDigest.getInstance("SHA-512").digest(form.password().getBytes()));
    }

    public User(LoginForm form) throws Exception {
        this.name = form.name();
        this.password = new String(MessageDigest.getInstance("SHA-512").digest(form.password().getBytes()));
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }
}
