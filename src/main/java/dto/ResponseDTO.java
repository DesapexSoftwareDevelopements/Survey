package dto; // Ensure this matches your package structure

import lombok.Data;

@Data // Lombok annotation to automatically generate getters and setters
public class ResponseDTO {
    private Long userId;
    private Long questionId;
    private String selectedOption;
}
