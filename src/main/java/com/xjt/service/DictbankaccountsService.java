package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.DictbankaccountsReqDto;

public interface DictbankaccountsService {

    BaseResDto insertBankInfo(DictbankaccountsReqDto reqDto);
}
