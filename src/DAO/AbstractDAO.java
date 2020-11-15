/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author ADMIN
 * @param <EntityType>
 * @param <KeyType>
 */
public abstract class AbstractDAO<EntityType,KeyType > {
    abstract public void insert(EntityType entity);
    abstract public void update(EntityType entity);
    abstract public void delete(KeyType id);
    abstract public EntityType selectById(KeyType id);
    abstract public List<EntityType> selectAll();
    abstract protected List<EntityType> selectBySql(String sqlString, Object...argsObjects);
    abstract protected EntityType readFromResultSet(ResultSet rs);    
}
