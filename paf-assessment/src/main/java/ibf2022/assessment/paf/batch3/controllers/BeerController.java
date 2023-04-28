package ibf2022.assessment.paf.batch3.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.Brewery;
import ibf2022.assessment.paf.batch3.models.Style;
import ibf2022.assessment.paf.batch3.repositories.BeerRepository;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping
public class BeerController {

	@Autowired
	private BeerRepository beerRepo;

	//TODO Task 2 - view 0
	@GetMapping(path="/view0.html")
	public String getStyles (Model m) {

		List<Style> styles = this.beerRepo.getStyles();

		m.addAttribute("styles", styles);
		return "view0";
	}
	
	//TODO Task 3 - view 1
	@GetMapping(path="/beer/style/{id}")
	public String getBreweriesByBeer(@PathVariable Integer id
		, @RequestParam String styleName, Model m) {
		
		List<Beer> beers = this.beerRepo.getBreweriesByBeer(id, styleName);

		m.addAttribute("beers", beers);
		m.addAttribute("styleName", styleName);

		return "view1";
	}

	//TODO Task 4 - view 2
	@GetMapping(path="/brewery/details/{brewery_id}")
	public String getBeersFromBrewery(@PathVariable Integer brewery_id, Model m) {

		Optional<Brewery> brewery = this.beerRepo.getBeersFromBrewery(brewery_id);
		
		m.addAttribute("brewery", brewery);
		m.addAttribute("breweryName", brewery.get().getName());
		m.addAttribute("beerList", brewery.get().getBeers());	
		
		return "view2";
	}

	
	//TODO Task 5 - view 2, place order

}
