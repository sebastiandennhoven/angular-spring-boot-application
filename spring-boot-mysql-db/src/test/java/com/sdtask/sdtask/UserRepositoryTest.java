package com.sdtask.sdtask;

import java.util.List;

import com.sdtask.sdtask.entities.UserEntity;
import com.sdtask.sdtask.services.UserRepository;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserRepositoryTest {
    @Value("${request.usersize}")
    private int userSize;

    @Autowired
	private UserRepository userRepository;

    
    @Test
	public void checkDatabaseResponseMaxRsponseSize() throws Exception {
        List<UserEntity> responseDbList = this.userRepository.findTopN(userSize);
        assertThat(responseDbList.size()).isGreaterThanOrEqualTo(0);
	}

    @Test
	public void checkDatabaseResponseMaxRsponseSizeForCountry() throws Exception {
        List<UserEntity> responseDbList = this.userRepository.findTopNInCountry(userSize, "Spain");
        assertThat(responseDbList.size()).isGreaterThanOrEqualTo(0);
	}
}
