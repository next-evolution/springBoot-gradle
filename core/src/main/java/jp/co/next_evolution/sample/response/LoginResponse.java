package jp.co.next_evolution.sample.response;

import jp.co.next_evolution.sample.dto.LoginUser;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {

    private LoginUser loginUser;

}
