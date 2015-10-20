package net.springinaction.exercise1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import net.springinaction.exercise1.model.Genre;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;

/**
 * Demonstrates Usage of Mapping of SQL on Java objects
 * @author domagoj
 *
 */
public class GenreDaoImpl extends JdbcDaoSupport implements GenreDao {

	private static final String FIND_ALL = "SELECT id, name FROM genre";
	private static final String FIND_BY_ID_QUERY = "SELECT id, name FROM genre where id=?";
	private static final String UPDATE_SQL = "UPDATE genre SET name= ? WHERE id= ?";
	private static final String INSERT_SQL = "insert into genre (id, name) values (?, ?)";
	private static final String INSERT_SQL_2 = "insert into genre (name) values (?)";
	
	public Genre findById(Long id) {
		GenreMappingQuery custQuery = new GenreMappingQuery(
			getDataSource(), 
			FIND_BY_ID_QUERY
			);
		Object[] parms = new Object[1];
		parms[0] = id;
		List results = custQuery.execute(parms);
		if (results.size() > 0) {
			return (Genre) results.get(0);
		} else {
			//or throw Exception....
			return null;
		}
	}
	
	public int findMaxId() {
		return getJdbcTemplate().queryForInt("SELECT MAX(ID) FROM GENRE");
	}

	public int update(Genre genre) {
		//1. construct SqlUpdate object
		SqlUpdate updateGenre = new SqlUpdate();
		updateGenre.setDataSource(getDataSource());
		updateGenre.setSql(UPDATE_SQL);
		updateGenre.declareParameter(new SqlParameter("name", Types.VARCHAR));
		updateGenre.declareParameter(new SqlParameter("id", Types.INTEGER));
		updateGenre.compile();

		//2. execute update...
		Object[] parameters = new Object[] {genre.getName(), genre.getId()};
		return updateGenre.update(parameters);
	}


	public Genre create(Genre genre) {
		
		SqlUpdate createGenre = new SqlUpdate();
		createGenre.setJdbcTemplate(getJdbcTemplate());
		createGenre.setSql(INSERT_SQL);
		createGenre.declareParameter(new SqlParameter("id", Types.INTEGER));
		createGenre.declareParameter(new SqlParameter("name", Types.VARCHAR));
		createGenre.compile();
		
		Object[] parameters = new Object[] {genre.getId(), genre.getName()};
		createGenre.update(parameters);
		
		/*
		CreateGenre createGenre = new CreateGenre(getDataSource(), INSERT_SQL_2);
		Long id = createGenre.create(genre);
		genre.setId(id);
		*/
		return genre;
	}

	private class GenreMappingQuery extends MappingSqlQuery {
		
		public GenreMappingQuery(DataSource ds, String initQuery) {
			super(ds, initQuery);
			super.declareParameter(new SqlParameter("id", Types.INTEGER));
			compile();
		}
		//mandatory method to be implemented by subclasses...
		public Object mapRow(ResultSet rs, int rowNumber) throws SQLException {
			Genre g = new Genre();
			g.setId(rs.getLong("id"));
			g.setName(rs.getString("name"));
			return g;
		}
	}

	
	public List<Genre> findAll() {
		return getJdbcTemplate().query(FIND_ALL, new RowMapper<Genre>() {
				public Genre mapRow(ResultSet rs, int numRow) {
					Genre genre = new Genre();
					try {
						genre.setId(rs.getLong("id"));
						genre.setName(rs.getString("name"));						
					} catch (SQLException e) {
						e.printStackTrace();
						//TODO: throw exception
					}
					return genre;
				}
			}
			);
	}
	
	/*
	private class CreateGenre extends SqlUpdate {
		public CreateGenre(DataSource ds, String query) {
			setDataSource(ds);
			setSql(query);
			setGeneratedKeysColumnNames(new String[] {"id"});
			declareParameter(new SqlParameter("name", Types.VARCHAR));
			compile();
		}

		public Long create(Genre genre) {
			Object[] parameters = new Object[] {genre.getName()};
			KeyHolder keyHolder = new GeneratedKeyHolder();
			update(parameters, keyHolder);
			return keyHolder.getKey().longValue();

		}
	}*/
}
