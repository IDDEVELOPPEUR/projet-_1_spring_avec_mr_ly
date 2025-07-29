package sn.edu.isepdiamniadio.coursspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.isepdiamniadio.coursspring.domain.Role;
import sn.edu.isepdiamniadio.coursspring.repositories.RoleRepository;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAllRoles(){
        return roleRepository.findAll();
    }
    public Role findRoleById(Long id){
        return roleRepository.findById(id).orElse(null);
    }
    public Role saveRole(Role role){
        return roleRepository.save(role);
    }
    public void deleteRole(Role role){
        roleRepository.delete(role);

    }
}
