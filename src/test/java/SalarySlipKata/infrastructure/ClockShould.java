package SalarySlipKata.infrastructure;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import org.junit.Test;

public class ClockShould {
  @Test public void
  return_today_as_a_string_in_the_dd_MMM_yyyy_format() {
    Clock clock = new TestableClock();

    assertThat(clock.todayAsString(), is("01 Sep 2016"));
  }

  private class TestableClock extends Clock {
    protected LocalDate getCurrentDate() {
      return LocalDate.of(2016, 9, 1);
    }
  }
}
