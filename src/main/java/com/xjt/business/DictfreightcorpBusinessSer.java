package com.xjt.business;

import com.xjt.entity.Dictfreightcorp;

import java.util.List;

public interface DictfreightcorpBusinessSer {

    void insertBatch(List<Dictfreightcorp> dictfreightcorps,Integer db );

    void deleteBatch(List<Dictfreightcorp> dictfreightcorps,Integer db);
}
