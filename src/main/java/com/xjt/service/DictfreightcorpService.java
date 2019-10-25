package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.entity.Dictfreightcorp;

import java.util.List;

public interface DictfreightcorpService {

    BaseResDto insertBatch(List<Dictfreightcorp> dictfreightcorps,Integer db);

    BaseResDto deleteBatch(List<Dictfreightcorp> dictfreightcorps,Integer db);

    BaseResDto queryAllCorp(Dictfreightcorp dictfreightcorp);
}
