import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.dao.TelDao;
import com.offcn.po.Mobile;
import com.offcn.service.TelService;

public class Test {

	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
		
		TelDao dao = context.getBean(TelDao.class);
		
		
		Mobile m = new  Mobile();
		
		m.setMobileNumber("132111111");
		m.setAreaCode("12324");
		m.setMobileArea("浙江 杭州");
		m.setPostCode("1101");
		m.setMobileType("中国联通GSM");
		dao.save(m);
		
		System.out.println("执行程聪");
	}

}

