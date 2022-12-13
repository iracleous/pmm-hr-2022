package gr.pmm.pmmhr2022.controller;

import gr.pmm.pmmhr2022.dto.DepartmentDto;
import gr.pmm.pmmhr2022.dto.EmployeeDto;
import gr.pmm.pmmhr2022.dto.ProjectDto;
import gr.pmm.pmmhr2022.exception.EmployeeException;
import gr.pmm.pmmhr2022.service.HrService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class HrController {

    private HrService hrService;
    @GetMapping("/employee")
    public List<EmployeeDto> readAllEmployees(){
        return hrService.readAllEmployees();
    }

    @PostMapping("/employee")
    public EmployeeDto create(@RequestBody EmployeeDto employeeDto) throws EmployeeException {
        hrService.createEmployee(employeeDto);
        return employeeDto;
    }

    @GetMapping("/department")
    public List<DepartmentDto> readAllDepartments(){
        return hrService.readAllDepartments();
    }

    @PostMapping("/department")
    public DepartmentDto create(@RequestBody DepartmentDto departmentDto) throws EmployeeException {
        hrService.createDepartment(departmentDto);
        return departmentDto;
    }

@PutMapping("/employee/{employeeId}/department/{departmentId}")
    public EmployeeDto  assignToDepartment(@PathVariable(name="employeeId") long employeeId,
                                           @PathVariable(name="departmentId") long departmentId) throws EmployeeException {
        hrService.assignEmployeeToDepartment(employeeId, departmentId);
        return hrService.readEmployee(employeeId);

    }


    @PostMapping("/project")
    public ProjectDto create(@RequestBody ProjectDto projectDto) throws EmployeeException {
        hrService.createProject(projectDto);
        return projectDto;
    }

    @PutMapping("/employee/{employeeId}/project/{projectId}")
    public EmployeeDto  assignToProject(@PathVariable(name="employeeId") long employeeId,
                                           @PathVariable(name="projectId") long projectId) throws EmployeeException {
        hrService.assignProjectToEmployee(employeeId, projectId);
        return hrService.readEmployee(employeeId);

    }



}
