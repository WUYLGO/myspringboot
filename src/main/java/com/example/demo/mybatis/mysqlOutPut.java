package com.example.demo.mybatis;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import org.apache.ibatis.logging.Log;

public class mysqlOutPut implements Log {
    public mysqlOutPut(String clazz) {
    }

    public boolean isDebugEnabled() {
        return true;
    }

    public boolean isTraceEnabled() {
        return true;
    }

    public void error(String s, Throwable e) {
        System.err.println(s);
        e.printStackTrace(System.err);
    }

    public void error(String s) {
        System.err.println(s);
    }

    public void debug(String s) {
        System.out.println(s);
        String replaceAll = s.replaceAll("==>  Preparing: ", "");
    }


    private String sql = "";
    private String param = "";


    public void trace(String s) {
        System.out.println(s);
    }

    public void warn(String s) {
        System.out.println(s);
    }
}