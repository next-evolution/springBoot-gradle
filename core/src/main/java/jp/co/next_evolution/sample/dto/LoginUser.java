package jp.co.next_evolution.sample.dto;

import lombok.Data;

@Data
public class LoginUser {

    private Long userId;

    private String emailAddress;

    private String userName;

    private String authCode;

}
