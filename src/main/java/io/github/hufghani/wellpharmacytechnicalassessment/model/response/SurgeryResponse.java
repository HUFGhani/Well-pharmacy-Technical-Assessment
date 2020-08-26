package io.github.hufghani.wellpharmacytechnicalassessment.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SurgeryResponse {
  @JsonProperty("postcode")
  private String postcode;

  @JsonProperty("numberOfSurgeries")
  private int numberOfSurgeries;

  @JsonProperty("percentageOfSurgeries")
  private String percentageOfSurgeries;
}
