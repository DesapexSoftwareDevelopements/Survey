package service;

import domain.Response;
import repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {

    private final ResponseRepository responseRepository;

    @Autowired
    public ResponseService(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    public Response saveResponse(Response response) {
        return responseRepository.save(response);
    }

    public List<Response> getResponsesByUser(Long userId) {
        return responseRepository.findByUserId(userId);
    }
}
