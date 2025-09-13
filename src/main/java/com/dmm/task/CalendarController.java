package com.dmm.task;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.YearMonth;

import org.springframework.scheduling.config.Task;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class CalendarController {
	
	@GetMapping("/home")
	public String main() {
		
		List<List<LocalDate>> month = new ArrayList<>();
	}

		  LocalDate startDate = LocalDate.now();

	        List<LocalDate> weekDates = new ArrayList<>();

	     
	        for (int i = 0; i < 7; i++) {
	            weekDates.add(startDate.plusDays(i));
	        }
	        
	        LocalDate firstDay = today.withDayOfMonth(1);
	        
	        DayOfWeek dayOfWeek = firstDayOfMonth.getDayOfWeek();
	        
	        int dayValue = dayOfWeek.getValue();
	        LocalDate previousDate = firstDayOfMonth.minusDays(dayValue);
	

}
