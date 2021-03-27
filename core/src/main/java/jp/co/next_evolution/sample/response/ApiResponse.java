package jp.co.next_evolution.sample.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse<T> {

    private int returnCode;

    private String errorMessage;

    private T body;
}
