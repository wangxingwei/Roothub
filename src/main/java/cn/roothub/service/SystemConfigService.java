package cn.roothub.service;

import java.util.List;
import java.util.Map;
import cn.roothub.entity.SystemConfig;

/**
 * <p></p>
 * @author: miansen.wang
 * @date: 2019-03-07
 */
public interface SystemConfigService {

	/**
	 * 获取所有的系统配置
	 * @return
	 */
	List<SystemConfig> getAll();
	
	/**
	 * 获取所有的系统配置，格式为Map，key是父节点的description，value是对应的子节点
	 * @return
	 */
	Map<String,Object> getAllMap();
}
