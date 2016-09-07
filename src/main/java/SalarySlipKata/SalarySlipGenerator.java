package SalarySlipKata;

import SalarySlipKata.domain.Employee;
import SalarySlipKata.domain.EmployeeId;
import SalarySlipKata.infrastructure.EmployeeRepository;
import SalarySlipKata.infrastructure.StandardSalarySlipPrinter;

public class SalarySlipGenerator {

  private StandardSalarySlipPrinter standardSalarySlipPrinter;
  private EmployeeRepository employeeRepository;

  public SalarySlipGenerator(EmployeeRepository employeeRepository, StandardSalarySlipPrinter standardSalarySlipPrinter) {
    this.standardSalarySlipPrinter = standardSalarySlipPrinter;
    this.employeeRepository = employeeRepository;
  }

  public void printFor(EmployeeId employeeId, String salaryPeriod) {
    Employee employee = employeeRepository.getEmployee(employeeId);
    standardSalarySlipPrinter.print(employee, salaryPeriod);
  }
}
