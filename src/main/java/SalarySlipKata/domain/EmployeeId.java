package SalarySlipKata.domain;

import static java.lang.String.valueOf;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class EmployeeId {
  private int id;

  public EmployeeId(int id) {this.id = id;}

  @Override
  public String toString() {
    return valueOf(id);
  }

  @Override
  public boolean equals(Object o) {

    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    EmployeeId that = (EmployeeId) o;

    return new EqualsBuilder()
        .append(id, that.id)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(id)
        .toHashCode();
  }
}
