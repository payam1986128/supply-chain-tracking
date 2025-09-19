package ir.greenweb.examples.supplychaintracking.persistence.entity;

import ir.greenweb.examples.supplychaintracking.contract.enumeration.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(indexes = {
        @Index(name = "uniqueUsername", columnList = "username", unique = true)
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    private String password;
    private Role role;
}
