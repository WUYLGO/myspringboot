package com.wyl.research.designpattern.singleModelPattern;

/**
 * @Description: //TODO
 * @Date: 2020/6/5 11:28
 * @Idea: 枚举类的定义首先是枚举对象本身有几种,
 * 然后是枚举对象拥有的属性值;
 * 然后是属性值得get方法;
 * *****
 * 枚举遍历使用 枚举类.values的方式,返回枚举类对象数组,即可for循环遍历得到枚举对象;
 *
 */
public enum IdGeneratorEnum {
    AAAA("A_TYPE", "000"),
    BBBB("B_TYPE", "001"),
    CCCC("C_TYPE", "002");

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

        System.out.println(getMsgByCode("000"));

    }


    public static String getMsgByCode(String code) {
        for (IdGeneratorEnum idGeneratorEnum : IdGeneratorEnum.values()) {
            if (idGeneratorEnum.code.equals(code)) {
                return idGeneratorEnum.msg;
            }
        }
        throw new IllegalArgumentException();
    }

}
