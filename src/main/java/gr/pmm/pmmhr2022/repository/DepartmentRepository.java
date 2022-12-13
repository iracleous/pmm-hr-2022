package gr.pmm.pmmhr2022.repository;

import gr.pmm.pmmhr2022.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
