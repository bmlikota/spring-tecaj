package net.springinaction.exercise1;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestJdbcTemplate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-workshop-02/exercise-1/ticket-ctx.xml");
		JdbcTemplate jt = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		
		// More complicated query...
		Object[] parameters = new Object[] {new Integer(3)};
		String name = (String) jt.queryForObject("select name from Genre where id= ? ", parameters, String.class);
		System.out.println("1. Record with id=3 field name= " + name);

		//query for a List
		List<Map<String, Object>> result = jt.queryForList("select id, name from Genre where id> ?", parameters);
		System.out.println("2. Record with id > 3 >> " + result);
		
		System.out.println("3. List size >> " + result.size());
		for (Map<String, Object> map : result) {
			System.out.println("Map:" + map);
			System.out.println("ID:" + map.get("ID"));
			System.out.println("NAME:" + map.get("NAME"));
		}

	}

}
