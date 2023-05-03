package ibf2022.assessment.paf.batch3.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.Brewery;
import ibf2022.assessment.paf.batch3.models.Style;
import static ibf2022.assessment.paf.batch3.repositories.DBQueries.*;

@Repository
public class BeerRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// DO NOT CHANGE THE SIGNATURE OF THIS METHOD
	public List<Style> getStyles() {
		// TODO: Task 2
		SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_STYLES);
		List<Style> styles = new ArrayList<Style>();

		while (rs.next()) {
			Style s = new Style();
			s.setName(rs.getString("style_name"));
			s.setBeerCount(rs.getInt("beer_count"));
			s.setStyleId(rs.getInt("id"));
			styles.add(s);
		}
		return styles;
	}
		
	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public List<Beer> getBreweriesByBeer(Integer id, String styleName) {
		// TODO: Task 3
		SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_BREWERIES_BY_BEER, id);
		List<Beer> beers = new ArrayList<Beer>();

		while (rs.next()) {
			Beer b = new Beer();
			b.setBeerId(rs.getInt("beer_id"));
			b.setBreweryId(rs.getInt("brewery_id"));
			b.setBeerName(rs.getString("beer_name"));
			b.setBeerDescription(rs.getString("description"));
			b.setBreweryName(rs.getString("brewery_name"));
			beers.add(b);
		}

		return beers;
	}

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public Optional<Brewery> getBeersFromBrewery(Integer id) {
		// TODO: Task 4

		SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_BEERS_FROM_BREWERY, id);

		if (rs.first()) {
			Brewery br = new Brewery();
			br.setAddress1(rs.getString("address1"));
			br.setAddress2(rs.getString("address2"));
			br.setBreweryId(rs.getInt("brewery_id"));
			br.setCity(rs.getString("city"));
			br.setDescription(rs.getString("brewery_description"));
			br.setName(rs.getString("name"));
			br.setPhone(rs.getString("phone"));
			br.setWebsite(rs.getString("website"));

			List<Beer> beers = new ArrayList<Beer>();
    		do {
        		Beer beer = new Beer();
				beer.setBeerId(rs.getInt("beer_id"));
        		beer.setBeerName(rs.getString("beer_name"));
        		beer.setBeerDescription(rs.getString("beer_description"));
        		beers.add(beer);
    		} while (rs.next());

    		br.setBeers(beers);

			return Optional.of(br);
		}
		
		return Optional.empty();
	}
}
