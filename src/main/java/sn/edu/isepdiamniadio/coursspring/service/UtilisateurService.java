package sn.edu.isepdiamniadio.coursspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.isepdiamniadio.coursspring.domain.Utilisateur;
import sn.edu.isepdiamniadio.coursspring.repositories.UtilisateurRepository;

import java.util.List;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> findAllUtilisateurs(){
        return utilisateurRepository.findAll();
    }
    public Utilisateur findUtilisateurById(Long id){
        return utilisateurRepository.findById(id).orElse(null);
    }
    public Utilisateur saveUtilisateur(Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }
    public void deleteUtilisateur(Utilisateur utilisateur){
        utilisateurRepository.delete(utilisateur);
    }


}
