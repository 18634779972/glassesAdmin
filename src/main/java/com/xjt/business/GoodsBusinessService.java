package com.xjt.business;

import com.xjt.entity.Goods;
import com.xjt.entity.Goodspicturemgt;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GoodsBusinessService {

    void insertGoods(Goods goods, List<Goodspicturemgt> goodspicturemgts);
}
