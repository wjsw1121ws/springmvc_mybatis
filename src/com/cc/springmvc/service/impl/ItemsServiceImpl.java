package com.cc.springmvc.service.impl;


import com.cc.springmvc.dao.ItemsMapper;
import com.cc.springmvc.pojo.Items;
import com.cc.springmvc.service.ItemsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @ClassName: ItemsServiceImpl
 * @Auther: changchun_wu
 * @Date: 2018/11/27 23:25
 * @Version: 1.0
 **/
@Service
@Transactional
public class ItemsServiceImpl implements ItemsService {
    @Resource
    private ItemsMapper itemsMapper;

    @Override
    public List<Items> selectAllItems() {
        return itemsMapper.selectAllItems();
    }

    @Override
    public Items selectItemByPrimaryKey(Integer id) {
        return itemsMapper.selectItemByPrimaryKey(id);
    }

    @Override
    public void updateItem(Items items) {
        itemsMapper.updateItem(items);
    }
}
