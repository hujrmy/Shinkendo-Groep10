package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Rights rights;
    private String name;

    @ManyToOne
    private Dojo dojo;
    @Enumerated
    private Rank rank;

    public User(Rights rights, String name, Dojo dojo, Rank rank) {
        this.rights = rights;
        this.name = name;
        this.dojo = dojo;
        this.rank = rank;
    }

    @Override
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
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setID(long ID) {
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
