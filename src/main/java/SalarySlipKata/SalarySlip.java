package SalarySlipKata;

import SalarySlipKata.domain.Employee;
import SalarySlipKata.domain.EmployeeId;
import SalarySlipKata.infrastructure.EmployeeRepository;
import SalarySlipKata.infrastructure.StandardSalarySlipPrinter;

public class SalarySlip {

  private StandardSalarySlipPrinter standardSalarySlipPrinter;
  private EmployeeRepository employeeRepository;

  public SalarySlip(EmployeeRepository employeeRepository, StandardSalarySlipPrinter standardSalarySlipPrinter) {
    this.employeeRepository = employeeRepository;
    this.standardSalarySlipPrinter = standardSalarySlipPrinter;
  }

  public void printFor(EmployeeId employeeId, String salaryPeriod) {
    Employee employee = employeeRepository.get(employeeId);
    standardSalarySlipPrinter.print(employee, salaryPeriod);
  }
}
