package SalarySlipKata.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Employee {
  private final EmployeeId id;
  private final String name;
  private final int annualSalary;

  public Employee(EmployeeId id, String name, int annualSalary) {
    this.id = id;
    this.name = name;
    this.annualSalary = annualSalary;
  }

  public EmployeeId id() {
    return id;
  }

  public String name() {
    return name;
  }

  public int monthlySalary() {
    return annualSalary / 12;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    Employee employee = (Employee) o;

    return new EqualsBuilder()
        .append(annualSalary, employee.annualSalary)
        .append(id, employee.id)
        .append(name, employee.name)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(id)
        .append(name)
        .append(annualSalary)
        .toHashCode();
  }
}
