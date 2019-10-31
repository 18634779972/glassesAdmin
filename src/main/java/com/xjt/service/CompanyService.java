package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.CompanyReqDto;

public interface CompanyService {

    BaseResDto insertCompany(CompanyReqDto reqDto);

    BaseResDto queryCompanyList(CompanyReqDto reqDto);

    BaseResDto queryCompanyInfo(CompanyReqDto reqDto);
}
