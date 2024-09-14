package Controller; // Ensure this matches your package structure

import service.AnalyticsService; // Correct path to the AnalyticsService class
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @Autowired
    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAnalytics() {
        Map<String, Object> analyticsData = analyticsService.generateAnalytics();
        return new ResponseEntity<>(analyticsData, HttpStatus.OK); // Return 200 OK with analytics data
    }
}
