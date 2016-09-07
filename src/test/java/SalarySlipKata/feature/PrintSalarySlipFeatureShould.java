package SalarySlipKata.feature;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import SalarySlipKata.SalarySlipGenerator;
import SalarySlipKata.domain.EmployeeId;
import SalarySlipKata.infrastructure.Console;
import SalarySlipKata.infrastructure.EmployeeRepository;

public class PrintSalarySlipFeatureShould {
  private static final EmployeeId EMPLOYEE_ID_12345 = new EmployeeId(12345);

  private EmployeeRepository employeeRepository;
  private SalarySlipGenerator salarySlipGenerator;
  private Console console;

  @Before
  public void initialise() {
    employeeRepository = new EmployeeRepository();
    salarySlipGenerator = new SalarySlipGenerator();
    console = mock(Console.class);
  }

  @Test public void
  print_salary_slip_for_an_employee() {
    employeeRepository.addEmployee(EMPLOYEE_ID_12345, "John J Doe", 24000);

    salarySlipGenerator.printFor(EMPLOYEE_ID_12345, "Sep 2016");

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
