package cn.roothub.bbs.common.dao.enums;

/**
 * 常用的增删改查方法
 * @Author: miansen.wang
 * @Date: 2019/9/4 22:14
 */
public enum SqlMethod {

    /**
     * 查询
     */
    SELECT_BY_ID("selectById", "根据 ID 查询一条数据", "<script>\nSELECT %s FROM %s WHERE %s = #{%s}\n</script>"),

    SELECT_BATCH_BY_IDS("selectBatchIds", "根据 ID 集合，批量查询多条数据", "<script>\nSELECT %s FROM %s WHERE %s IN (%s)\n</script>"),

    SELECT_ONE("selectOne", "查询满足条件的一条数据", "<script>\nSELECT %s FROM %s %s\n</script>"),

    SELECT_LIST("selectList", "查询满足条件的多条数据", "<script>\nSELECT %s FROM %s %s\n</script>"),

    SELECT_COUNT("selectCount", "查询满足条件的总记录数", "<script>\nSELECT COUNT(1) FROM %s %s\n</script>"),

    /**
     * 插入
     */
    INSERT("insert", "插入一条数据", "<script>\nINSERT INTO %s %s VALUES %s\n</script>"),

    /**
     * 更新
     */
    UPDATE_BY_ID("updateById", "根据 ID 更新一条数据", "<script>\nUPDATE %s %s WHERE %s = %s\n</script>"),

    UPDATE("update", "更新满足条件的一条数据", "<script>\nUPDATE %s %s %s %s\n</script>");

    private final String method;

    private final String desc;

    private final String sql;

    private SqlMethod(String method, String desc, String sql) {
        this.method = method;
        this.desc = desc;
        this.sql = sql;
    }

    public String getMethod() {
        return method;
    }

    public String getDesc() {
        return desc;
    }

    public String getSql() {
        return sql;
    }
}
