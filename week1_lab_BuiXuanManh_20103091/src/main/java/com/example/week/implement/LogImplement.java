package com.example.week.implement;

import com.example.week.models.Log;
import com.example.week.repositories.LogRepository;
import com.example.week.services.LogService;

import java.util.List;

public class LogImplement implements LogService {
//    @Inject
//    private LogRepository repository;
    private LogRepository repository;

    public LogImplement() {
        repository= new LogRepository();
    }

    @Override
    public boolean createLog(Log log) {
        return repository.createLog(log);
    }

    @Override
    public List<Log> find(String u) {
        return repository.findLogByA(u);
    }
}
