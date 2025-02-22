package cn.roothub.bbs.common.dao.register;

import cn.roothub.bbs.common.dao.BaseMapper;
import cn.roothub.bbs.common.dao.builder.BaseMapperBuilder;

import org.apache.ibatis.session.Configuration;

import java.util.List;

/**
 * Mapper 注册与绑定类，主要的作用是为 IBaseDao 的导出接口注入通用的 SQL
 * @Author: miansen.wang
 * @Date: 2019/8/29 22:36
 */
public class BaseMapperRegistry {

    /**
     * Mybatis 的配置信息，存储了所有 Mapper 注册与绑定的信息
     */
    private Configuration configuration;

    public BaseMapperRegistry(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * 注册 Mapper
     * @param mappers
     */
    public void addMappers(List<Class<?>> mappers) {
        mappers.forEach(m -> {
            // mapper 必须是接口且继承 IBaseDao，才能注入
            if (!m.isInterface() || !BaseMapper.class.isAssignableFrom(m)){
                return;
            }
            BaseMapperBuilder myBatisMapperAnnotationBuilder = new BaseMapperBuilder(configuration, m);
            myBatisMapperAnnotationBuilder.parse();
        });
    }

}
