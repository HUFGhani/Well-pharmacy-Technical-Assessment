package io.github.hufghani.wellpharmacytechnicalassessment.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SurgeryResponse {
  @ApiModelProperty(
      position = 1,
      notes = "Outward Postcode",
      name = "Outward Postcode",
      example = "M21")
  @JsonProperty("postcode")
  private String postcode;

  @ApiModelProperty(
      position = 2,
      notes = "The number of surgeries in a Postcode",
      name = "number of surgeries",
      example = "12")
  @JsonProperty("numberOfSurgeries")
  private int numberOfSurgeries;

  @ApiModelProperty(
      position = 3,
      notes = "percentage in an area ",
      name = "Percentage of Surgeries",
      example = "40%")
  @JsonProperty("percentageOfSurgeries")
  private String percentageOfSurgeries;
}
