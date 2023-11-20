package com.mose.springSecurity.user;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String password;
   @Enumerated(EnumType.STRING)
   private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
    /*public Set<GrantedAuthority> getAuthorities() {
        return new HashSet<>(Arrays.asList(new SimpleGrantedAuthority(role.name())));
    }

    public Iterator<GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(role.name())).iterator();
    }

    public Tuple<GrantedAuthority> getAuthorities() {
        return new Tuple<>(new SimpleGrantedAuthority(role.name()));
    }

    public Optional<GrantedAuthority> getAuthorities() {
        return Optional.of(new SimpleGrantedAuthority(role.name()));
    }

    public Dict<String, GrantedAuthority> getAuthorities() { //to store the collection in a map
        return new HashMap<>() {{
            put("role", new SimpleGrantedAuthority(role.name()));
        }};
    }

    public Callable<GrantedAuthority> getAuthorities() {
        return () -> new SimpleGrantedAuthority(role.name());
    }

    public Any getAuthorities() {
        return new SimpleGrantedAuthority(role.name());
    }*/

    @Override
    public String getUsername() {
        return email;
    }
    @Override
    public String getPassword() {
        return password;
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
}
