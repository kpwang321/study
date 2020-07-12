package cn.itcast.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kpwang
 * @create 2020-07-10 1:07
 */
public class StringToDateConverter implements Converter<String,Date>{

    @Override
    public Date convert(String s) {
        if (s==null){
            throw new RuntimeException("请您传入数据");
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("数据类型转换出现错误");
        }
    }
}
