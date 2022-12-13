package gr.pmm.pmmhr2022.repository;

import gr.pmm.pmmhr2022.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
