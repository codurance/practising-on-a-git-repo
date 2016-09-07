package SalarySlipKata.infrastructure;

import SalarySlipKata.domain.Employee;

public class StandardSalarySlipPrinter {
  private Clock clock;
  private Console console;

  public StandardSalarySlipPrinter(Clock clock, Console console) {
    this.clock = clock;
    this.console = console;
  }

  public void print(Employee employee, String salaryPeriod) {
    console.print(
        String.format(
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
            employee.monthlySalary()
     )
    );
  }
}
