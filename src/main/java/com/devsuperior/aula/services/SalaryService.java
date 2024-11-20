package com.devsuperior.aula.services;


import com.devesuperior.aula.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

    @Autowired
    private TaxService taxService;

    @Autowired
    private PensionService pensionService;



    public double netSalary(Employee employee){
        return employee.getGrossSalary() - taxService.tax(employee.getGrossSalary())
                - pensionService.discount(employee.getGrossSalary());
    }
}
