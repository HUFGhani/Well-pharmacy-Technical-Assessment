package io.github.hufghani.wellpharmacytechnicalassessment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.hufghani.wellpharmacytechnicalassessment.model.response.SurgeryResponse;
import io.github.hufghani.wellpharmacytechnicalassessment.model.surgery.PostCode;
import io.github.hufghani.wellpharmacytechnicalassessment.model.surgery.Surgery;
import io.github.hufghani.wellpharmacytechnicalassessment.service.SurgeriesServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SurgeriesServiceImplTest {
  private SurgeriesServiceImpl surgeriesService;
  private List<Surgery> surgeryList;

  @BeforeEach
  void setUp() {
    surgeryList = new ArrayList<>();

    Surgery surgery1 = new Surgery();
    Surgery surgery2 = new Surgery();
    Surgery surgery3 = new Surgery();
    Surgery surgery4 = new Surgery();
    Surgery surgery5 = new Surgery();
    Surgery surgery6 = new Surgery();
    Surgery surgery7 = new Surgery();
    Surgery surgery8 = new Surgery();
    Surgery surgery9 = new Surgery();

    surgery1.setName("bob");
    surgery1.setAddressLine1("bob test");
    surgery1.setAddressLine2("Hello World");
    surgery1.setCity("Manchester");
    surgery1.setPostcode(new PostCode("M21 7SL"));
    surgery1.setPhone("111111");

    surgery2.setName("bob");
    surgery2.setAddressLine1("bob test");
    surgery2.setAddressLine2("Hello World");
    surgery2.setCity("Manchester");
    surgery2.setPostcode(new PostCode("M21 7SL"));
    surgery2.setPhone("111111");

    surgery3.setName("bob");
    surgery3.setAddressLine1("bob test");
    surgery3.setAddressLine2("Hello World");
    surgery3.setCity("Manchester");
    surgery3.setPostcode(new PostCode("M22 7SL"));
    surgery3.setPhone("111111");

    surgery4.setName("bob");
    surgery4.setAddressLine1("bob test");
    surgery4.setAddressLine2("Hello World");
    surgery4.setCity("Manchester");
    surgery4.setPostcode(new PostCode("M2 7SL"));
    surgery4.setPhone("111111");

    surgery5.setName("bob");
    surgery5.setAddressLine1("bob test");
    surgery5.setAddressLine2("Hello World");
    surgery5.setCity("Manchester");
    surgery5.setPostcode(new PostCode("M8 7SL"));
    surgery5.setPhone("111111");

    surgery6.setName("bob");
    surgery6.setAddressLine1("bob test");
    surgery6.setAddressLine2("Hello World");
    surgery6.setCity("Manchester");
    surgery6.setPostcode(new PostCode("M21 7SL"));
    surgery6.setPhone("111111");

    surgery7.setName("bob");
    surgery7.setAddressLine1("bob test");
    surgery7.setAddressLine2("Hello World");
    surgery7.setCity("Manchester");
    surgery7.setPostcode(new PostCode("M12 7SL"));
    surgery7.setPhone("111111");

    surgery8.setName("bob");
    surgery8.setAddressLine1("bob test");
    surgery8.setAddressLine2("Hello World");
    surgery8.setCity("Manchester");
    surgery8.setPostcode(new PostCode("M4 7SL"));
    surgery8.setPhone("111111");

    surgery9.setName("bob");
    surgery9.setAddressLine1("bob test");
    surgery9.setAddressLine2("Hello World");
    surgery9.setCity("Oldham");
    surgery9.setPostcode(new PostCode("OL16 7SL"));
    surgery9.setPhone("111111");

    surgeryList.add(surgery1);
    surgeryList.add(surgery2);
    surgeryList.add(surgery3);
    surgeryList.add(surgery4);
    surgeryList.add(surgery5);
    surgeryList.add(surgery6);
    surgeryList.add(surgery7);
    surgeryList.add(surgery8);
    surgeryList.add(surgery9);

    surgeriesService =
        new SurgeriesServiceImpl() {
          @Override
          public List<Surgery> getSurgeryList() {
            return surgeryList;
          }
        };
  }

  @Test
  void testGetSurgeryList() {
    List<Surgery> surgeries = surgeriesService.getSurgeryList();
    assertNotNull(surgeries);
    assertTrue(surgeries.size() == 9);
  }

  @Test
  void testGetNumberOfSurgeriesInAnArea() {
    List<SurgeryResponse> expected = new ArrayList<>();
    expected.add(new SurgeryResponse("M2", 1, "12.50%"));
    expected.add(new SurgeryResponse("M4", 1, "12.50%"));
    expected.add(new SurgeryResponse("M8", 1, "12.50%"));
    expected.add(new SurgeryResponse("M22", 1, "12.50%"));
    expected.add(new SurgeryResponse("M21", 3, "37.50%"));
    expected.add(new SurgeryResponse("M12", 1, "12.50%"));

    List<SurgeryResponse> result = surgeriesService.getNumberOfSurgeriesInAnArea();
    assertEquals(expected, result);
  }

  @Test
  void testNonMCRPostcoode() {
    List<Surgery> surgeryListTemp = new ArrayList<>();
    Surgery surgery1 = new Surgery();
    Surgery surgery2 = new Surgery();
    Surgery surgery3 = new Surgery();

    surgery1.setName("bob");
    surgery1.setAddressLine1("bob test");
    surgery1.setAddressLine2("Hello World");
    surgery1.setCity("Oldham");
    surgery1.setPostcode(new PostCode("OL16 7SL"));
    surgery1.setPhone("111111");

    surgery2.setName("bob");
    surgery2.setAddressLine1("bob test");
    surgery2.setAddressLine2("Hello World");
    surgery2.setCity("Oldham");
    surgery2.setPostcode(new PostCode("OL16 7SL"));
    surgery2.setPhone("111111");

    surgery3.setName("bob");
    surgery3.setAddressLine1("bob test");
    surgery3.setAddressLine2("Hello World");
    surgery3.setCity("Oldham");
    surgery3.setPostcode(new PostCode("OL16 7SL"));
    surgery3.setPhone("111111");

    surgeryListTemp.add(surgery1);
    surgeryListTemp.add(surgery2);
    surgeryListTemp.add(surgery3);

    surgeriesService =
        new SurgeriesServiceImpl() {
          @Override
          public List<Surgery> getSurgeryList() {
            return surgeryListTemp;
          }
        };

    List<SurgeryResponse> result = surgeriesService.getNumberOfSurgeriesInAnArea();
    assertTrue(result.size() == 0);
  }
}
