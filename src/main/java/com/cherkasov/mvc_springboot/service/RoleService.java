package com.cherkasov.mvc_springboot.service;

import com.cherkasov.mvc_springboot.models.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    List<Role> getAllRoles();

    Role getRoleById(Long id);
    Set<Role> getSetRolesToUser(String[] rolenames);
}
