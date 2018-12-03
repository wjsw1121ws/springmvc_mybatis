package com.cc.springmvc.pojo;

import java.util.List;

/**
 * @Description:
 * @ClassName: QueryVo
 * @Auther: changchun_wu
 * @Date: 2018/11/28 2:16
 * @Version: 1.0
 **/
public class QueryVo {
    private Items items;
    private Integer[] ids;
    private List<Items> itemsList;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public List<Items> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Items> itemsList) {
        this.itemsList = itemsList;
    }
}
