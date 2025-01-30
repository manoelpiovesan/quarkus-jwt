package io.github.manoelpiovesan.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.manoelpiovesan.utils.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

/**
 * @author Manoel Rodrigues
 */
@Entity
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted_at = NOW() WHERE id = ?")
@SQLRestriction("deleted_at = '1970-01-01 00:00:00+00'")
public class User extends AbstractFullEntity {
    @Column(name = "first_name", nullable = false)
    public String firstName;

    @Column(name = "last_name", nullable = false)
    public String lastName;

    @Column(name = "username", nullable = false)
    public String username;

    @Column(name = "email", nullable = false)
    public String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", nullable = false)
    public String password;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "role")
    public String role = Role.USER;
}