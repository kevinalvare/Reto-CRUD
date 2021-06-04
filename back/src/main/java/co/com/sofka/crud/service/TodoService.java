package co.com.sofka.crud.service;

import co.com.sofka.crud.entity.Todo;
import co.com.sofka.crud.repository.TodoRepository;

import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;
    @Autowired
   private TodoMapper mapper;

    public Iterable<TodoDTO> list(){
        Iterable<Todo> todos= repository.findAll();
        return mapper.toTodoDTOs(todos);
    }

    public TodoDTO save(TodoDTO todoDTO){
        Todo todo = mapper.toTodo(todoDTO);
        return mapper.aTodoDto(repository.save(todo));
    }

    public void delete(Long id){
        repository.delete(get(id));
    }

    public Todo get(Long id){
         return repository.findById(id).orElseThrow();
    }

}
