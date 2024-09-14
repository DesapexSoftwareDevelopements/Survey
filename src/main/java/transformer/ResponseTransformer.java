package transformer;

import domain.Response;
import dto.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseTransformer {
    private static final Logger logger = LoggerFactory.getLogger(ResponseTransformer.class);

    public static Response fromDTO(ResponseDTO dto) {
        // Validate input
        if (dto == null) {
            logger.error("ResponseDTO cannot be null");
            throw new IllegalArgumentException("ResponseDTO cannot be null");
        }

        // Create Response object
        Response response = new Response();

        // Map fields from DTO to Response
        response.setUserId(dto.getUserId());
        response.setQuestionId(dto.getQuestionId());
        response.setSelectedOption(dto.getSelectedOption());

        // Log the transformation
        logger.info("Transformed ResponseDTO to Response: {}", response);

        return response;
    }
}
