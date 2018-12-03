
package com.cc.springmvc.controller;

import com.cc.springmvc.pojo.Items;
import com.cc.springmvc.pojo.QueryVo;
import com.cc.springmvc.service.ItemsService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @Description:
 * @ClassName: ItemsController
 * @Auther: changchun_wu
 * @Date: 2018/11/27 23:25
 * @Version: 1.0
 **/

@Controller
/*@RequestMapping(value = "/item")*/ //设置全局的请求路径前缀
public class ItemsController {
    @Resource
    private ItemsService itemsService;

    /**
     * @Author: changchun_wu
     * @Date: 2018/11/28 1:06
     * @Description: 查询所有的订单
     * ModelAndView 既可以返回数据也可以返回视图路径
     * String  只能返回视图路径,通过Model带回数据     ---官方推荐,符合解耦和思想
     * void     通过Model带回数据, 通过request,response返回视图, 多用于ajax异步请求
     **/
    @RequestMapping(value = {"/itemlist.action","/itemlist2.action"})//多请求
    public ModelAndView itemList() throws Exception{
        //未知异常
        //Integer i = 1/0;
        List<Items> items = itemsService.selectAllItems();
        //自定义异常
        /*if(null==null){
            throw new MessageException("商品信息不能为空!");
        }*/
        ModelAndView mav = new ModelAndView();
        mav.addObject("itemList",items);
        mav.setViewName("jsp/itemList");
        return mav;
    }
    /*@RequestMapping(value = {"/itemlist.action","/itemlist2.action"})//多请求
    public String itemlist(Model model){
        List<Items> items = itemsService.selectAllItems();
        model.addAttribute("itemList",items);
        return "jsp/itemList";
    }*/
    /*@RequestMapping(value = {"/itemlist.action","/itemlist2.action"})//多请求
    public void itemlist(Model model,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<Items> items = itemsService.selectAllItems();
        model.addAttribute("itemList",items);
        request.getRequestDispatcher("jsp/itemList").forward(request,response);
    }*/


    /**
     * @Author: changchun_wu
     * @Date: 2018/11/28 1:06
     * @Description: 订单编辑
     **/
    @RequestMapping(value = "/itemEdit.action")
    //springmvc支持基本类型
    public ModelAndView itemEdit(Integer id, HttpServletRequest request,
                                 HttpServletResponse response, HttpSession session, Model model){
        Items items = itemsService.selectItemByPrimaryKey(id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("item",items);
        mav.setViewName("jsp/editItem");
        return mav;
    }

    @RequestMapping(value = "/updateItem.action")
    //public ModelAndView updateItem(Items items){
    public String updateItem(QueryVo vo, MultipartFile pictureFile) throws IOException {//使用pojo类型封装数据
        //生成32位的uuid
        String uuidName = UUID.randomUUID().toString();
        String name = uuidName.replaceAll("-", "").toUpperCase();
        String extension = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
        String fullPath = "D:\\upload\\"+name+"."+extension;
        pictureFile.transferTo(new File(fullPath));
        vo.getItems().setPic(fullPath);
        itemsService.updateItem(vo.getItems());
        return "redirect:/itemlist.action";//重定向
        //return "forward:/itemlist.action";      //请求转发
    }
    /**
     * @Author: changchun_wu
     * @Date: 2018/11/30 0:48
     * @Description: 删除多个记录
     **/
    /*@RequestMapping("/deleteItem.action")
    public ModelAndView deleteItem(Integer[] ids){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("jsp/success");
        return mav;
    }*/

    /**
     * @Author: changchun_wu
     * @Date: 2018/11/30 0:52
     * @Description: 使用QueryVo封装数据
     **/
    /*@RequestMapping("/deleteItem.action")
    public ModelAndView deleteItem(QueryVo vo){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("jsp/success");
        return mav;
    }*/

    /**
     * @Author: changchun_wu
     * @Date: 2018/11/30 1:06
     * @Description: 参数为封装了list集合的QueryVo对象
     * springmvc未提供针对list的数据的处理
     **/
    @RequestMapping(value = "/updateItems.action",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView updateItems(QueryVo vo){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("jsp/success");
        return mav;
    }

    /**
     * @Author: changchun_wu
     * @Date: 2018/12/2 19:38
     * @Description: json数据交互
     **/
    @RequestMapping(value = "/json.action")
    public @ResponseBody
    Items json(@RequestBody Items items){
        return items;
    }

    /**
     * @Author: changchun_wu
     * @Date: 2018/12/2 19:48
     * @Description: id.action的使用
     **/
    @RequestMapping(value = "/{id}.action")
    //springmvc支持基本类型
    public ModelAndView itemEdit1(@PathVariable Integer id, HttpServletRequest request,
                                  HttpServletResponse response, HttpSession session, Model model){
        Items items = itemsService.selectItemByPrimaryKey(id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("item",items);
        mav.setViewName("jsp/editItem");
        return mav;
    }

    /**
     * @Author: changchun_wu
     * @Date: 2018/12/3 0:51
     * @Description: 去登陆界面登陆界面
     **/
    @RequestMapping(value = "login.action",method = RequestMethod.GET)
    public String login(){
        return "jsp/login";
    }

    /**
     * @Author: changchun_wu
     * @Date: 2018/12/3 0:51
     * @Description: 去登陆界面登陆界面
     **/
    @RequestMapping(value = "login.action",method = RequestMethod.POST)
    public String login1(String username,HttpSession session){
        session.setAttribute("USER_SESSION",username);

        return "redirect:/itemlist.action";
    }
}