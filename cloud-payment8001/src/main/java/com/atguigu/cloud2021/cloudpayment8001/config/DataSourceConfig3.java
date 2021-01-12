package com.atguigu.cloud2021.cloudpayment8001.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author 桂贤松
 * @project_name：cloud2021
 * @product_name：IntelliJ IDEA
 * @date：2021/1/12 16:25 周二
 */
@Configuration
@MapperScan(basePackages = {"com.atguigu.cloud2021.cloudpayment8001.dao.db2"},sqlSessionFactoryRef = "db3SqlSessionFactory")
public class DataSourceConfig3 {

//    @Primary//表示该数据源是默认数据源
    @Bean("db3DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db3")//从application.yml读取数据
    public DataSource getDb3DataSource(){
        return DataSourceBuilder.create().build();
    }

//    @Primary
    @Bean("db3SqlSessionFactory")
    public SqlSessionFactory db3SqlSessionFactory(@Qualifier("db3DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/db2/*.xml"));
        return bean.getObject();
    }

//    @Primary
    @Bean("db3SqlSessionTemplate")
    public SqlSessionTemplate db3SqlSessionTemplate(@Qualifier("db3SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
