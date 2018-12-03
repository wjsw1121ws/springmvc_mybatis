package com.cc.springmvc.dao;


import com.cc.springmvc.pojo.Items;

import java.util.List;

/**
 * @Description:
 * @ClassName: ItemsMapper
 * @Auther: changchun_wu
 * @Date: 2018/11/27 23:11
 * @Version: 1.0
 **/

public interface ItemsMapper {
    List<Items> selectAllItems();

    Items selectItemByPrimaryKey(Integer id);

    void updateItem(Items items);
}
