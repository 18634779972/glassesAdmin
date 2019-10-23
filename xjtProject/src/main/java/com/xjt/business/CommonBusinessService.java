package com.xjt.business;

import java.util.List;

public interface CommonBusinessService {

    void insertBatch(String tableName, List<String> values,Integer db);

    void deleteBatch(String tableName,String colName,List<String> values,Integer db);
}
