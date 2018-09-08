package jp.nmemoto.devstart.domain.service;

import jp.nmemoto.devstart.domain.model.Todo;
import jp.nmemoto.devstart.domain.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    private TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> list() {
        return todoRepository.findAll();
    }

    @Override
    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void patch(Long id, Todo todo) {
        Optional<Todo> nowTodo = todoRepository.findById(id);
        if (nowTodo.isPresent()) {
            Todo newTodo = nowTodo.get();
            if (todo.getName() != null) {
                newTodo.setName(todo.getName());
            }
            if (todo.getDone() != null) {
                newTodo.setDone(todo.getDone());
            }
            todoRepository.save(newTodo);
        } else {
          return;
        }
    }

    @Override
    public void remove(Long id) {
        todoRepository.deleteById(id);
    }
}
