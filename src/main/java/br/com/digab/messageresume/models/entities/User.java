package br.com.digab.messageresume.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GenerationType;

import br.com.digab.messageresume.models.forms.LoginForm;
import br.com.digab.messageresume.models.forms.UserForm;
import br.com.digab.messageresume.utils.EncoderUtils;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    @SequenceGenerator(name = "users_sequence", sequenceName = "sequence_users")
    private Long id;

    private String name;
    
    private String password;

    public User(UserForm form) throws Exception {
        this.name = form.name();
        this.password = EncoderUtils.encode(form.password());
    }

    public User(LoginForm form) throws Exception {
        this.name = form.name();
        this.password = EncoderUtils.encode(form.password());
    }
}
