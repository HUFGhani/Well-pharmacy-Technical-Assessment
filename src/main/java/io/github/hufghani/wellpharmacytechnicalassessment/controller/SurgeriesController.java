package io.github.hufghani.wellpharmacytechnicalassessment.controller;

import io.github.hufghani.wellpharmacytechnicalassessment.model.response.SurgeryResponse;
import io.github.hufghani.wellpharmacytechnicalassessment.service.SurgeriesService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.validation.annotation.Validated;
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
  @ApiOperation(
      value = "get number of surgeries in area/City by outward postcode",
      response = SurgeryResponse.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success|OK", response = SurgeryResponse.class),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!")
      })
  public List<SurgeryResponse> getNumberOfSurgeriesInAreaEndpoint() {
    return surgeriesService.getNumberOfSurgeriesInAnArea();
  }

  @GetMapping("/surgeries/topsurgeries/{topSurgeries}")
  @ApiOperation(
      value = " get most number of surgeries in area/city",
      response = SurgeryResponse.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success|OK", response = SurgeryResponse.class),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!")
      })
  public List<SurgeryResponse> getTopSurgeriesInAreaEndpoint(
      @Validated @PathVariable("topSurgeries") int topSurgeries) {
    return surgeriesService.getTopTopSurgeriesInArea(topSurgeries);
  }
}
