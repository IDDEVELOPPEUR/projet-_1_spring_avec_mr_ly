package sn.edu.isepdiamniadio.coursspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.edu.isepdiamniadio.coursspring.controller.dto.EcoleDTO;
import sn.edu.isepdiamniadio.coursspring.domain.Ecole;
import sn.edu.isepdiamniadio.coursspring.service.EcoleJpaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ecoles")
public class EcoleJpaController {

    private final EcoleJpaService ecoleJpaService;

    public EcoleJpaController(EcoleJpaService ecoleJpaService) {
        this.ecoleJpaService = ecoleJpaService;
    }
    @GetMapping
    public ResponseEntity<List<Ecole>> listerEcoles() {
        List<Ecole> ecoles = ecoleJpaService.findAllEcoles();
        return new ResponseEntity<>(ecoles, HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> trouverEcoleParId(@PathVariable Long id) {
        Optional<EcoleDTO> ecoleOptional = ecoleJpaService.findEcoleById(id);

        if (ecoleOptional.isPresent()) {
            return ResponseEntity.ok(ecoleOptional.get());
        } else {
            return ResponseEntity.status(404).body("Aucune école trouvée avec l'ID " + id);
        }
    }


    @GetMapping("/specification")
    public List<Ecole> specification(@RequestParam int idProf, @RequestParam Long id) {
        return ecoleJpaService.getEcolesAvecSpecification(idProf, id);
    }


    @GetMapping("/adresse")
    public ResponseEntity<?> rechercherEcolesParAdresse(@RequestParam String adresse) {
        List<EcoleDTO> ecoles = ecoleJpaService.findEcolesByAdresse(adresse);

        if (!ecoles.isEmpty()) {
            return ResponseEntity.ok(ecoles);
        } else {
            return ResponseEntity.status(404).body("Aucune école trouvée à l'adresse : " + adresse);
        }
    }
}