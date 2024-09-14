package service;

import domain.Response;
import repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnalyticsService {

    private final ResponseRepository responseRepository;

    @Autowired
    public AnalyticsService(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    public Map<String, Object> generateAnalytics() {
        Map<String, Object> result = new HashMap<>();

        // Fetch all responses
        List<Response> responses = responseRepository.findAll();

        int favorableCount = 0;
        int undesiredCount = 0;
        int lossOfInformationCount = 0;

        // Logic to calculate outcomes
        for (Response response : responses) {
            // Here, you would compare responses based on your business logic
            // For demonstration, we'll use dummy logic

            // Example conditions (you should replace these with your actual comparison logic)
            if (response.getSelectedOption().equals("Favorable")) {
                favorableCount++;
            } else if (response.getSelectedOption().equals("Undesired Outcome")) {
                undesiredCount++;
            } else {
                lossOfInformationCount++;
            }
        }

        // Prepare the result map
        result.put("favorableCount", favorableCount);
        result.put("undesiredCount", undesiredCount);
        result.put("lossOfInformationCount", lossOfInformationCount);

        return result;
    }
}
