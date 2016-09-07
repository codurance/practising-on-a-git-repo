package SalarySlipKata;

import SalarySlipKata.application_service.SalarySlipGenerator;
import SalarySlipKata.domain.EmployeeId;
import SalarySlipKata.domain_service.EmployeeRepository;
import SalarySlipKata.infrastructure.Clock;
import SalarySlipKata.infrastructure.Console;
import SalarySlipKata.infrastructure.StandardSalarySlipPrinter;

public class SalarySlipGeneratorApplication {
  private static final EmployeeId EMPLOYEE_ID_12345 = new EmployeeId(12345);

  public static void main(String[] args) {
    EmployeeRepository employeeRepository = new EmployeeRepository();
    Clock clock = new Clock();
    Console console = new Console();
    StandardSalarySlipPrinter standardSalaryPrinter = new StandardSalarySlipPrinter(clock, console);
    SalarySlipGenerator salarySlipGenerator = new SalarySlipGenerator(employeeRepository, standardSalaryPrinter);

    employeeRepository.addEmployee(EMPLOYEE_ID_12345, "John J Doe", 24000);

    salarySlipGenerator.printFor(EMPLOYEE_ID_12345, "Sep 2016");
  }
}
