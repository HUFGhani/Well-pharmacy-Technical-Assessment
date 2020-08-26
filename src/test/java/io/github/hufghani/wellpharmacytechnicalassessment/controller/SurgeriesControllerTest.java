package io.github.hufghani.wellpharmacytechnicalassessment.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.github.hufghani.wellpharmacytechnicalassessment.model.response.SurgeryResponse;
import io.github.hufghani.wellpharmacytechnicalassessment.service.SurgeriesService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest
class SurgeriesControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockBean SurgeriesService surgeriesService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testGetNumberOfSurgeriesInAreaEndpoint() throws Exception {
    List<SurgeryResponse> surgeryResponses = new ArrayList<>();
    surgeryResponses.add(new SurgeryResponse("M6", 16, "5.08%"));
    surgeryResponses.add(new SurgeryResponse("M22", 16, "5.08%"));
    surgeryResponses.add(new SurgeryResponse("M40", 14, "4.44%"));
    surgeryResponses.add(new SurgeryResponse("M8", 14, "4.44%"));
    surgeryResponses.add(new SurgeryResponse("M30", 14, "4.44%"));

    String expected =
        "[{\"postcode\":\"M6\",\"numberOfSurgeries\":16,\"percentageOfSurgeries\":\"5.08%\"},"
            + "{\"postcode\":\"M22\",\"numberOfSurgeries\":16,\"percentageOfSurgeries\":\"5.08%\"},"
            + "{\"postcode\":\"M40\",\"numberOfSurgeries\":14,\"percentageOfSurgeries\":\"4.44%\"},"
            + "{\"postcode\":\"M8\",\"numberOfSurgeries\":14,\"percentageOfSurgeries\":\"4.44%\"},"
            + "{\"postcode\":\"M30\",\"numberOfSurgeries\":14,\"percentageOfSurgeries\":\"4.44%\"}]";

    when(surgeriesService.getNumberOfSurgeriesInAnArea()).thenReturn(surgeryResponses);
    this.mockMvc
        .perform(MockMvcRequestBuilders.get("/surgeries"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(expected)));
  }
}
