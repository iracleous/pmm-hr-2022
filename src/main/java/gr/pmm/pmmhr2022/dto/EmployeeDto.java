package gr.pmm.pmmhr2022.dto;

import gr.pmm.pmmhr2022.model.Department;
import gr.pmm.pmmhr2022.model.Employee;
import gr.pmm.pmmhr2022.model.Project;
import gr.pmm.pmmhr2022.model.Role;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDto {
    private Long id;
    private String name;
    private Role role;

    private String departmentName;

}
