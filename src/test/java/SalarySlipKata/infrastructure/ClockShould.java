package SalarySlipKata.infrastructure;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static java.time.LocalDate.of;

import java.time.LocalDate;

import org.junit.Test;

public class ClockShould {
  @Test public void
  return_todays_date_formatted_as_dd_MMM_yyyy() {
    Clock clock = new TestableClock();

    assertThat(clock.todayAsString(), is("01 Sep 2016"));
  }

  private class TestableClock extends Clock {
    protected LocalDate getCurrentDate() {
      return of(2016, 9, 1);
    }
  }
}
