package jp.nmemoto.devstart.controller;

import jp.nmemoto.devstart.domain.model.Todo;
import jp.nmemoto.devstart.domain.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public List<Todo> hello() {
        return todoService.list();
    }

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody Todo todo) {
        todoService.create(todo);
    }


    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void patch(@PathVariable Long id, @RequestBody Todo todo) {
        todoService.patch(id, todo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        todoService.remove(id);
    }
}
