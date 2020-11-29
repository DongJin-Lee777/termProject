package com.termproject.dongjin.config;

/*
@Configuration
@MapperScan(basePackages = "com.termproject.dongjin.mapper") //인터페이스 경로
public class DBConfig {
    @ConfigurationProperties(prefix = "spring.datasource") //spring.datasource
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception { //DataSource설정인듯? (빈 의존성 주입)

        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*.xml") //xml파일
        );
        return sessionFactory.getObject();
    }

    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}*/