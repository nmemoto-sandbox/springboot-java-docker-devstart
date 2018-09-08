package jp.nmemoto.devstart.domain.service;

import jp.nmemoto.devstart.domain.model.Todo;

import java.util.List;

public interface TodoService {
    public List<Todo> list();

    public Todo create(Todo todo);

    public void patch(Long id, Todo todo);

    public void remove(Long id);
}
