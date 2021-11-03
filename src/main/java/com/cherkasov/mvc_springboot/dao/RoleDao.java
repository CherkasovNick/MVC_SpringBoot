package com.cherkasov.mvc_springboot.dao;


import com.cherkasov.mvc_springboot.models.Role;

import java.util.List;
import java.util.Set;

public interface RoleDao {

    List<Role> getAllRoles();

    Role getRoleById(Long id);

    Set<Role> getSetRolesToUser(String[] selectedRoles);
}
