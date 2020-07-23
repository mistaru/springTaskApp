package kg.demir.taskapp.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import kg.demir.taskapp.entity.Task;
import kg.demir.taskapp.service.ITaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TaskController {

    private final ITaskService taskService;

    public TaskController(@NotNull ITaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("listTask", taskService.findAll());
        return "index";
    }

    @RequestMapping(value = "newTask", method = RequestMethod.GET)
    public String newTask (Model model) {

        model.addAttribute("task", new Task());
        return "task";
    }

    @RequestMapping(value = "/saveTask", method = RequestMethod.POST)
    public String saveTask(@ModelAttribute("task")@Valid Task task, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("tasks", taskService.findAll());
            return "task";
        }
        taskService.save(task);
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteTask/{id}", method = RequestMethod.GET)
    public String deleteTask(@PathVariable("id") Long id) {

        if (id != null) {
            taskService.deleteById(id);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/editTask/{id}", method = RequestMethod.GET)
    public ModelAndView editTask(@PathVariable("id") Long id) {

        return new ModelAndView("editTask")
                .addObject("task", taskService.get(id));
    }

    @RequestMapping(value = "/updateTask", method = RequestMethod.POST)
    public String updateTask(@Valid Task task) {

        if (task != null) {
            taskService.update(task);
        }
        return "redirect:/";
    }
}
