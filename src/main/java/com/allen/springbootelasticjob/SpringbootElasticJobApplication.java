package com.allen.springbootelasticjob;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author allen
 * @date 2020/6/25 16:10
 */
@MapperScan("com.allen.springbootelasticjob.project.dao")
@SpringBootApplication
public class SpringbootElasticJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootElasticJobApplication.class, args);
    }

}
