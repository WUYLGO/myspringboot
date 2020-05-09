package com.example.demo.config;

import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class FullSQLInterceptor implements Interceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(FullSQLInterceptor.class);
    private Configuration configuration;
    private TypeHandlerRegistry typeHandlerRegistry;
    private static ThreadLocal<SimpleDateFormat> dateTimeFormatter = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler stmtHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaStmtHandler = SystemMetaObject.forObject(stmtHandler);
        BoundSql boundSql = (BoundSql) metaStmtHandler.getValue("delegate.boundSql");
        String sql = boundSql.getSql();
        List<String> parameters = new ArrayList<String>();
        Object parameterObject = metaStmtHandler.getValue("delegate.boundSql.parameterObject");
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        if (parameterMappings != null) {
            configuration = (Configuration) metaStmtHandler.getValue("delegate.configuration");
            MetaObject metaObject = parameterObject == null ? null : configuration
                    .newMetaObject(parameterObject);
            // 获取类型处理器注册器，类型处理器的功能是进行java类型和数据库类型的转换
            typeHandlerRegistry = configuration.getTypeHandlerRegistry();

            for (int i = 0; i < parameterMappings.size(); i++) {
                ParameterMapping parameterMapping = parameterMappings.get(i);
                if (parameterMapping.getMode() != ParameterMode.OUT) {
                    // 参数值
                    Object value;
                    String propertyName = parameterMapping.getProperty();
                    // 获取参数名称
                    if (boundSql.hasAdditionalParameter(propertyName)) {
                        // 获取参数值
                        value = boundSql.getAdditionalParameter(propertyName);
                    } else if (parameterObject == null) {
                        value = null;
                    } else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                        // 如果是单个值则直接赋值
                        value = parameterObject;
                    } else {
                        value = metaObject == null ? null : metaObject.getValue(propertyName);
                    }

                    if (value instanceof Number) {
                        parameters.add(String.valueOf(value));
                    } else {
                        StringBuilder builder = new StringBuilder();
                        builder.append("'");
                        if (value instanceof Date) {
                            builder.append(dateTimeFormatter.get().format((Date) value));
                        } else if (value instanceof String) {
                            builder.append(value);
                        }
                        builder.append("'");
                        parameters.add(builder.toString());
                    }
                }
            }
        }

        for (String value : parameters) {
            sql = sql.replaceFirst("\\?", value);
        }
        LOGGER.info("解析问号的sql===>" + sql);
        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
    }

}
