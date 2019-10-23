package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.entity.Dictcategory2;

import java.util.List;

public interface Dictcategory2Service {

    BaseResDto insertBatch(List<Dictcategory2> records,Integer db);

    BaseResDto deleteBatch(List<Dictcategory2> records,Integer db);

    BaseResDto queryAllCategory2(Dictcategory2 dictcategory2);
}
