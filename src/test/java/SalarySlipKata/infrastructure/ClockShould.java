package SalarySlipKata.infrastructure;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import static java.time.LocalDate.of;

import java.time.LocalDate;

import org.junit.Test;

public class ClockShould {
  @Test public void
  return_the_current_date_in_the_dd_MMM_yyyy_format() {
    Clock clock = new TestableClock();

    assertThat(clock.todayAsString(), is("08 Sep 2016"));
  }

  private class TestableClock extends Clock {
    @Override
    protected LocalDate today() {
      return of(2016, 9, 8);
    }
  }
}
