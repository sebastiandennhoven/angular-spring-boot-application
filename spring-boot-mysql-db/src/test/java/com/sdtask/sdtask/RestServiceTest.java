package com.sdtask.sdtask;

import com.sdtask.sdtask.models.User;
import com.sdtask.sdtask.services.RestService;
import com.sdtask.sdtask.services.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest
public class RestServiceTest {

	@Autowired
	private RestService restService;

    @Test
	public void checkIfApiUserhasCorrectClass() throws Exception {
        User responseJson = this.restService.getNewUserFromApi();
        assertThat(responseJson.getClass()).isEqualTo(User.class);
	}

    @Test
	public void checkCorrectUserMapping() throws Exception {
        User responseUser = this.restService.getNewUserFromApi();
        assertThat(responseUser.getName()).isNotNull();
        assertThat(responseUser.getEmail()).isNotNull();
        assertThat(responseUser.getGender()).isNotNull();
        assertThat(responseUser.getLocation()).isNotNull();
        assertThat(responseUser.getPicture()).isNotNull();
        assertThat(responseUser.getTimeAdded()).isNotNull();
	}

}
