package com.example.demo.config;

import com.sun.javafx.collections.MappingChange;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/10
 */
public class ParseUtil {

    /**
     * 替换sql中的占位参数
     */
    public static String getSql(String indexImpl, LinkedHashMap<String, String> params) {
        //匹配#{*}格式的占位参数
        Pattern pattern = Pattern.compile("#\\{.*?\\}");
        Matcher matcher = pattern.matcher(indexImpl);

        while (matcher.find()) {
            String paraStr = matcher.group();
            int i = indexImpl.indexOf(paraStr);
            String paramName = paraStr.replaceAll("#\\{", "").replaceAll("}", "").trim();
            if (params != null && i != -1) {
                String param = params.get(paramName);
                if (param == null) {
                    param = "";
                }
                indexImpl = indexImpl.replace(paraStr, "'" + param + "'");
            }

        }
        //类似mybatis # 与$的区别
        Pattern pattern1 = Pattern.compile("\\$\\{.*?\\}");
        Matcher matcher1 = pattern1.matcher(indexImpl);
        while (matcher1.find()) {
            String paraStr = matcher1.group();
            int i = indexImpl.indexOf(paraStr);
            String paramName = paraStr.replaceAll("\\$\\{", "").replaceAll("}", "").trim();
            if (params != null && i != -1) {
                String param = params.get(paramName);
                if (param == null) {
                    param = "";
                }
                indexImpl = indexImpl.replace(paraStr, param);
            }

        }
        return indexImpl;
    }

    /**
     * sql查询条件处理
     *
     * @param str
     * @param map
     * @return
     */
    public static String trimParam(String str, Map<String, String> map) {
        if (str == null) {
            return null;
        }
        for (String key : map.keySet()) {
            String reg = "(<ifnull)[\\s]+(column=\"" + key + "\")[\\s]*(>)[\\S\\s]*(</ifnull)[\\s]+(column=\"" + key + "\")[\\s]*(>)";
            String value = map.get(key);
            if (StringUtils.isEmpty(value)) {
                str = str.trim().replaceAll(reg, "");
            }
        }
        str = str.replaceAll("(<ifnull)[\\s]+(column=\")[a-zA-Z_]*(\")[\\s]*(>)", "");
        str = str.replaceAll("(</ifnull)[\\s]+(column=\")[a-zA-Z_]*(\")[\\s]*(>)", "");
        return str;
    }


}
