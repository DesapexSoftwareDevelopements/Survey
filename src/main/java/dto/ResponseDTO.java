package dto; // Ensure this matches your package structure

import lombok.Data;

@Data
public class ResponseDTO {
    private Long userId;
    private Long questionId;
    private String selectedOption;
}
