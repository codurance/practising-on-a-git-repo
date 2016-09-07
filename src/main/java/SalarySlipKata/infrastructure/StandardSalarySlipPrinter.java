package SalarySlipKata.infrastructure;

import static java.lang.String.format;
import static java.lang.String.valueOf;

import SalarySlipKata.domain.Employee;

public class StandardSalarySlipPrinter {
  private Console console;
  private Clock clock;

  public StandardSalarySlipPrinter(Clock clock, Console console) {
    this.clock = clock;
    this.console = console;
  }

  public void print(Employee employee, String salaryPeriod) {
    console.print(
        format(
            "Date: %s             Salary for period: %s%n" +
            "                                                         %n" +
            "Employee ID: %s            Employee Name: %s  %n" +
            "                                                         %n" +
            "EARNINGS                                                 %n" +
            "Basic            £%s.00                                %n",
            clock.todayAsString(),
            salaryPeriod,
            employee.id(),
            employee.name(),
            valueOf(employee.monthlySalary())
        )
    );
  }
}
