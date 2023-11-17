package com.acerstore.app.dao;

import java.util.List;

public abstract class AcerDAO<EntityType, KeyType>{
    public abstract void insert(EntityType e);
    public abstract void update(EntityType e);
    public abstract void delete(KeyType id);
    public abstract List<EntityType> selectAll();
    public abstract EntityType selectById(KeyType id);
    public abstract List<EntityType> selectBySql(String sql, Object...args);
}