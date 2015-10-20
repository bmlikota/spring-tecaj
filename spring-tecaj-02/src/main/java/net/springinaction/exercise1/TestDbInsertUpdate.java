package net.springinaction.exercise1;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestDbInsertUpdate {

	public static Logger log = LoggerFactory.getLogger(TestDbInsertUpdate.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-workshop-02/exercise-1/ticket-ctx.xml");
		
		JdbcTemplate jt = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		jt.execute("delete from Genre");

		//1. insert.....
		int x = jt.update("insert into Genre (id, name) values (1, 'Opera')");
		x += jt.update("insert into Genre (id, name) values (2, 'Circus')");
		x += jt.update("insert into Genre (id, name) values (3, 'Rock Concert')");
		x += jt.update("insert into Genre (id, name) values (4, 'Symphony')");
		x += jt.update("insert into Genre (id, name) values (5, 'Sport event')");

		log.info(x + " rows inserted");

		//2. update...
		x = jt.update("update Genre set name='Pop /Rock' where id= ? ", new Object[] {new Integer(3)});
		log.info(x  + " rows updated.");

		//3. delete...
		x = jt.update("delete from Genre where id= ? ", new Object[] {new Integer(2)});
		log.info(x  + " rows deleted.");

		//4. list what we have....
		List l = jt.queryForList("select id, name from Genre");
		log.info(""+l);

	}

}
