package SalarySlipKata.feature;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import SalarySlipKata.SalarySlip;
import SalarySlipKata.domain.EmployeeId;
import SalarySlipKata.infrastructure.Clock;
import SalarySlipKata.infrastructure.Console;
import SalarySlipKata.infrastructure.EmployeeRepository;
import SalarySlipKata.infrastructure.StandardSalarySlipPrinter;

public class PrintSalarySlipFeatureShould {

  private static final EmployeeId EMPLOYEE_ID_12345 = new EmployeeId(12345);

  private EmployeeRepository employeeRepository;
  private SalarySlip salarySlip;
  private Console console;
  private StandardSalarySlipPrinter standardSalarySlipPrinter;
  private Clock clock;

  @Before
  public void initialise() {
    console = mock(Console.class);
    clock = mock(Clock.class);

    employeeRepository = new EmployeeRepository();

    standardSalarySlipPrinter = new StandardSalarySlipPrinter(clock, console);

    salarySlip = new SalarySlip(employeeRepository, standardSalarySlipPrinter);
  }

  @Test public void
    print_a_salary_slip() {
      when(clock.todayAsString()).thenReturn("01 Sep 2016");
      employeeRepository.add(EMPLOYEE_ID_12345, "John J Doe", 24000);

      salarySlip.printFor(EMPLOYEE_ID_12345, "Sep 2016");

      verify(console).print(
          "Date: 01 Sep 2016             Salary for period: Sep 2016\n" +
          "                                                         \n" +
          "Employee ID: 12345            Employee Name: John J Doe  \n" +
          "                                                         \n" +
          "EARNINGS                                                 \n" +
          "Basic            £2000.00                                \n"
      );
    } 
}
