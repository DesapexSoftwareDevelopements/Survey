package repository;

import domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    // Find all questions by a specific user ID
    List<Question> findByUserId(Long userId);

    // Find a question by its title
    Question findByTitle(String title);

    // Find questions that contain a specific keyword in the title
    List<Question> findByTitleContaining(String keyword);
}
