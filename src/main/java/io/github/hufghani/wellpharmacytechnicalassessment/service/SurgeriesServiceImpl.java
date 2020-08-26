package io.github.hufghani.wellpharmacytechnicalassessment.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.hufghani.wellpharmacytechnicalassessment.model.outwardPostcode.Area;
import io.github.hufghani.wellpharmacytechnicalassessment.model.outwardPostcode.AreaPostCode;
import io.github.hufghani.wellpharmacytechnicalassessment.model.response.SurgeryResponse;
import io.github.hufghani.wellpharmacytechnicalassessment.model.surgery.Surgeries;
import io.github.hufghani.wellpharmacytechnicalassessment.model.surgery.Surgery;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class SurgeriesServiceImpl implements SurgeriesService {

  private String areaList;
  private List<Surgery> surgeryList;
  private static final DecimalFormat df = new DecimalFormat("0.00");

  public SurgeriesServiceImpl() {
    loadJsonData();
  }

  private void loadJsonData() {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.registerModule(new JavaTimeModule());

      InputStream surgeriesDataResourceAsStream =
          SurgeriesServiceImpl.class.getClassLoader().getResourceAsStream("data.json");
      Surgeries surgeries = objectMapper.readValue(surgeriesDataResourceAsStream, Surgeries.class);
      this.surgeryList = surgeries.getData().getSurgeryList();

      InputStream areaDataResourceAsStream =
          Area.class.getClassLoader().getResourceAsStream("areaPostCode.json");
      Area area = objectMapper.readValue(areaDataResourceAsStream, Area.class);
      List<AreaPostCode> areaPostCodes = area.getAreapostcode();
      this.areaList = convertToString(areaPostCodes);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public List<Surgery> getSurgeryList() {
    return this.surgeryList;
  }

  @Override
  public List<SurgeryResponse> getNumberOfSurgeriesInAnArea() {
    Map<String, List<Surgery>> sortedSurgeriesWithAreaPostCode =
        sortSurgeryList(getSurgeryList(), this.areaList);
    int totalSurgeriesInArea = getTotalSurgeriesInArea(sortedSurgeriesWithAreaPostCode);

    return buildHistogramResponses(sortedSurgeriesWithAreaPostCode, totalSurgeriesInArea);
  }

  private List<SurgeryResponse> buildHistogramResponses(
      Map<String, List<Surgery>> sortedSurgeriesWithAreaPostCode, int totalSurgeriesInArea) {
    List<SurgeryResponse> result = new ArrayList<>();
    for (Entry<String, List<Surgery>> data : sortedSurgeriesWithAreaPostCode.entrySet()) {
      String postcode = data.getKey();
      int numberOfSurgeries = data.getValue().size();
      float percentage = ((float) numberOfSurgeries * 100) / totalSurgeriesInArea;
      result.add(new SurgeryResponse(postcode, numberOfSurgeries, df.format(percentage) + "%"));
    }
    return result;
  }

  private int getTotalSurgeriesInArea(Map<String, List<Surgery>> sortedSurgeriesWithAreaPostCode) {
    return sortedSurgeriesWithAreaPostCode.values().stream().mapToInt(List::size).sum();
  }

  private Map<String, List<Surgery>> sortSurgeryList(List<Surgery> surgeryList, String areaList) {
    return surgeryList.stream()
        .sorted(Comparator.comparing(surgery -> surgery.getPostcode().getOutwardCode()))
        .filter(surgery -> areaList.contains(surgery.getPostcode().getOutwardCode()))
        .collect(Collectors.groupingBy(surgery -> surgery.getPostcode().getOutwardCode()));
  }

  private String convertToString(List<AreaPostCode> areaPostCodes) {
    return StringUtils.join(areaPostCodes, ",");
  }
}
