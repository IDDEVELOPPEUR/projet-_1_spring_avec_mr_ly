package sn.edu.isepdiamniadio.coursspring.service;

import org.springframework.stereotype.Service;
import sn.edu.isepdiamniadio.coursspring.controller.dto.EcoleDTO;
import sn.edu.isepdiamniadio.coursspring.domain.Ecole;
import sn.edu.isepdiamniadio.coursspring.domain.Specificat;
import sn.edu.isepdiamniadio.coursspring.repositories.EcoleJpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EcoleJpaService {

    private final EcoleJpaRepository ecoleJpaRepository;

    public EcoleJpaService(EcoleJpaRepository ecoleJpaRepository) {
        this.ecoleJpaRepository = ecoleJpaRepository;
    }

    public Optional<EcoleDTO> findEcoleById(Long id) {
        // on récupère l'école si elle est dans la BD
        Optional<Ecole> optionalEcole = ecoleJpaRepository.findById(id);

        if (optionalEcole.isPresent()) {
            Ecole ecole = optionalEcole.get();

            EcoleDTO dto = new EcoleDTO();
            dto.setEcole(ecole);
            dto.setMessage("L'école " + ecole.getNom() + " a été trouvée.");
            return Optional.of(dto);
        } else {
            return Optional.empty();
        }
    }


    public List<EcoleDTO> findEcolesByAdresse(String adresse) {
        List<Ecole> ecoles = ecoleJpaRepository.findByAdresse(adresse);


        List<EcoleDTO> ecoleDTOs = new ArrayList<>();
        for (Ecole ecole : ecoles) {
            EcoleDTO dto = new EcoleDTO();
            dto.setEcole(ecole);
            dto.setMessage("Ecole trouvée : " + ecole.getNom());
            ecoleDTOs.add(dto);
        }
        return ecoleDTOs;
    }

    public List<Ecole> findAllEcoles() {
        return ecoleJpaRepository.findAll();
    }

    public List<Ecole> getEcolesAvecSpecification(int idProf, Long id) {
        return ecoleJpaRepository.findAll(Specificat.avecSpecification(idProf, id));
    }



}