package io.github.hufghani.wellpharmacytechnicalassessment.controller;

import io.github.hufghani.wellpharmacytechnicalassessment.model.response.SurgeryResponse;
import io.github.hufghani.wellpharmacytechnicalassessment.service.SurgeriesService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
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
}
