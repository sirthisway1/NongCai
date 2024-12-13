package cainong.jimi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("cainong.jimi.mapper")
public class JimiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JimiApplication.class, args);
    }

}
