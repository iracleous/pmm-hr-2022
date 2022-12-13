package gr.pmm.pmmhr2022.service;

import gr.pmm.pmmhr2022.dto.DepartmentDto;
import gr.pmm.pmmhr2022.dto.EmployeeDto;
import gr.pmm.pmmhr2022.dto.ProjectDto;
import gr.pmm.pmmhr2022.exception.EmployeeException;
import gr.pmm.pmmhr2022.model.Department;
import gr.pmm.pmmhr2022.model.Employee;
import gr.pmm.pmmhr2022.model.Project;
import gr.pmm.pmmhr2022.repository.DepartmentRepository;
import gr.pmm.pmmhr2022.repository.EmployeeRepository;
import gr.pmm.pmmhr2022.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HrServiceImpl implements HrService{

    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;

    private ProjectRepository projectRepository;
    private ModelMapper modelMapper;


    @Override
    @Transactional
    public void createEmployee(EmployeeDto employeeDto) throws EmployeeException {
        if (employeeDto == null)
            throw new EmployeeException("null dto");
        if (employeeDto.getName() == null)
            throw new EmployeeException("null dto");

        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employeeRepository.save(employee);
        employeeDto.setId(employee.getId());
    }

    @Override
    public List<EmployeeDto> readAllEmployees() {
        return employeeRepository
                .findAll()
                .stream()
                .map( e -> modelMapper.map(e, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void createDepartment(DepartmentDto departmentDto) throws EmployeeException {
        if (departmentDto == null)
            throw new EmployeeException("null dto");
        if (departmentDto.getName() == null)
            throw new EmployeeException("null dto");

        Department department = modelMapper.map(departmentDto, Department.class);
        departmentRepository.save(department);
        departmentDto.setId(department.getId());

    }

    @Override
    public List<DepartmentDto> readAllDepartments() {
        return departmentRepository
                .findAll()
                .stream()
                .map( e -> modelMapper.map(e, DepartmentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void assignEmployeeToDepartment(long employeeId, long departmentId) throws EmployeeException {
        Optional<Department> departmentOpt = departmentRepository.findById(departmentId);
        if (departmentOpt.isEmpty()){
            throw new EmployeeException("Department not found");
        }
         Optional<Employee> employeeOptional = employeeRepository.findById(employeeId)  ;
        if (employeeOptional.isEmpty()){
            throw new EmployeeException("Employee not found");
        }
        Employee employee = employeeOptional.get();
        employee.setDepartment(departmentOpt.get());
        employeeRepository.save(employee);
    }

    @Override
    public EmployeeDto readEmployee(long employeeId) throws EmployeeException{
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if(employeeOptional.isPresent())
        return modelMapper.map(employeeOptional.get(), EmployeeDto.class);
        else
            throw new EmployeeException("employee not found");
    }

    @Override
    @Transactional
    public void createProject(ProjectDto projectDto) throws EmployeeException {
        if (projectDto == null)
            throw new EmployeeException("null dto");
        if (projectDto.getName() == null)
            throw new EmployeeException("no name dto");

        Project project = modelMapper.map(projectDto, Project.class);
        projectRepository.save(project);
        projectDto.setId(project.getId());
    }

    @Override
    @Transactional
    public void assignProjectToEmployee(long employeeId, long projectId) throws EmployeeException {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if(!employeeOptional.isPresent())
            throw new    EmployeeException("Employee not found");
        Optional<Project> projectOptional = projectRepository.findById(projectId);
        if(!projectOptional.isPresent())
            throw new    EmployeeException("Project not found");

        Employee employee = employeeOptional.get();
        Project project = projectOptional.get();
         employee.getProjects().add(project);
         employeeRepository.save(employee);
    }
}
