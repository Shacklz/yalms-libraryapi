package yalms.libraryapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableNeo4jRepositories(basePackages = "yalms.libraryapi.repositories")
@EnableTransactionManagement
public class YalmsLibraryApplication {
    public static void main(String[] args) {
        SpringApplication.run(YalmsLibraryApplication.class, args);
    }
}
