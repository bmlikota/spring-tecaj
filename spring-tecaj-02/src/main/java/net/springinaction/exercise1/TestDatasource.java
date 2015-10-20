package net.springinaction.exercise1;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestDatasource {

	public static Logger LOG = LoggerFactory.getLogger(TestDatasource.class);
	
	private static final String TEST_QUERY = "select count(*) from GENRE";
	
	public static void main(String[] args) {
		
		// 1 setup programatically
		BasicDataSource basicDs = new BasicDataSource();
		basicDs.setDriverClassName("org.hsqldb.jdbcDriver");
		basicDs.setUrl("jdbc:hsqldb:mem:tecaj");
		//basicDs.setUrl("jdbc:hsqldb:hsql://localhost/tecaj");
		basicDs.setUsername("sa");
		basicDs.setPassword("");
		
		LOG.debug(">>> Switching to dataSource from applicationContext");
		//2. retrive from ApplicationContext...
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-workshop-02/exercise-1/ticket-ctx.xml");
		
		DataSource ds = (DataSource) ctx.getBean("dataSource");

		// Perform simpe JdbcQuery
		JdbcTemplate jt = new JdbcTemplate(ds);
		int count = jt.queryForInt(TEST_QUERY);
		LOG.info("Done found total of " + count + " records");

		
	}
}
