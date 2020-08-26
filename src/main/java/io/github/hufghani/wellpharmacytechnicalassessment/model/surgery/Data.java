package io.github.hufghani.wellpharmacytechnicalassessment.model.surgery;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.List;

@lombok.Data
public class Data {
  @JsonProperty("date")
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  private LocalDateTime date;

  @JsonProperty("list")
  private List<Surgery> surgeryList;
}
