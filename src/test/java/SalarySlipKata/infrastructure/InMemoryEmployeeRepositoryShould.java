package SalarySlipKata.infrastructure;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import SalarySlipKata.domain.Employee;
import SalarySlipKata.domain.EmployeeId;

public class InMemoryEmployeeRepositoryShould {
  private static final EmployeeId EMPLOYEE_ID_12345 = new EmployeeId(12345);
  private InMemoryEmployeeRepository inMemoryEmployeeRepository;

  @Before
  public void setUp() throws Exception {
    inMemoryEmployeeRepository = new InMemoryEmployeeRepository();
  }

  @Test public void
  return_a_employee_by_id() {
    Employee employee = new Employee(EMPLOYEE_ID_12345, "John J Doe", 24000);
    inMemoryEmployeeRepository.add(EMPLOYEE_ID_12345, employee);

    Employee actualEmployee = inMemoryEmployeeRepository.get(EMPLOYEE_ID_12345);

    assertThat(actualEmployee, is(employee));
  }
}
