package com.example.stringcut.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Trimmed
public class PrinterUser {
    @Autowired
    Printer printer;

    public void doPrinting() {
        printer.printValue("       Hello!        ");
    }

    public void printGreeting() {
        System.out.println(printer.getGreeting());
    }
}
