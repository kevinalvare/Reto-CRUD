package co.com.sofka.crud.mapper;

import co.com.sofka.crud.entity.Todo;
import co.com.sofka.crud.dto.TodoDTO;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TodoMapper {
   @Mappings({
           @Mapping(source = "id", target = "id")

   })
     TodoDTO aTodoDto(Todo todo);
   Iterable<TodoDTO> toTodoDTOs (Iterable<Todo> todos);

   @InheritInverseConfiguration
   Todo toTodo(TodoDTO todoDTO);
}
