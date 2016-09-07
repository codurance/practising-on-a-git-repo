package SalarySlipKata.application_service;

import SalarySlipKata.domain.Employee;
import SalarySlipKata.domain.EmployeeId;
import SalarySlipKata.domain_service.EmployeeRepository;
import SalarySlipKata.infrastructure.StandardSalarySlipPrinter;

public class SalarySlipGenerator {

  private EmployeeRepository employeeRepository;
  private StandardSalarySlipPrinter standardSalarySlipPrinter;

  public SalarySlipGenerator(EmployeeRepository employeeRepository, StandardSalarySlipPrinter standardSalarySlipPrinter) {
    this.employeeRepository = employeeRepository;
    this.standardSalarySlipPrinter = standardSalarySlipPrinter;
  }

  public void printFor(EmployeeId employeeId, String salaryPeriod) {
    Employee employee = employeeRepository.getEmployee(employeeId);
    standardSalarySlipPrinter.print(employee, salaryPeriod);
  }
}
