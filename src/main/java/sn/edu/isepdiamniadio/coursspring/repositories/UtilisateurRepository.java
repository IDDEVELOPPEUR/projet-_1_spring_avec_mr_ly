package sn.edu.isepdiamniadio.coursspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.isepdiamniadio.coursspring.domain.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
}
