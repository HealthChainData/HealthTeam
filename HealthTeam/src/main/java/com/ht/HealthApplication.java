package com.ht;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@EnableTransactionManagement
@ServletComponentScan
@MapperScan("com.ht.*.dao")
@SpringBootApplication
@EnableCaching
public class HealthApplication {
    public static void main(String[] args) {
        SpringApplication.run(HealthApplication.class, args);
        System.err.println("////////////////////////////////////////////////////////////////////\n" + 
        		"//                          _ooOoo_                               //\n" + 
        		"//                         o8888888o                              //\n" + 
        		"//                         88\" . \"88                              //\n" + 
        		"//                         (| ^_^ |)                              //\n" + 
        		"//                         O\\  =  /O                              //\n" + 
        		"//                      ____/`---'\\____                           //\n" + 
        		"//                    .'  \\\\|     |//  `.                         //\n" + 
        		"//                   /  \\\\|||  :  |||//  \\                        //\n" + 
        		"//                  /  _||||| -:- |||||-  \\                       //\n" + 
        		"//                  |   | \\\\\\  -  /// |   |                       //\n" + 
        		"//                  | \\_|  ''\\---/''  |   |                       //\n" + 
        		"//                  \\  .-\\__  `-`  ___/-. /                       //\n" + 
        		"//                ___`. .'  /--.--\\  `. . ___                     //\n" + 
        		"//              .\"\" '<  `.___\\_<|>_/___.'  >'\"\".                  //\n" + 
        		"//            | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |                 //\n" + 
        		"//            \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /                 //\n" + 
        		"//      ========`-.____`-.___\\_____/___.-`____.-'========         //\n" + 
        		"//                           `=---='                              //\n" + 
        		"//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //\n" + 
        		"//         佛祖保佑       永不宕机     永无bug                  //\n" + 
        		"////////////////////////////////////////////////////////////////////\n" + 
        		"--------------------- \n" 
        		);
    }
}
