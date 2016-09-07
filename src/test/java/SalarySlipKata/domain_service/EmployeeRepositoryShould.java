package SalarySlipKata.domain_service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import SalarySlipKata.domain.Employee;
import SalarySlipKata.domain.EmployeeId;

public class EmployeeRepositoryShould {

  private static final EmployeeId EMPLOYEE_12345 = new EmployeeId(12345);
  private EmployeeRepository employeeRepository;

  @Before
  public void initialise() {
      employeeRepository = new EmployeeRepository();
  }

  @Test public void
  add_an_employee_to_the_in_memory_store() {
    Employee actualEmployee = new Employee(EMPLOYEE_12345, "John J Doe", 24000);
    employeeRepository.addEmployee(EMPLOYEE_12345, "John J Doe", 24000);

    Employee expectedEmployee = employeeRepository.getEmployee(EMPLOYEE_12345);

    assertThat(actualEmployee, is(expectedEmployee));
  } 
}
