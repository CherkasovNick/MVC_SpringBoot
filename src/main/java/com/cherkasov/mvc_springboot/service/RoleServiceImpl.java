package com.cherkasov.mvc_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cherkasov.mvc_springboot.dao.RoleDao;
import com.cherkasov.mvc_springboot.models.Role;

import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }

    @Override
    public Set<Role> getSetRolesToUser(String[] rolenames) {
        return roleDao.getSetRolesToUser(rolenames);
    }
}
