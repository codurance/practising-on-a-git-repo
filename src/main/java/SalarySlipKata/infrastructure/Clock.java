package SalarySlipKata.infrastructure;

import static java.time.LocalDate.now;
import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.LocalDate;

public class Clock {
  public String todayAsString() {
    return getCurrentDate().format(ofPattern("dd MMM yyyy"));
  }

  protected LocalDate getCurrentDate() {
    return now();
  }
}
