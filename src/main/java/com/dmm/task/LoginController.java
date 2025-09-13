package com.example.task;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/loginForm")
	String loginForm() {
		return "login";
	}
	
	@GetMapping("/calendar")
	public String posts(Model model) {
		// 逆順で投稿をすべて取得する
		List<Posts> list = repo.findAll(Sort.by(Sort.Direction.DESC, "id"));
//    Collections.reverse(list); //普通に取得してこちらの処理でもOK
		model.addAttribute("calendar", list);
		PostForm postForm = new PostForm();
		model.addAttribute("postForm", postForm);
		return "/calendar";
	}
	
	@GetMapping("/calendar")
    public String calendar(Model model, Principal principal) {
        YearMonth ym = YearMonth.now();
        LocalDateTime from = ym.atDay(1).atStartOfDay();
        LocalDateTime to   = ym.plusMonths(1).atDay(1).atStartOfDay();

        // principal.getName() → ログインユーザーのID（または名前）
        List<Task> tasks = taskRepository.findByUser_UserIdAndDueAtBetween(
            principal.getName(), from, to
        );

        model.addAttribute("ym", ym);
        model.addAttribute("tasks", tasks);
        return "calendar";
	} 
	
