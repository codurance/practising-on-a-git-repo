package SalarySlipKata.feature;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import SalarySlipKata.SalarySlipApplication;
import SalarySlipKata.domain.Employee;
import SalarySlipKata.domain.EmployeeId;
import SalarySlipKata.infrastructure.Clock;
import SalarySlipKata.infrastructure.Console;
import SalarySlipKata.infrastructure.InMemoryEmployeeRepository;
import SalarySlipKata.infrastructure.SalarySlipPrinter;

public class PrintSalarySlipFeatureShould {
  private static final EmployeeId EMPLOYEE_ID_12345 = new EmployeeId(12345);
  private static final String SALARY_PERIOD = "Sep 2016";

  private Console console;
  private InMemoryEmployeeRepository inMemoryEmployeeRepository;
  private SalarySlipPrinter salarySlipPrinter;
  private SalarySlipApplication salarySlipApplication;
  private Clock clock;

  @Before
  public void setUp() throws Exception {
    console = mock(Console.class);
    clock = mock(Clock.class);
    salarySlipPrinter = new SalarySlipPrinter(clock, console);

    inMemoryEmployeeRepository = new InMemoryEmployeeRepository();

    salarySlipApplication =
        new SalarySlipApplication(inMemoryEmployeeRepository, salarySlipPrinter);
  }

  @Test public void
  print_salary_slip_for_an_employee() {
    when(clock.todayAsString()).thenReturn("01 Sep 2016");
    inMemoryEmployeeRepository.add(EMPLOYEE_ID_12345, new Employee(EMPLOYEE_ID_12345, "John J Doe", 24000));

    salarySlipApplication.printFor(EMPLOYEE_ID_12345, SALARY_PERIOD);

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
