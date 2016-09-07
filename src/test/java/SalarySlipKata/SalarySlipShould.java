package SalarySlipKata;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import SalarySlipKata.domain.Employee;
import SalarySlipKata.domain.EmployeeId;
import SalarySlipKata.infrastructure.EmployeeRepository;
import SalarySlipKata.infrastructure.StandardSalarySlipPrinter;

public class SalarySlipShould {
  private static final EmployeeId EMPLOYEE_ID_12345 = new EmployeeId(12345);

  private StandardSalarySlipPrinter standardSalarySlipPrinter;
  private EmployeeRepository employeeRepository;
  private SalarySlip salarySlip;

  @Before
  public void initialise() {
    employeeRepository = mock(EmployeeRepository.class);

    standardSalarySlipPrinter = mock(StandardSalarySlipPrinter.class);

    salarySlip = new SalarySlip(employeeRepository, standardSalarySlipPrinter);
  }

  @Test public void
  print_a_salary_slip() {
    Employee employee = new Employee(EMPLOYEE_ID_12345, "John J Doe", 24000);
    when(employeeRepository.get(EMPLOYEE_ID_12345)).thenReturn(employee);

    salarySlip.printFor(EMPLOYEE_ID_12345, "Sep 2016");

    verify(standardSalarySlipPrinter).print(employee, "Sep 2016");
  }
}
