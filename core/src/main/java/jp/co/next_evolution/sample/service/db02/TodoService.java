package jp.co.next_evolution.sample.service.db02;

import jp.co.next_evolution.sample.DataSourceConfig02;
import jp.co.next_evolution.sample.common.ActionResult;
import jp.co.next_evolution.sample.dto.db02.Todo;
import jp.co.next_evolution.sample.mapper.db02.TodoMapper;
import jp.co.next_evolution.sample.response.ApiResponse;
import jp.co.next_evolution.sample.response.db02.ToDoResponse;
import jp.co.next_evolution.sample.response.db02.TodoListResponse;
import jp.co.next_evolution.sample.service.ServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoService extends ServiceBase {

    @Autowired
    TodoMapper todoMapper;

    public ApiResponse list(long userId) {
        return ApiResponse.builder()
                          .returnCode(ActionResult.OK.getValue())
                          .errorMessage(null)
                          .body(TodoListResponse.builder()
                                                .todoList(todoMapper.list(userId))
                                                .build())
                          .build();
    }

    public ApiResponse select(long todoId,long userId){
        Todo todo = todoMapper.select(todoId, userId);
        return ApiResponse.builder()
                          .returnCode(ActionResult.OK.getValue())
                          .errorMessage(null)
                          .body(ToDoResponse.builder()
                                            .todo(todo)
                                            .build())
                          .build();
    }

    @Transactional(transactionManager = DataSourceConfig02.TX_MANAGER)
    public ApiResponse insert(Todo todo) {
        todoMapper.insert(todo);
        return ApiResponse.builder()
                          .returnCode(ActionResult.OK.getValue())
                          .errorMessage(null)
                          .body(null)
                          .build();
    }

    @Transactional(transactionManager = DataSourceConfig02.TX_MANAGER)
    public ApiResponse update(Todo todo) {
        todoMapper.update(todo);
        return ApiResponse.builder()
                          .returnCode(ActionResult.OK.getValue())
                          .errorMessage(null)
                          .body(null)
                          .build();
    }

    @Transactional(transactionManager = DataSourceConfig02.TX_MANAGER)
    public ApiResponse delete(Todo todo) {
        todoMapper.delete(todo);
        return ApiResponse.builder()
                          .returnCode(ActionResult.OK.getValue())
                          .errorMessage(null)
                          .body(null)
                          .build();
    }

}
