package SalarySlipKata.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Employee {
  private final EmployeeId employeeId;
  private final String name;
  private final int amount;

  public Employee(EmployeeId employeeId, String name, int amount) {
    this.employeeId = employeeId;
    this.name = name;
    this.amount = amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    Employee employee = (Employee) o;

    return new EqualsBuilder()
        .append(amount, employee.amount)
        .append(employeeId, employee.employeeId)
        .append(name, employee.name)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(employeeId)
        .append(name)
        .append(amount)
        .toHashCode();
  }
}
