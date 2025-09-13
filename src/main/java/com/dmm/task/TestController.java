package com.dmm.task;

import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // タスク新規作成
    @PostMapping("/create")
    public String createTask(@ModelAttribute Task task) {
        taskService.save(task);
        // PRGパターン: リダイレクトで一覧に戻す
        return "redirect:/tasks";
    }

    // タスク編集
    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute Task task) {
        taskService.update(id, task);
        return "redirect:/tasks";
    }

    // タスク削除
    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return "redirect:/tasks";
    }
}