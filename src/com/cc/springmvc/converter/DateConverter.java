package com.cc.springmvc.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @ClassName: DateConverter
 * @Auther: changchun_wu
 * @Date: 2018/11/30 0:09
 * @Version: 1.0
 **/
public class DateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dateFormat.parse(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
