package gr.pmm.pmmhr2022.service;

import gr.pmm.pmmhr2022.dto.DepartmentDto;
import gr.pmm.pmmhr2022.dto.EmployeeDto;
import gr.pmm.pmmhr2022.exception.EmployeeException;

import java.util.List;

public interface HrService {
    void createEmployee(EmployeeDto employeeDto) throws EmployeeException;

    List<EmployeeDto> readAllEmployees();

    void createDepartment(DepartmentDto departmentDto) throws EmployeeException;

    List<DepartmentDto> readAllDepartments();


    void assignEmployeeToDepartment(long employeeId, long departmentId)throws EmployeeException;

    EmployeeDto readEmployee(long employeeId) throws EmployeeException;
}
