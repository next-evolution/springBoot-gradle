package jp.co.next_evolution.sample.dto.db02;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Todo {

    private long id;

    private long userId;

    private String title;

    private String memo;

    @JsonIgnore
    private boolean deleteFlag;

    private LocalDateTime updatedAt;

}
