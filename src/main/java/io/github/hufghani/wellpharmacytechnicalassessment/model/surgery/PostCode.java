package io.github.hufghani.wellpharmacytechnicalassessment.model.surgery;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PostCode {
  @JsonProperty("postCode")
  private String postCode;

  @JsonProperty("outwardCode")
  private String outwardCode;

  public PostCode(String postCode) {
    this.postCode = postCode;
    String[] postCodeOutwardCode = postCode.split("\\s+");
    this.outwardCode = postCodeOutwardCode[0];
  }
}
