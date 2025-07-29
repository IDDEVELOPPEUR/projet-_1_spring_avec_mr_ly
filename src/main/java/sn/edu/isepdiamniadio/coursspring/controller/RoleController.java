package sn.edu.isepdiamniadio.coursspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.edu.isepdiamniadio.coursspring.domain.Role;
import sn.edu.isepdiamniadio.coursspring.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping
    public List<Role> findAllRoles(){
        return roleService.findAllRoles();
    }
    @GetMapping("/{id}")
    public Role findRoleById(@PathVariable Long id){
        return roleService.findRoleById(id);
    }
    @PostMapping("/ajouter")
    public Role saveRole(Role role){
        return roleService.saveRole(role);
    }
    @DeleteMapping("/supprimer/{id}")
    public void deleteRole(@PathVariable Long id){
        roleService.deleteRole(roleService.findRoleById(id));
    }
    @PutMapping("/modifier/{id}")
    public Role updateRole(@RequestBody Role role, @PathVariable Long id) {
         Role rol=roleService.findRoleById(id);
        if(rol.getId() == null){

            return roleService.saveRole(role);
        }

        return null;
    }
}
