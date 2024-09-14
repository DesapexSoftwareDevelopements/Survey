package domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "users")
@Data // Lombok will generate getters, setters, toString, equals, and hashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true) // Consider adding unique constraint on email
    private String email;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp // Automatically set the timestamp when the entity is created
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp // Automatically set the timestamp when the entity is updated
    private Timestamp updatedAt;

    // Default constructor is not required as Lombok will generate it if there are no other constructors
}
