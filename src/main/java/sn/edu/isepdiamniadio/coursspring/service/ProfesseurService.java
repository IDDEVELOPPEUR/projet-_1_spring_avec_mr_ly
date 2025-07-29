package sn.edu.isepdiamniadio.coursspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sn.edu.isepdiamniadio.coursspring.domain.Professeur;
import sn.edu.isepdiamniadio.coursspring.repositories.ProfesseurRepository;

import java.util.List;

@Service
public class ProfesseurService {

    @Autowired
    private ProfesseurRepository professeurRepository;

    // Lister les professeurs avec pagination et trie par son nom
    public Page<Professeur> listerProfesseurs(Pageable pageable) {
        return professeurRepository.findAllByOrderByNomAsc(pageable);
    }

    //la methode pour la recherche des professeurs qui habitent dans les établissements où ils enseignent
    public List<Professeur> rechercherProfesseursMemeAdresse() {
        return professeurRepository.findProfesseursMemeAdresse();
    }

    public List<Professeur> findAll(){
        return professeurRepository.findAll();
    };
    public Professeur findProfesseurById(Long id){
        return professeurRepository.findById(id).orElse(null);
    }
    public Professeur saveProfesseur(Professeur professeur){
        return professeurRepository.save(professeur);
    }
    public void deleteProfesseur(Professeur professeur){
        professeurRepository.delete(professeur);
    }
}