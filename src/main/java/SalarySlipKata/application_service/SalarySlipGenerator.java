package SalarySlipKata.application_service;

import SalarySlipKata.domain.EmployeeId;
import SalarySlipKata.infrastructure.StandardSalarySlipPrinter;

public class SalarySlipGenerator {

  private StandardSalarySlipPrinter standardSalarySlipPrinter;

  public SalarySlipGenerator(StandardSalarySlipPrinter standardSalarySlipPrinter) {
    this.standardSalarySlipPrinter = standardSalarySlipPrinter;
  }

  public void printFor(EmployeeId employeeId, String salaryPeriod) {
    standardSalarySlipPrinter.print();
  }
}
