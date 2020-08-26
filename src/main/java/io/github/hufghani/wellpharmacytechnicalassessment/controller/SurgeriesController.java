package io.github.hufghani.wellpharmacytechnicalassessment.controller;

import io.github.hufghani.wellpharmacytechnicalassessment.model.response.SurgeryResponse;
import io.github.hufghani.wellpharmacytechnicalassessment.service.SurgeriesService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurgeriesController {

  private final SurgeriesService surgeriesService;

  public SurgeriesController(SurgeriesService surgeriesService) {
    this.surgeriesService = surgeriesService;
  }

  @GetMapping("/surgeries")
  public List<SurgeryResponse> getNumberOfSurgeriesInAreaEndpoint() {
    return surgeriesService.getNumberOfSurgeriesInAnArea();
  }

  @GetMapping("/surgeries/topsurgeries/{topSurgeries}")
  public List<SurgeryResponse> getTopSurgeriesInAreaEndpoint(
      @PathVariable("topSurgeries") int topSurgeries) {
    return surgeriesService.getTopTopSurgeriesInArea(topSurgeries);
  }
}
