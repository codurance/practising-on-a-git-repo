package SalarySlipKata;

import static java.time.LocalDate.now;

public class Clock {
  public String todayAsString() {
    return now().toString();
  }
}
