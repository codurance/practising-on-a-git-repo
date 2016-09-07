package SalarySlipKata;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import SalarySlipKata.domain.Employee;
import SalarySlipKata.domain.EmployeeId;
import SalarySlipKata.infrastructure.EmployeeRepository;
import SalarySlipKata.infrastructure.StandardSalarySlipPrinter;

public class SalarySlipGeneratorShould {
  private static final EmployeeId EMPLOYEE_ID_12345 = new EmployeeId(12345);

  private StandardSalarySlipPrinter standardSalarySlipPrinter;
  private EmployeeRepository employeeRepository;
  private SalarySlipGenerator salarySlipGenerator;

  @Before
  public void initialise() {
    employeeRepository = new EmployeeRepository();

    standardSalarySlipPrinter = mock(StandardSalarySlipPrinter.class);

    salarySlipGenerator = new SalarySlipGenerator(employeeRepository, standardSalarySlipPrinter);
  }

  @Test public void
  print_a_salary_slip_for_an_employee() {
    employeeRepository.addEmployee(EMPLOYEE_ID_12345, "John J Doe", 24000);
    Employee employee = employeeRepository.getEmployee(EMPLOYEE_ID_12345);

    salarySlipGenerator.printFor(EMPLOYEE_ID_12345, "Sep 2016");

    verify(standardSalarySlipPrinter).print(employee, "Sep 2016");
  }
}
