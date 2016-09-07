package SalarySlipKata.infrastructure;

import static java.time.LocalDate.now;
import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.LocalDate;

public class Clock {

  private static final String DD_MMM_YYYY_FORMAT = "dd MMM yyyy";

  public String todayAsString() {
    return getCurrentDate().format(ofPattern(DD_MMM_YYYY_FORMAT));
  }

  protected LocalDate getCurrentDate() {return now();}
}
