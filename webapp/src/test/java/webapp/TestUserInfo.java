package webapp;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yijiaersan.webapp.model.UserInfo;
import com.yijiaersan.webapp.services.UserInfoService;

public class TestUserInfo {
	
	@Autowired
	private UserInfoService userInfoService;
	private ApplicationContext ac = null;
	
	@Before
	public void before() {
		ac = new ClassPathXmlApplicationContext("classpath:spring/spring-mybatis.xml");
		userInfoService = (UserInfoService) ac.getBean("userInfoService");
	}  
	  	@Test
		public void testInsertUserInfo(){
			UserInfo userInfo = new UserInfo();
			userInfo.setCreatDate(new Date());
			userInfo.setHeadPic("123");
			userInfo.setPassword("1234");
			userInfo.setUseEquipment("ssss");
			userInfo.setUserEmail("xiffent@gmail.com");
			userInfo.setUserId(123L);
			userInfo.setUserName("zhangxufeng");
			userInfo.setUserTel("15510677963");
			userInfo.setUserType("1");
			userInfoService.insert(userInfo);
		}
}
