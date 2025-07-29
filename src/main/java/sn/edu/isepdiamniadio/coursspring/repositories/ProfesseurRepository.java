package sn.edu.isepdiamniadio.coursspring.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import sn.edu.isepdiamniadio.coursspring.domain.Professeur;

import java.util.List;

public interface ProfesseurRepository extends JpaRepository<Professeur, Long>, JpaSpecificationExecutor<Professeur> {

    Page<Professeur> findAllByOrderByNomAsc(Pageable pageable);

    // ici, je fais la rechercher les professeurs qui habitent et enseignent au même endroit
    @Query("SELECT p FROM Professeur p JOIN p.ecoles e WHERE p.adresse = e.adresse")
    List<Professeur> findProfesseursMemeAdresse();

    static Specification<Professeur> adresseEgaleEcole() {
        return (root, query, criteriaBuilder) -> 
                criteriaBuilder.isTrue(
                        criteriaBuilder.equal(root.get("adresse"), root.join("ecoles").get("adresse"))
                );
    }


}