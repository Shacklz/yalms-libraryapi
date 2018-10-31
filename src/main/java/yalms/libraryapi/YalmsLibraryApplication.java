package yalms.libraryapi;


import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude={Neo4jDataAutoConfiguration.class})
@EnableNeo4jRepositories(basePackages = "yalms.libraryapi.repositories")
@EntityScan(basePackages = "yalms.libraryapi.entities")
@EnableTransactionManagement
public class YalmsLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(YalmsLibraryApplication.class, args);
    }

    @Value("${spring.data.neo4j.uri}")
    private String databaseUrl;

    @Value("${spring.data.neo4j.username}")
    private String userName;

    @Value("${spring.data.neo4j.password}")
    private String password;

    @Bean
    public SessionFactory sessionFactory() {
        org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder()
                .uri(databaseUrl)
                .credentials(userName, password)
                .build();
        return new SessionFactory(configuration,"yalms.libraryapi");
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }
}
