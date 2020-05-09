package com.example.demo.config;

import net.sf.jsqlparser.expression.JdbcParameter;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/10
 */

@Intercepts({//注意看这个大花括号，也就这说这里可以定义多个@Signature对多个地方拦截，都用这个拦截器
        @Signature(
                type = ResultSetHandler.class,//这是指拦截哪个接口
                method = "handleResultSets", //这个接口内的哪个方法名，不要拼错了
                args = {Statement.class})//这是拦截的方法的入参，按顺序写到这，不要多也不要少，如果方法重载，可是要通过方法名和入参来确定唯一的
        ,
        @Signature(type = Executor.class,
                method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
//@Component
public class SqlParser implements Interceptor {
    public SqlParser() {
        System.out.println("=============>");
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        final Map<String, Object> context = new HashMap<String, Object>();
        Object[] queryArgs = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) queryArgs[0];
        Object parameter = queryArgs[1];
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        String sql = boundSql.getSql();//获取到SQL ，可以进行调整
        String name = invocation.getMethod().getName();
        boundSql.setAdditionalParameter("aaaa", "123");
        for (Map.Entry<String, Object> entry : context.entrySet()) {
            boundSql.setAdditionalParameter(entry.getKey(), entry.getValue());
        }

        Select parse = (Select) CCJSqlParserUtil.parse(sql);
        PlainSelect selectBody = (PlainSelect) parse.getSelectBody();
        EqualsTo where = (EqualsTo) selectBody.getWhere();

        JdbcParameter jdbcParameter = new JdbcParameter();
        where.setRightExpression(jdbcParameter);
        return null;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
