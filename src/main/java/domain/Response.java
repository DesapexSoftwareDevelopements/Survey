package domain;

import jakarta.persistence.*;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.sql.Timestamp;

@Entity
@Table(name = "responses")
public class Response {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Setter
    @Column(name = "question_id", nullable = false)
    private Long questionId;

    @Setter
    @Column(name = "selected_option", nullable = false)
    private String selectedOption;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp // Automatically set the timestamp when the entity is created
    private Timestamp createdAt;

    // Default constructor
    public Response() {
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    // Optional: Override toString for better debugging
    @Override
    public String toString() {
        return "Response{" +
                "id=" + id +
                ", userId=" + userId +
                ", questionId=" + questionId +
                ", selectedOption='" + selectedOption + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
