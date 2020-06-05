package com.wyl.research.designpattern.singleModelPattern;

/**
 * @Description: //TODO
 * @Date: 2020/6/5 11:28
 * @Idea: 枚举类的定义首先是枚举对象本身有几种,
 * 然后是枚举对象拥有的属性值;
 * 然后是属性值得get方法;
 */
public enum IdGeneratorEnum {
    AAAA("", "000"),
    BBBB("", "001"),
    CCCC("", "002");

    private String msg;
    private String code;

    IdGeneratorEnum(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static void main(String[] args) {
        String code = IdGeneratorEnum.AAAA.getCode();
        System.out.println(code);
    }
}
