package SalarySlipKata.infrastructure;

import static java.time.LocalDate.now;
import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {

  private static final DateTimeFormatter DD_MMM_YYYY = ofPattern("dd MMM yyyy");

  public String todayAsString() {
    return today().format(DD_MMM_YYYY);
  }

  protected LocalDate today() {return now();}
}
