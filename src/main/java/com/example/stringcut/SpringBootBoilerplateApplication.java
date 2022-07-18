package com.example.stringcut;

import com.example.stringcut.beans.PrinterUser;
import com.trimmer.annotations.EnableStringTrimming;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableStringTrimming
public class SpringBootBoilerplateApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(SpringBootBoilerplateApplication.class, args);
        var printerUser = context.getBean(PrinterUser.class);
        printerUser.doPrinting();
        printerUser.printGreeting();
    }

}
