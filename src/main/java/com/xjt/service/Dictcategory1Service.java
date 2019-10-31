package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.Dictcategory1ReqDto;

public interface Dictcategory1Service {

    BaseResDto insertOneCategory(Dictcategory1ReqDto reqDto);

    BaseResDto queryCateList(Dictcategory1ReqDto reqDto);

    BaseResDto queryOneCateInfo(String categoryid);
}
