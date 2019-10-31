package com.xjt.business;

import com.xjt.dto.Dictcategory1ReqDto;
import com.xjt.entity.Dictcategory2;

import java.util.List;

public interface Dictcategory2BusinessService {

    void insertBatch(List<Dictcategory2> records);

    void deleteTwoCate(Dictcategory1ReqDto reqDto);


}
