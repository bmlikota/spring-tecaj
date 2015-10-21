package net.springinaction.exercise1.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.springinaction.exercise1.model.Show;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

public class ShowDaoImpl extends NamedParameterJdbcDaoSupport implements ShowDao {

	public static Logger log = LoggerFactory.getLogger(ShowDaoImpl.class);
			
	private static final String FIND_ALL_SQL = "SELECT show.id, show.name, genre_id, genre.name as genre_name, seating_plan_id FROM SHOW, GENRE WHERE genre_id=genre.id";
	private static final String FIND_BY_ID_QUERY = "SELECT show.id, show.name, genre_id, genre.name as genre_name, seating_plan_id FROM SHOW, Genre WHERE genre_id=genre.id and show.id= :id";
	private static final String FIND_BY_NAME_QUERY = "SELECT show.id, show.name, genre_id, genre.name as genre_name, seating_plan_id FROM SHOW, Genre WHERE genre_id=genre.id and show.name= :name";
	private static final String INSERT_SQL = "INSERT INTO show (name, genre_id, seating_plan_id) VALUES (:name, :genre_id, :seating_plan_id)";
	private static final String UPDATE_SQL = "UPDATE SHOW SET name=:name, genre_id=:genre_id, seating_plan_id=:seating_plan_id WHERE id=:id";
	private static final String DELETE_ALL_SQL = "DELETE FROM SHOW";
	private static final String DELETE_SQL = "DELETE FROM SHOW WHERE id = :id";
	private static final String FIND_BY_GENRE_SQL = "SELECT show.id, show.name, genre_id, genre.name as genre_name, seating_plan_id FROM SHOW, GENRE WHERE genre_id=genre.id AND genre_id= :genre_id";
	
	public Show findById(long id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(DbConstants.SHOW_ID, new Long(id));
		List<Show> result = getNamedParameterJdbcTemplate().query(FIND_BY_ID_QUERY, params, new ShowRowMapper());

		if (result.size() >= 1) {
			return (Show) result.get(0);
		}
		return null;
	}
	
	public int create(Show show) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(DbConstants.SHOW_GENRE_ID, show.getGenre().getId());
		params.put(DbConstants.SHOW_NAME, show.getName());
		params.put(DbConstants.SHOW_SEATING_PLAN_ID, show.getSeatingPlanId());
		return getNamedParameterJdbcTemplate().update(INSERT_SQL, params);
	}
	
	
	public List<Show> findAll() {
		return getNamedParameterJdbcTemplate().query(FIND_ALL_SQL, new HashMap<String, Object> (), new ShowRowMapper());
	}
	
	@Override
	public List<Show> findByGenreId(Long genreId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(DbConstants.SHOW_GENRE_ID, genreId);
		return getNamedParameterJdbcTemplate().query(FIND_BY_GENRE_SQL, params, new ShowRowMapper());
	}
	
	public Show findByName (String name) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(DbConstants.SHOW_NAME, name);
		List<Show> result = getNamedParameterJdbcTemplate().query(FIND_BY_NAME_QUERY, params, new ShowRowMapper());

		if (result.size() >= 1) {
			return (Show) result.get(0);
		}
		return null;
	}
	
	public int update(Show show) {
		log.info("Updating record with id=" + show.getId());
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(DbConstants.SHOW_ID, show.getId());
		params.put(DbConstants.SHOW_GENRE_ID, show.getGenre().getId());
		params.put(DbConstants.SHOW_NAME, show.getName());
		params.put(DbConstants.SHOW_SEATING_PLAN_ID, show.getSeatingPlanId());
		return getNamedParameterJdbcTemplate().update(UPDATE_SQL, params);
	}

	public void deleteAll() {
		log.info("Deleting all data from table");
		getNamedParameterJdbcTemplate().update(DELETE_ALL_SQL, new HashMap<String, Object>());
	}

	public void delete(long id) {
		log.info("Deleting record with id=" + id);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(DbConstants.SHOW_ID, id);
		getNamedParameterJdbcTemplate().update(DELETE_SQL, params);
		
	}

	
}
