package SalarySlipKata.application_service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import SalarySlipKata.domain.EmployeeId;
import SalarySlipKata.infrastructure.StandardSalarySlipPrinter;

public class SalarySlipGeneratorShould {
  private StandardSalarySlipPrinter standardSalarySlipPrinter;
  private SalarySlipGenerator salarySlipGenerator;

  @Before
  public void initialise() {
    standardSalarySlipPrinter = mock(StandardSalarySlipPrinter.class);
    salarySlipGenerator = new SalarySlipGenerator(standardSalarySlipPrinter);
  }

  @Test public void
  print_a_salary_slip_for_an_employee() {
    salarySlipGenerator.printFor(new EmployeeId(12345), "01/09/2016");

    verify(standardSalarySlipPrinter).print();
  } 

}
