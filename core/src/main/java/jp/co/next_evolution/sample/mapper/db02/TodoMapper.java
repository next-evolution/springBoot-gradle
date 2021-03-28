package jp.co.next_evolution.sample.mapper.db02;

import jp.co.next_evolution.sample.dto.db02.Todo;

import java.util.List;

public interface TodoMapper {

    List<Todo> list(long userId);

    Todo select(long todoId, long userId);

    int insert(Todo todo);

    int update(Todo todo);

    int delete(Todo todo);

}
