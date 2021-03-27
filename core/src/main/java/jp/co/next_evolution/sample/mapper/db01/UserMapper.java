package jp.co.next_evolution.sample.mapper.db01;

import jp.co.next_evolution.sample.dto.LoginUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    LoginUser login(String emailAddress, String loginPassword);
}
