package com.dmm.task.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;

import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class Calendar {

    private final UsersRepository usersRepository;

    public Calendar(UsersRepository usersRepository) {
        this.taskRepository = taskRepository;
    }

    public MultiValueMap<LocalDate, Task> groupByDate(List<Task> tasks) {
        MultiValueMap<LocalDate, Task> map = new LinkedMultiValueMap<>();
        for (Task t : tasks) {
        
            LocalDate key = t.getDueAt().toLocalDate();
            map.add(key, t);
        }
        return map;
    }


    public MultiValueMap<LocalDate, Task> findMonthlyTasksGrouped(String name, YearMonth ym) {
        LocalDateTime from = ym.atDay(1).atStartOfDay();
        LocalDateTime to   = ym.plusMonths(1).atDay(1).atStartOfDay(); 

      
        List<Task> tasks = taskRepository.findByUserNameAndDueAtBetween(name, from, to);

        return groupByDate(tasks);
    }
}
