package org.acme.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GenerationType;
import org.acme.models.forms.LoginForm;
import org.acme.models.forms.UserForm;

import java.security.MessageDigest;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    @SequenceGenerator(name = "users_sequence", sequenceName = "sequence_users")
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
