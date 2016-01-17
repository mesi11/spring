package com.example.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Autowired
	DataSourceProperties datasourceproperties;
	DataSource dataSource;

	@ConfigurationProperties(prefix = DataSourceProperties.PREFIX)
	@Bean(destroyMethod = "close")
	DataSource realDataSource(){
		DataSourceBuilder factory = DataSourceBuilder
				.create(this.datasourceproperties.getClassLoader())
				.url(this.datasourceproperties.getUrl())
				.username(this.datasourceproperties.getUsername())
				.password(this.datasourceproperties.getPassword());
		this.dataSource = factory.build();
		return this.dataSource;
	}

//	@Primary
//	@Bean
//	DataSource dataSource(){
//		return new Log4jdbcProxyDataSource(this.dataSource);
//	}
}
