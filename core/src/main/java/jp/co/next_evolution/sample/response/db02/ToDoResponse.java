package jp.co.next_evolution.sample.response.db02;

import jp.co.next_evolution.sample.dto.db02.Todo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ToDoResponse {

    private Todo todo;

}
