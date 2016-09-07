package SalarySlipKata.infrastructure;

import java.util.HashMap;
import java.util.Map;

import SalarySlipKata.domain.Employee;
import SalarySlipKata.domain.EmployeeId;

public class EmployeeRepository {
  private EmployeeId id;
  private String name;
  private int annualSalary;

  private Map<EmployeeId, Employee> employees = new HashMap<>();

  public void add(EmployeeId id, String name, int annualSalary) {
    employees.put(id, new Employee(id, name, annualSalary));
  }

  public Employee get(EmployeeId employeeId) {
    return employees.get(employeeId);
  }
}
