package com.jackie.hellojackie.util;

import com.alibaba.fastjson.JSON;
import com.yx.eweb.main.EWebContext;
import com.yx.eweb.main.EWebRequestDTO;
import com.yx.eweb.main.EWebServletContext;
import org.codehaus.jackson.map.util.BeanUtil;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/5/23
 */
public class ParamUtil {
    /**
     * 获取入参DTO
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T instance(Class<T> clazz){
        EWebContext eWebContext = EWebServletContext.getEWebContext();
        EWebRequestDTO eWebRequestDTO = (EWebRequestDTO) eWebContext.getParam();
        Map<String, Object> param = eWebRequestDTO.getRequestParam();
        // 通过该类 可以把一个map转成一个对象
        return JSON.parseObject(JSON.toJSONString(param), clazz);
    }

    /**
     * 根据键值，获取对应的value
     * @param key
     * @return
     */
    public static String value(String key){
        // eweb上下文
        EWebContext eWebContext = EWebServletContext.getEWebContext();
        // 获取传入过来的值
        return  (String) eWebContext.get(key);
    }
}
