package SalarySlipKata;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import SalarySlipKata.domain.Employee;
import SalarySlipKata.domain.EmployeeId;
import SalarySlipKata.infrastructure.InMemoryEmployeeRepository;
import SalarySlipKata.infrastructure.SalarySlipPrinter;

public class SalarySlipApplicationShould {
  private static final EmployeeId EMPLOYEE_ID_12345 = new EmployeeId(12345);
  private SalarySlipPrinter salarySlipPrinter;
  private SalarySlipApplication salarySlipApplication;
  private InMemoryEmployeeRepository inMemoryEmployeeRepository;

  @Before
  public void setUp() throws Exception {
    salarySlipPrinter = mock(SalarySlipPrinter.class);
    inMemoryEmployeeRepository = mock(InMemoryEmployeeRepository.class);
    salarySlipApplication = new SalarySlipApplication(inMemoryEmployeeRepository, salarySlipPrinter);
  }

  @Test public void
  print_salary_slip_for_an_employee() {
    Employee employee = new Employee(EMPLOYEE_ID_12345, "John J Doe", 24000);
    String salaryPeriod = "Sep 2016";
    when(inMemoryEmployeeRepository.get(EMPLOYEE_ID_12345)).thenReturn(employee);

    salarySlipApplication.printFor(EMPLOYEE_ID_12345, salaryPeriod);

    verify(salarySlipPrinter).print(employee, salaryPeriod);
  } 
}
