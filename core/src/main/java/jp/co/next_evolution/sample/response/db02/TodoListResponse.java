package jp.co.next_evolution.sample.response.db02;

import jp.co.next_evolution.sample.dto.db02.Todo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TodoListResponse {

    private List<Todo> todoList;

}
