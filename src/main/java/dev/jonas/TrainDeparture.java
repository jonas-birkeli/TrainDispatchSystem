package dev.jonas;

/**
 * The {@code TrainDeparture} class represents a train on a station.
 * All {@code TrainDeparture}s has a departuretime, delay, line, destination and track.
 *
 * @author Jonas Birkeli
 * @version 1.2.0
 * @since 1.0.0
 */
public class TrainDeparture implements Comparable<TrainDeparture> {

  private int[] departureTime;
  private int[] delay;
  private String line;
  private String destination;
  private int track;

  /**
   * Constructs a new {@code TrainDeparture} with default values.
   *
   * @since 1.0.0
   */
  public TrainDeparture() {
    setDepartureTime(new int[]{0, 0});
    setLine("");
    setDestination("");
    setTrack(-1);
    setDelay(new int[]{0, 0});
  }

  /**
   * Constructs a new {@code TrainDeparture} with the given parameters.
   *
   * @param departureTime  Scheduled time for departure of train.
   * @param line Scheduled line of train
   * @param destination End-destination of train.
   * @param track Number of the departure-track.
   *
   * @see #setDepartureTime(int[])
   * @see #setLine(String)
   * @see #setDestination(String)
   * @see #setTrack(int)
   * @since 1.0.0
   */
  public TrainDeparture(
      int[] departureTime,
      String line,
      String destination,
      int track) {
    setDepartureTime(departureTime);
    setLine(line);
    setDestination(destination);
    setTrack(track);
    setDelay(new int[]{0, 0});
  }

  /**
   * Sets the departure time of the {@code TrainDeparture}.
   * Each {@code TrainDeparture} has two departure times,
   * one representing hours, and one representing minutes.
   * If null, not two elements or either is negative, departure time is set to 0.
   *
   * @param departureTime the departure time of the {@code TrainDeparture}.
   * @since 1.0.0
   */
  public void setDepartureTime(int[] departureTime) {
    if (departureTime == null
        || departureTime.length != 2
        || departureTime[0] < 0
        || departureTime[1] < 0
    ) {
      this.departureTime = new int[]{0, 0};
      return;
    }
    this.departureTime = departureTime;
  }

  /**
   * Returns the departure time of the {@code TrainDeparture}.
   *
   * @return the departure time of the {@code TrainDeparture}.
   * @since 1.0.0
   */
  public int[] getDepartureTime() {
    return departureTime;
  }

  /**
   * Sets the delay of the {@code TrainDeparture}.
   * Each {@code TrainDeparture} has two delays,
   * one representing hours, and one representing minutes.
   * If null, not two elements or either is negative, delay is set to 0.
   *
   * @param delay the delay of the {@code TrainDeparture}.
   * @since 1.0.0
   */
  public void setDelay(int[] delay) {
    if (delay == null
        || delay.length != 2
        || delay[0] < 0
        || delay[1] < 0
    ) {
      this.delay = new int[]{0, 0};
      return;
    }
    this.delay = delay;
  }

  /**
   * Returns the delay of the {@code TrainDeparture} as an integer list in the format {HH, MM}.
   *
   * @return the delay of the {@code TrainDeparture}.
   * @since 1.0.0
   */
  public int[] getDelay() {
    return delay;
  }

  /**
   * Sets the line of the {@code TrainDeparture}.
   * If null, line is set to empty.
   *
   * @param line the line of the {@code TrainDeparture}.
   * @since 1.0.0
   */
  public void setLine(String line) {
    if (line == null) {
      this.line = "";
      return;
    }
    this.line = line;
  }

  /**
   * Returns the line of the {@code TrainDeparture}.
   *
   * @return the line of the {@code TrainDeparture}.
   * @since 1.0.0
   */
  public String getLine() {
    return line;
  }

  /**
   * Sets the destination of the {@code TrainDeparture}.
   * If null, destination is set to empty.
   *
   * @param destination the destination of the {@code TrainDeparture}.
   * @since 1.0.0
   */
  public void setDestination(String destination) {
    if (destination == null) {
      this.destination = "";
      return;
    }
    this.destination = destination;
  }

  /**
   * Returns the destination of the {@code TrainDeparture}.
   *
   * @return the destination of the {@code TrainDeparture}.
   * @since 1.0.0
   */
  public String getDestination() {
    return destination;
  }

  /**
   * Sets the track of the {@code TrainDeparture}.
   * If negative or zero, track is set to -1.
   *
   * @param track the track of the {@code TrainDeparture}.
   * @since 1.0.0
   */
  public void setTrack(int track) {
    if (track <= 0) {
      this.track = -1;
      return;
    }
    this.track = track;
  }

