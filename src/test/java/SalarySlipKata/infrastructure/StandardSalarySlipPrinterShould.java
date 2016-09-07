package SalarySlipKata.infrastructure;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import SalarySlipKata.domain.Employee;
import SalarySlipKata.domain.EmployeeId;

public class StandardSalarySlipPrinterShould {
  private static final EmployeeId EMPLOYEE_ID_12345 = new EmployeeId(12345);
  private EmployeeRepository employeeRepository;
  private Console console;
  private StandardSalarySlipPrinter standardSalarySlipPrinter;
  private Clock clock;

  @Before
  public void initialise() {
    employeeRepository = mock(EmployeeRepository.class);
    console = mock(Console.class);
    clock = mock(Clock.class);

    standardSalarySlipPrinter = new StandardSalarySlipPrinter(clock, console);
  }

  @Test public void
  print_a_salary_slip_to_the_console() {
    when(clock.todayAsString()).thenReturn("01 Sep 2016");
    final Employee employee = new Employee(EMPLOYEE_ID_12345, "John J Doe", 24000);
    when(employeeRepository.get(EMPLOYEE_ID_12345)).thenReturn(employee);

    standardSalarySlipPrinter.print(employee, "Sep 2016");

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
