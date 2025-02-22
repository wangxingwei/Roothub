package cn.roothub.bbs.common.dao.injector;

import cn.roothub.bbs.common.dao.injector.methods.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 默认的 SQL 注入器，提供了基本的 SQL 注入
 */
public class DefaultSqlInjector extends AbstractSqlInjector{

    @Override
    public List<AbstractMethod> getMethodList() {
        return (List)Stream.of(
                new Insert(),
                new SelectOne(),
                new SelectList(),
                new SelectById(),
                new SelectBatchIds(),
                new SelectCount(),
                new UpdateById()
        ).collect(Collectors.toList());
    }
}
