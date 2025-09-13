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
		
		List<LocalDate> weekDates = new ArrayList<>();

		LocalDate d = LocalDate.now().withDayOfMonth(1);
	        
		DayOfWeek w = d.getDayOfWeek();
	        
		int dayValue = dayOfWeek.getValue();
        LocalDate previousDate = firstDayOfMonth.minusDays(dayValue);    
	
	   

	        for (int i = 0; i < 7; i++) {
	            weekDates.add(startDate.plusDays(i));
	            
	            if (weekDates.size() == 7) {
	                month.add(weekDates);
	                weekDates = new ArrayList<>(); 
	            }
	            
	            for (int i = 0; i < 7; i++) {
		            weekDates.add(startDate.plusDays(i));
	              
	                if (firstDayOfMonth.getDayOfWeek() == dayOfWeek.SATURDAY) {
	                    month.add(weekDates);
	                    weekDates = new ArrayList<>();
	                }
	            }
	         
	            if (!weekDates.isEmpty()) {
	                int lastDow = lastDay.getDayOfWeek().getValue(); 
	                int pad = (dayOfWeek.SATURDAY.getValue() - lastDow + 7) % 7; 

	                for (int i = 1; i <= pad; i++) {
	                    weekDates.add(lastDay.plusDays(i)); 
	                }

	                month.add(weekDates);
	            }  
	        
	            
	            
	            for (int i = 1; i <= lastDay; i++) {
	    			// 曜日を取得
	    			DayOfWeek w = d.getDayOfWeek();
	    			weekDates.add(d.plusDays(i));
	    			// 土曜日かどうかを判定
	    			if (w == DayOfWeek.SATURDAY) {
	    				month.add(weekDates);
	                    weekDates = new ArrayList<>();
	    			}

	    			d = d.plusDays(1);

}
