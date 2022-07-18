package com.example.stringcut.beans;

import com.trimmer.annotations.Trimmed;
import org.springframework.stereotype.Service;

@Service
@Trimmed
public class Printer {
    public void printValue (String value) {
        System.out.println(value);
    }

    public String getGreeting() {
        return "      Some greeting   ";
    }
}
