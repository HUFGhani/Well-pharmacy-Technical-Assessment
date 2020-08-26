package io.github.hufghani.wellpharmacytechnicalassessment.model.outwardPostcode;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AreaPostCode {

  @JsonProperty("postcode")
  private String postcode;
}
