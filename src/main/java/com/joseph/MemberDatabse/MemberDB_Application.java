package com.joseph.MemberDatabse;


import com.joseph.MemberDatabse.archive.Database;
import com.joseph.MemberDatabse.archive.HibernateDatabase;
import com.joseph.MemberDatabse.archive.UserPanel;
import com.joseph.MemberDatabse.archive.ClassicController;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project: Member Database with Hibernate
 * Developed by: Yousef Emadi
 * Date: APR 2021
 * Supported by: Java, Spring, H2
 */

@SpringBootApplication
@RestController
public class MemberDB_Application implements ApplicationContextAware {

    public static ApplicationContext ctx;
    @Override
    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }


//    @GetMapping("/hello")
//    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
//        return String.format("Hello %s!", name);
//    }

    public static void main(String[] args) {
        SpringApplication.run(MemberDB_Application.class, args);

//      Instantiation of main parts
        UserPanel userPanel = new UserPanel();
        Database list = new HibernateDatabase();
        ClassicController controller = new ClassicController();

        //config ClassicController
        controller.Configure(userPanel, list);

        while (true) {

            controller.mainController();

        }

    }


}
