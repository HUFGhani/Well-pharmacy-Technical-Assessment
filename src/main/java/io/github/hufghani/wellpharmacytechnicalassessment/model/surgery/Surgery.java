package io.github.hufghani.wellpharmacytechnicalassessment.model.surgery;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

@Data
public class Surgery {
  @JsonProperty("name")
  private String name;

  @JsonProperty("addressLine1")
  private String addressLine1;

  @JsonProperty("addressLine2")
  private String addressLine2;

  @JsonProperty("city")
  private String city;

  @JsonProperty("postcode")
  @JsonDeserialize(using = PostCodeDeserializer.class)
  private PostCode postcode;

  @JsonProperty("phone")
  private String phone;
}
