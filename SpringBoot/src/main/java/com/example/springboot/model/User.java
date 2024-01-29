package com.example.springboot.model;

import com.example.springboot.model.Enums.Rank;
import com.example.springboot.model.Enums.Rights;
import com.example.springboot.validation.Password;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.validation.constraints.*;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID ID;

    @Pattern(regexp = "^[A-Za-z.-_]+$", message = "Names can contain [A-Z], [a-z], [.], [_] and [-]")
    @NotBlank(message = "Username has to contain a value")
    private String username;

    @Password
    @NotBlank(message = "Password has to contain a value")
    private String password;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Rights has to contain a value")
    private Rights rights;

    @Pattern(regexp = "^[A-Za-z.-]+$", message = "Names can contain [A-Z], [a-z], [.] and [-]")
    @NotBlank(message = "Name has to contain a value")
    private String name;

    @ManyToOne
    @NotBlank(message = "Dojo has to contain a value")
    private Dojo dojo;

    @Enumerated
    @NotBlank(message = "Rank has to contain a value")
    private Rank rank;

    public User(Rights rights, String name, Dojo dojo, Rank rank) {
        this.rights = rights;
        this.name = name;
        this.dojo = dojo;
        this.rank = rank;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rights.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setID(UUID ID) {
        this.ID = ID;
    }

    public void setRights(Rights rights) {
        this.rights = rights;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDojo(Dojo dojo) {
        this.dojo = dojo;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public UUID getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Username{" +
                "ID=" + ID +
                ", rights=" + rights +
                ", name='" + name + '\'' +
                ", dojo=" + dojo +
                ", rank=" + rank +
                ", username=" + username +
                ", password=" + password +
                '}';
    }
}
