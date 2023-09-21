package com.example.week.implement;

import com.example.week.models.Log;
import com.example.week.resources.LogRepository;
import com.example.week.services.LogService;
import jakarta.inject.Inject;

import java.util.List;

public class LogImplement implements LogService {
    @Inject
    private LogRepository repository;

    @Override
    public boolean createLog(Log log) {
        return repository.createLog(log);
    }

    @Override
    public List<Log> find(String u) {
        return repository.findLogByA(u);
    }
}
