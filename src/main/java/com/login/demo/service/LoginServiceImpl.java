package com.login.demo.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import com.login.demo.utility.CsvExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.demo.entity.LoginFailure;
import com.login.demo.repository.LoginFailureRepository;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginFailureRepository loginFailureRepository;

    @Autowired
    private CsvExporter csvExporter;

    @Override
    public void recordFailedLogin(String username) {
        LoginFailure loginFailure = new LoginFailure(username, LocalDateTime.now());
        loginFailureRepository.save(loginFailure);
    }

    @Override
    public void exportFailedLoginsToCsv() throws IOException {
        List<LoginFailure> failedLogins = loginFailureRepository.findAll();
        csvExporter.exportToCsv(failedLogins, "failed-logins.csv");
    }
}