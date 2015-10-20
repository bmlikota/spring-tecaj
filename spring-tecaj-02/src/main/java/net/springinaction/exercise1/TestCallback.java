package net.springinaction.exercise1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.springinaction.exercise1.dao.GenreRowMapper;
import net.springinaction.exercise1.model.Genre;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

public class TestCallback {

	public static Logger log = LoggerFactory.getLogger(TestCallback.class);
	
	public static final String sql = "Select id, name from GENRE where id < ?";
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-workshop-02/exercise-1/ticket-ctx.xml");
		JdbcTemplate jt =  (JdbcTemplate) ctx.getBean("jdbcTemplate");

		
		final List<Genre> result = new ArrayList<Genre>();

		// query using RowMapper...
		List<Genre> genres = jt.query(sql, 
				new Object[] {new Integer(4)},
				new GenreRowMapper()
		);
		log.info("Query returned: ");
		printResult(genres);
		
		// same query using RowCallbackHandler ...
		jt.query(sql, 
			new Object[] {new Integer(4)},
			new RowCallbackHandler() {
				public void processRow(ResultSet rs) {
					Genre genre = new Genre();
					try {
						genre.setId(rs.getLong("id"));
						genre.setName(rs.getString("name"));
						result.add(genre);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		);
		
		log.info("RowCallbackHandler:" );
		printResult(result);
		
		// Same query but using RowMapper...
		
	}
	
	private static void printResult(List<Genre> result) {
		Iterator<Genre> it = result.iterator();
		while(it.hasNext()) {
			log.info(""+it.next());
		}
	}
	
}