  /**
   * Returns the track of the {@code TrainDeparture}.
   *
   * @return the track of the {@code TrainDeparture}.
   * @since 1.0.0
   */
  public int getTrack() {
    return track;
  }


  /**
   * Returns a string representation of the {@code TrainDeparture}.
   * Similar to what you see at an actual train station.
   * Format is always the same length with whitespaces appended to the destination field.
   * Departure time includes any set delay.
   * If some values are not set, they return string will be empty.
   * Includes newline at the end if all values are set.
   * The way the string has been formatted is with the help of StringBuilder.
   * Input is reversed, whitespaces are added to the reversed input in the beginning,
   * and then the reversed input is reversed again.
   * This way, the whitespaces are added to the end of the input.
   * This is done to make sure the string is always the same length.
   * This is done for all fields except the track field.
   *
   * @see #getLine()
   * @see #getTrack()
   * @see #getDepartureTime()
   * @see #getDestination()
   * @return a string representation of the {@code TrainDeparture}.
   * @since 1.0.0
   */
  public String getDetails() {
    // If some values are not set, return empty string
    if (line.isEmpty()
            || destination.isEmpty()
            || track == -1
            || departureTime[0] == 0
            || departureTime[1] == 0
    ) {
      return "";
    }

    // Formatting the departure time with leading zeros if needed
    String formattedDepartureTime = String.format(
        "%02d:%02d", getDepartureTime()[0], getDepartureTime()[1]
    );

    // Reversing the input
    StringBuilder inputReversed = new StringBuilder();
    inputReversed.append(formattedDepartureTime);
    inputReversed.append(" ");
    inputReversed.append(getLine());
    inputReversed.append(" ");
    inputReversed.append(getDestination());
    inputReversed.reverse();

    String whitespacesReversed = String.format("%1$26s", inputReversed);
    // Catting the leading whitespaces to reversed destination
    StringBuilder formattedDestination = new StringBuilder(whitespacesReversed);
    formattedDestination.reverse();


    // Using StringBuilder for efficiency and readability
    StringBuilder objectInformation;
    objectInformation = new StringBuilder();

    // Appending details of the train departure to StringBuilder
    objectInformation
        .append(formattedDestination)
        .append(" ")
        .append(getTrack())
        .append("\n");

    return String.valueOf(objectInformation);
  }

  /**
   * Returns the departure time of the {@code TrainDeparture} with delay added.
   * If delay is null, delay is set to 0.
   * If departure time is null, departure time is set to 0.
   * In case of overflow, departure time is corrected with use of floor division and modulo.
   * This is done for both hours and minutes.
   *
   * @return the departure time of the {@code TrainDeparture} with delay added.
   * @since 1.2.0
   */
  public int[] getCorrectedDepartureTime() {
    int departureHour = getDepartureTime()[0] + getDelay()[0];
    int departureMinute = getDepartureTime()[1] + getDelay()[1];

    // If departure minute is greater than 60,
    // add the times departure minute is divisible by 60 to departure hour.
    // This operation is performed on integers, which means floor division is used.
    departureHour += departureMinute / 60;

    // If departure hour is greater than 24,
    // add the times departure hour is divisible by 24 to departure hour.
    departureMinute %= 60;

    // If departure hour is greater than 24,
    // add the times departure hour is divisible by 24 to departure hour.
    departureHour %= 24;

    return new int[]{departureHour, departureMinute};
  }

  /**
   * Compares this {@code TrainDeparture} with the specified {@code TrainDeparture} for order.
   * Returns a negative integer, zero, or a positive integer as this {@code TrainDeparture}
   * is less than, equal to, or greater than the specified {@code TrainDeparture}.
   * The comparison is primarily based on the departure time of the {@code TrainDeparture}.
   *
   * @param other the {@code TrainDeparture} to be compared.
   *              If null, returns 1.
   * @return a negative integer, zero, or a positive integer as this {@code TrainDeparture}
   *        is less than, equal to, or greater than the specified {@code TrainDeparture}.
   *        If null, returns 1.
   * @since 1.1.0
   */
  @Override
  public int compareTo(TrainDeparture other) {
    if (other == null) {
      return 1;
    }

    int[] thisDepartureTime = getCorrectedDepartureTime();
    int[] otherDepartureTime = other.getCorrectedDepartureTime();

    // Comparing departure times
    if (thisDepartureTime[0] > otherDepartureTime[0]) {
      return 1;
    }
    if (thisDepartureTime[0] < otherDepartureTime[0]) {
      return -1;
    }
    // If departure hours are equal, compare minutes
    return Integer.compare(thisDepartureTime[1], otherDepartureTime[1]);
  }
}
