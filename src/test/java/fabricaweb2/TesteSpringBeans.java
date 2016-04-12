package fabricaweb2;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TesteSpringBeans {

	@Test
	public void testContextoSpring() {		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext
				("file:src/main/resources/META-INF/springbeans.xml");
		
		
		
		ctx.close();

	}

}
