package com.carShop.customer;

import com.carShop.car.model.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customers")
public class Customer implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    private String username = generateUserName();
    @Column(name = "address")
    private String address;
    @Column(name = "password", nullable = false)
    @JsonIgnore
    private String password;
    @Column(name = "phone_number", unique = true)
    private int phoneNumber;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany
    List<Order> orders;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return generateUserName();
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

    private String generateUserName() {
        return firstname + lastname + randomNumber();
    }

    private int randomNumber() {
        Random random = new Random();
        return random.nextInt(1000 * 100 * 10 );
    }
}
