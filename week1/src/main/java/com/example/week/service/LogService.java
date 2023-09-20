package com.example.week.service;

import com.example.week.models.Account;
import com.example.week.models.Log;

import java.util.List;

public interface LogService {
    boolean createLog(Log log);
    List<Log> find(String u);
}
