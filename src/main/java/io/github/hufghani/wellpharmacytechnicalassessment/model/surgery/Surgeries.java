package io.github.hufghani.wellpharmacytechnicalassessment.model.surgery;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class Surgeries {
  @JsonProperty("data")
  private Data data;
}
