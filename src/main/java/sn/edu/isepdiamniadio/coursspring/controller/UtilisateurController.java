package sn.edu.isepdiamniadio.coursspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.edu.isepdiamniadio.coursspring.domain.Utilisateur;
import sn.edu.isepdiamniadio.coursspring.service.UtilisateurService;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public List<Utilisateur> findAllUtilisateurs(){
        return utilisateurService.findAllUtilisateurs();
    }
    @GetMapping("/{id}")
    public Utilisateur findUtilisateurById(@PathVariable Long id){
        return utilisateurService.findUtilisateurById(id);
    }
    @PostMapping("/ajouter")
    public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur){
        return utilisateurService.saveUtilisateur(utilisateur);
    }
    @DeleteMapping("/supprimer/{id}")
    public void deleteUtilisateur(@PathVariable Long id){
        utilisateurService.deleteUtilisateur(utilisateurService.findUtilisateurById(id));
    }
    @PutMapping("/modifier/{id}")
    public Utilisateur updateUtilisateur(@RequestBody Utilisateur utilisateur, @org.springframework.web.bind.annotation.PathVariable Long id) {
        utilisateur.setId(id);
        return utilisateur;
    }
}
