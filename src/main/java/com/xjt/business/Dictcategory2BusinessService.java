package com.xjt.business;

import com.xjt.entity.Dictcategory2;

import java.util.List;

public interface Dictcategory2BusinessService {

    void insertBatch(List<Dictcategory2> records,Integer db);

    void deleteBatch(List<Dictcategory2> records,Integer db);
}
