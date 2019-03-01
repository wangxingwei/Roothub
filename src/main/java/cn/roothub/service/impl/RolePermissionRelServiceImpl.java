package cn.roothub.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.roothub.dao.RolePermissionRelDao;
import cn.roothub.entity.RolePermissionRel;
import cn.roothub.service.RolePermissionRelService;

/**
 * <p></p>
 * @author: miansen.wang
 * @date: 2019-03-01
 */
@Service
public class RolePermissionRelServiceImpl implements RolePermissionRelService {

	@Autowired
	private RolePermissionRelDao rolePermissionRelDao;
	
	@Override
	public List<RolePermissionRel> getAllByRoleId(Integer roleId) {
		return rolePermissionRelDao.selectAllByRoleId(roleId);
	}

	@Override
	public List<RolePermissionRel> getAllByPermissionId(Integer permissionId) {
		return rolePermissionRelDao.selectAllByPermissionId(permissionId);
	}

	@Override
	public void saveBatch(Collection<? extends Serializable> rolePermissionRels) {
		rolePermissionRelDao.insertBatch(rolePermissionRels);
	}

	@Override
	public void removeByRoleId(Integer roleId) {
		rolePermissionRelDao.deleteByRoleId(roleId);
	}

	@Override
	public void removeByPermissionId(Integer permissionId) {
		rolePermissionRelDao.deleteByPermissionId(permissionId);
	}

}
