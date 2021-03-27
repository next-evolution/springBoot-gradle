package jp.co.next_evolution.sample.request;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString(exclude = "loginPassword")
public class LoginRequest {

    private String emailAddress;

    private String loginPassword;

}
