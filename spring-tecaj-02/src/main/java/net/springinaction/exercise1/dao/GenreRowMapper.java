package net.springinaction.exercise1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.springinaction.exercise1.model.Genre;

import org.springframework.jdbc.core.RowMapper;
/**
 * Example of simple implementation of RowMapper.
 * 
 * @author dmaunic
 *
 */
public class GenreRowMapper implements RowMapper<Genre> {
	
	@Override
	public Genre mapRow(ResultSet rs, int numRow) {
		Genre genre = new Genre();
		try {
			genre.setId(rs.getLong(DbConstants.GENRE_ID));
			genre.setName(rs.getString(DbConstants.GENRE_NAME));
			
		} catch (SQLException e) {
			//TODO: fix this ...
			e.printStackTrace();
		}
		return genre;
	}
}

