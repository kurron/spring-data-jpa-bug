package org.example

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement

import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

/**
 * Spring context for the test.
 */
@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
class TestConfiguration {

    @Bean
    public DataSource dataSource() {

        def builder = new EmbeddedDatabaseBuilder()
        builder.setType( EmbeddedDatabaseType.HSQL ).build()
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {

        def vendorAdapter = new HibernateJpaVendorAdapter()
        vendorAdapter.setGenerateDdl( true )

        def factory = new LocalContainerEntityManagerFactoryBean()
        factory.setJpaVendorAdapter( vendorAdapter )
        factory.setPackagesToScan( 'org.example' )
        factory.setDataSource(dataSource())
        factory.afterPropertiesSet()

        factory.getObject()
    }

    @Bean
    public PlatformTransactionManager transactionManager() {

        def txManager = new JpaTransactionManager()
        txManager.setEntityManagerFactory( entityManagerFactory() )
        txManager
    }
}
