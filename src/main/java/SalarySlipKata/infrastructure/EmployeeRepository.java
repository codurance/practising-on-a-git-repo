package SalarySlipKata.infrastructure;

import java.util.HashMap;
import java.util.Map;

import SalarySlipKata.domain.Employee;
import SalarySlipKata.domain.EmployeeId;

public class EmployeeRepository {
  private Map<EmployeeId, Employee> employees = new HashMap<>();

  public void addEmployee(EmployeeId employeeId, String name, int annualSalary) {
    employees.put(employeeId, new Employee(employeeId, name, annualSalary));
  }

  public Employee getEmployee(EmployeeId employeeId) {
    return employees.get(employeeId);
  }
}
