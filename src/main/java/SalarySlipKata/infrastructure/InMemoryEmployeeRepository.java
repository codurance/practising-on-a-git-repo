package SalarySlipKata.infrastructure;

import java.util.HashMap;
import java.util.Map;

import SalarySlipKata.domain.Employee;
import SalarySlipKata.domain.EmployeeId;

public class InMemoryEmployeeRepository {
  private Map<EmployeeId, Employee> employees = new HashMap<>();

  public void add(EmployeeId id, Employee employee) {
    employees.put(id, employee);
  }

  public Employee get(EmployeeId id) {
    return employees.get(id);
  }
}
