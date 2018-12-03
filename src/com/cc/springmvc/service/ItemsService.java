package com.cc.springmvc.service;

import com.cc.springmvc.pojo.Items;

import java.util.List;

/**
 * @Description:
 * @ClassName: ItemsService
 * @Auther: changchun_wu
 * @Date: 2018/11/27 23:25
 * @Version: 1.0
 **/
public interface ItemsService {
    List<Items> selectAllItems();

    Items selectItemByPrimaryKey(Integer id);

    void updateItem(Items items);
}
