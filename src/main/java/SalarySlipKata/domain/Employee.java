package SalarySlipKata.domain;

import static java.lang.String.valueOf;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Employee {
  private final EmployeeId id;
  private final String name;
  private int annualSalary;

  public Employee(EmployeeId id, String name, int annualSalary) {
    this.id = id;
    this.name = name;
    this.annualSalary = annualSalary;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    Employee employee = (Employee) o;

    return new EqualsBuilder()
        .append(id, employee.id)
        .append(name, employee.name)
        .append(annualSalary, employee.annualSalary)
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

  public EmployeeId getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getMonthlySalary() {
    return valueOf(annualSalary / 12);
  }
}
