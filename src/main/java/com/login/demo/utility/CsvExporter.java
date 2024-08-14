package com.login.demo.utility;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import com.login.demo.entity.LoginFailure;

@Component
public class CsvExporter {

    public void exportToCsv(List<LoginFailure> loginFailures, String filePath) throws IOException {
        try (FileWriter out = new FileWriter(filePath);
             CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader("Username", "FailedLoginTime"))) {

            for (LoginFailure loginFailure : loginFailures) {
                printer.printRecord(loginFailure.getUsername(), loginFailure.getFailedLoginTime());
            }
        }
    }
}