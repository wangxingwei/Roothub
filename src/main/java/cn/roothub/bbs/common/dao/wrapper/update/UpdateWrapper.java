package cn.roothub.bbs.common.dao.wrapper.update;

import cn.roothub.bbs.common.dao.util.CollectionUtils;
import cn.roothub.bbs.common.dao.util.StringPool;
import cn.roothub.bbs.common.dao.wrapper.AbstractWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: miansen.wang
 * @Date: 2019/10/19 13:46
 */
public class UpdateWrapper<T> extends AbstractWrapper<T, UpdateWrapper<T>, String, Object> implements Update<UpdateWrapper<T>, String, Object> {

    /**
     * SQL 更新字段内容
     */
    private final List<String> sqlSet = new ArrayList<>();

    @Override
    public UpdateWrapper set(String column, Object value) {
        sqlSet.add(String.format("%s = %s", columnToString(column), formatSqlValue(value)));
        return typedThis;
    }


    @Override
    public String getSqlSet() {
        if (CollectionUtils.isEmpty(sqlSet)) {
            return null;
        }
        return String.join(StringPool.SPACE_COMMA_SPACE, sqlSet);
    }
}
