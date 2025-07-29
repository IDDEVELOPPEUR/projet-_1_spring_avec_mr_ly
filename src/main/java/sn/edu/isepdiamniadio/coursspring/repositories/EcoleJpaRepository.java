package sn.edu.isepdiamniadio.coursspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sn.edu.isepdiamniadio.coursspring.domain.Ecole;

import java.util.List;
import java.util.Optional;

public interface EcoleJpaRepository extends JpaRepository<Ecole,Long>, JpaSpecificationExecutor<Ecole> {

    Optional<Ecole> findByNom(String nom);
    List<Ecole> findByAdresse(String adresse);

}
