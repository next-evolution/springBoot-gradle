package jp.co.next_evolution.sample.request.db02;

import jp.co.next_evolution.sample.dto.db02.Todo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TodoInsertRequest {

    private Todo todo;

}
