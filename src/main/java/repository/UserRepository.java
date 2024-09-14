package repository;

import domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // This annotation is optional but can improve clarity
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query methods can be added here

    User findByEmail(String email); // Example method to find a user by email

    List<User> findByFirstName(String firstName); // Example method to find users by first name

    List<User> findByLastName(String lastName); // Example method to find users by last name

    // Add more query methods as needed
}
