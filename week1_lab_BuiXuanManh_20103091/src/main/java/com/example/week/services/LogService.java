package com.example.week.services;

import com.example.week.models.Log;

import java.util.List;

public interface LogService {
    boolean createLog(Log log);
    List<Log> find(String u);
}
