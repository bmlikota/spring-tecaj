package net.springinaction.exercise1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.springinaction.exercise1.model.Genre;
import net.springinaction.exercise1.model.Show;

import org.springframework.jdbc.core.RowMapper;
/**
 * 
 * @author dmadunic
 *
 */
public class ShowRowMapper implements RowMapper<Show> {
	
	@Override
	public Show mapRow(ResultSet rs, int numRow) throws SQLException {
		Show show = new Show();
		try {
			show.setId(rs.getLong(DbConstants.SHOW_ID));
			show.setName(rs.getString(DbConstants.SHOW_NAME));
			show.setSeatingPlanId(rs.getInt(DbConstants.SHOW_SEATING_PLAN_ID));
			
			Genre genre = new Genre();
			genre.setId(rs.getLong(DbConstants.SHOW_GENRE_ID));
			genre.setName(rs.getString(DbConstants.SHOW_GENRE_NAME));
			show.setGenre(genre);
			
		} catch (SQLException e) {
			e.printStackTrace();
			//TODO: throw exception
		}
		return show;
	}

}
