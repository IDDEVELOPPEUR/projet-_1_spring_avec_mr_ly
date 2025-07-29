package sn.edu.isepdiamniadio.coursspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.isepdiamniadio.coursspring.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
