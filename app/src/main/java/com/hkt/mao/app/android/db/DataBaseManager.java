package com.hkt.mao.app.android.db;

import android.content.Context;

import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;

import java.util.List;

public class DataBaseManager {
    private static DataBaseManager manager;
    private static final String DB_NAME = "maotuan.db";
    private LiteOrm liteOrm;

    private DataBaseManager(Context context) {
        if (liteOrm == null) {
            liteOrm = LiteOrm.newSingleInstance(context, DB_NAME);
        }
    }

    public static DataBaseManager getInstance(Context context) {
        context = context.getApplicationContext();
        if (manager == null) {
            synchronized (DataBaseManager.class) {
                if (manager == null) {
                    manager = new DataBaseManager(context);
                }
            }
        }
        return manager;
    }

    /**
     * 插入一条记录
     */
    public <T> long insert(T t) {
        return liteOrm.save(t);
    }

    /**
     * 插入所有记录
     */
    public <T> void insertAll(List<T> list) {
        liteOrm.save(list);
    }


    public <T> long update(T t) {
        return liteOrm.save(t);
    }


    /**
     * 查询所有数据
     */
    public <T> int updateAll(List<T> list) {
        return liteOrm.update(list);
    }

    /**
     * 根据id查询
     */
    public <T> T query(long id, Class<T> clazz) {
        return liteOrm.queryById(id, clazz);
    }

    /**
     * 查询所有
     */
    public <T> List<T> queryAll(Class<T> cla) {
        return liteOrm.query(cla);
    }

    /**
     * 查询  某字段 等于 Value的值
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> queryByWhere(Class<T> cla, String field, String[] value) {
        return liteOrm.query(new QueryBuilder(cla).where(field + "=?", value));
    }


    public <T> List<T> queryByWhere(Class<T> cla, String field) {
        return liteOrm.query(new QueryBuilder(cla).appendOrderDescBy(field).limit("7"));
    }


    /**
     * 查询  某字段 等于 Value的值  可以指定从1-20，就是分页
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> queryByWhereLength(Class<T> cla, String field, String[] value, int start, int length) {
        return liteOrm.query(new QueryBuilder(cla).where(field + "=?", value).limit(start, length));
    }

    /**
     * 删除一个数据
     */
    public <T> void delete(T t) {
        liteOrm.delete(t);
    }

    /**
     * 删除所有数据
     */
    public <T> void deleteAll(Class<T> clazz) {
        liteOrm.deleteAll(clazz);
    }

    /**
     * 删除集合中的数据
     */
    public <T> void deleteList(List<T> list) {
        liteOrm.delete(list);
    }

    /**
     * 删除数据库
     */
    public void deleteDatabase() {
        liteOrm.deleteDatabase();
    }

}
