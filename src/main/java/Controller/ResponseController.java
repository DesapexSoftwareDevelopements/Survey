package Controller; // Ensure this matches your package structure

import domain.Response; // Correct path to the Response class
import service.ResponseService; // Correct path to the ResponseService class
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import java.util.List;

@RestController
@RequestMapping("/responses")
public class ResponseController {

    private final ResponseService responseService;

    @Autowired
    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @PostMapping
    public ResponseEntity<Response> submitResponse(@RequestBody Response response) {
        Response savedResponse = responseService.saveResponse(response);
        return new ResponseEntity<>(savedResponse, HttpStatus.CREATED); // Return 201 Created
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Response>> getUserResponses(@PathVariable Long userId) {
        List<Response> responses = responseService.getResponsesByUser(userId);
        if (responses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 if no responses found
        }
        return new ResponseEntity<>(responses, HttpStatus.OK); // Return 200 OK with responses
    }
}
