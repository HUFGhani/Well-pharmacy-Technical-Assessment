package io.github.hufghani.wellpharmacytechnicalassessment.model.outwardPostcode;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class Area {
  @JsonProperty("area")
  private String area;

  @JsonProperty("areapostcode")
  private List<AreaPostCode> areapostcode;
}
