//package demo.spring.restful.config;
//
//import java.io.IOException;
//
//import javax.sql.DataSource;
//
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.DefaultResourceLoader;
//import org.springframework.core.io.support.ResourcePatternResolver;
//import org.springframework.core.io.support.ResourcePatternUtils;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//// http://www.mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/
//// https://qiita.com/TEBASAKI/items/8925aa675f5e15b41967
//
//@Configuration
//@EnableTransactionManagement
//@MapperScan("demo.spring.restful.service")
//public class DatabaseDefaultConfig {
//
//	@Bean
//	public DataSource dataSource() {
//		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2) // HSQL or .H2 or .DERBY
//				.addScript("sql/schema.sql").addScript("sql/insert.sql").build();
//		return db;
//	}
//
//	@Bean
//  public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
//    SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
//    factory.setDataSource(dataSource());
//    ResourcePatternResolver resolver =
//        ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader());
//    // MyBatis のコンフィグレーションファイル
//    factory.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
//    // MyBatis で使用する SQL ファイル群(daoフォルダ内のサブフォルダ内も含んだ全てのxml)
//    factory.setMapperLocations(resolver.getResources("classpath:dao/**/*.xml"));
//
//    return factory;
//}
