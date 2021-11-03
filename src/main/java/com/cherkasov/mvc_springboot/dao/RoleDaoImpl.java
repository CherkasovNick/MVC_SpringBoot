package com.cherkasov.mvc_springboot.dao;

import com.cherkasov.mvc_springboot.models.Role;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public Role getRoleById(Long id) {
        return entityManager.createQuery("select r from Role r where r.id = :id", Role.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public Set<Role> getSetRolesToUser(String[] selectedRoles) {
        System.out.println("Start setting");
        Set<Role> roles = new HashSet<>();
        for(Role role : getAllRoles()) {
            System.out.println("first loop");
            for(String str : selectedRoles) {
                System.out.println("second loop");
                System.out.println(str);
                if(str.equals(role.getName())) {
                    roles.add(getRoleById(role.getId()));
                    System.out.println("Role has setted");
                }
            }
        }
        return roles;
    }
}
