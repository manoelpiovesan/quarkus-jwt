package io.github.manoelpiovesan.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;
import java.util.Map;

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

    @Column(name = "cpf", nullable = false)
    public String cpf;

    @Column(name = "phone", nullable = false)
    public String phone;

    @Column(name = "email", nullable = false)
    public String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", nullable = false)
    public String password;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "role", nullable = false)
    public String role;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    public List<Project> projects;

    /**
     * Convert the object to a map
     *
     * @return Map<String, Object>
     */
    public Map<String, Object> toMap() {
        return Map.of(
                "id", id,
                "firstName", firstName,
                "lastName", lastName,
                "username", username,
                "cpf", cpf,
                "phone", phone,
                "email", email,
                "role", role,
                "createdAt", createdAt,
                "updatedAt", updatedAt
        );
    }
}