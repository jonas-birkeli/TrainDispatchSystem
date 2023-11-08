

import departurecore.TrainDeparture;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;

/**
 * The {@code TrainDepartureTest} class is a test class for {@code departurecore.TrainDeparture}.
 * It tests all methods in {@code departurecore.TrainDeparture}.
 *
 * @see TrainDeparture
 * @version 1.0.0
 * @since 1.0.0
 */
class TrainDepartureTest {
  TrainDeparture trainDeparture;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    trainDeparture = new TrainDeparture();
  }

  @org.junit.jupiter.api.AfterEach
  void tearDown() {
  }

  @org.junit.jupiter.api.Test
  void setDepartureTime() {
    trainDeparture.setDepartureTime(new int[]{23, 56});
    assertEquals(23, trainDeparture.getDepartureTime().getHour());
    assertEquals(56, trainDeparture.getDepartureTime().getMinute());
  }

  @org.junit.jupiter.api.Test
  void getDepartureTime() {
    assertEquals(0, trainDeparture.getDepartureTime().getHour());
    assertEquals(0, trainDeparture.getDepartureTime().getMinute());
  }

  @org.junit.jupiter.api.Test
  void setDelay() {
    trainDeparture.setDelay(new int[]{23, 56});
    assertEquals(23, trainDeparture.getDelay()[0]);
    assertEquals(56, trainDeparture.getDelay()[1]);
  }

  @org.junit.jupiter.api.Test
  void getDelay() {
    assertEquals(0, trainDeparture.getDelay()[0]);
    assertEquals(0, trainDeparture.getDelay()[1]);
  }

  @org.junit.jupiter.api.Test
  void setLine() {
    trainDeparture.setLine("L1");
    assertEquals("L1", trainDeparture.getLine());
  }

  @org.junit.jupiter.api.Test
  void getLine() {
    assertEquals("", trainDeparture.getLine());
  }

  @org.junit.jupiter.api.Test
  void setDestination() {
    trainDeparture.setDestination("Hamburg");
    assertEquals("Hamburg", trainDeparture.getDestination());
  }

  @org.junit.jupiter.api.Test
  void getDestination() {
    assertEquals("", trainDeparture.getDestination());
  }

  @org.junit.jupiter.api.Test
  void setTrack() {
    trainDeparture.setTrack(3);
    assertEquals(3, trainDeparture.getTrack());
  }

  @org.junit.jupiter.api.Test
  void getTrack() {
    assertEquals(-1, trainDeparture.getTrack());
  }

  @org.junit.jupiter.api.Test
  void getDetails() {
    trainDeparture.setDepartureTime(new int[]{23, 56});
    trainDeparture.setDelay(new int[]{23, 56});
    trainDeparture.setLine("L1");
    trainDeparture.setDestination("Hamburg");
    trainDeparture.setTrack(3);
    assertEquals("23:52 L1 Hamburg           3\n", trainDeparture.getDetails());
  }
}