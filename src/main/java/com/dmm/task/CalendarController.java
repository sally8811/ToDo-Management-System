package com.dmm.task;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

public class CalendarController {
	
	@GetMapping("/home")
	public String main() {
		
		List<List<LocalDate>> month = new ArrayList<>();
		
		List<LocalDate> weekDates = new ArrayList<>();

		LocalDate d = LocalDate.now().withDayOfMonth(1);
	        
		DayOfWeek w = d.getDayOfWeek();
	        
		int dayValue = w.getValue();
		
        LocalDate previousDate = d.minusDays(dayValue);    
	
	   

	        for (int i = 0; i < 7; i++) {
	            weekDates.add(d.plusDays(i));
	            
	            if (weekDates.size() == 7) {
	                month.add(weekDates);
	                weekDates = new ArrayList<>(); 
	            }
	            
	            for (int i = 0; i < 7; i++) {
		            weekDates.add(d.plusDays(i));
	              
	                if (.getValue() == DayOfWeek.SATURDAY) {
	                    month.add(weekDates);
	                    weekDates = new ArrayList<>();
	                }
	            }
	         
	            if (!weekDates.isEmpty()) {
	                int lastDow = lastDay.getDayOfWeek().getValue(); 
	                int pad = (w.SATURDAY.getValue() - lastDow + 7) % 7; 

	                for (int i = 1; i <= pad; i++) {
	                    weekDates.add(lastDay.plusDays(i)); 
	                }

	                month.add(weekDates);
	            }  
	        
	            
	   

	            }
	        }
	}
