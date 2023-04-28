package ibf2022.assessment.paf.batch3.repositories;

public class DBQueries {
    
    public static final String GET_STYLES="select s.id, s.style_name, count(*) as beer_count from styles as s join categories as c on s.cat_id = c.id join beers as b on b.cat_id = c.id and b.style_id = s.id group by s.id, s.style_name order by beer_count desc, s.style_name asc";

    public static final String GET_BREWERIES_BY_BEER = "select b.id as beer_id, br.id as brewery_id, b.name as beer_name, b.descript as description, br.name as brewery_name from beers as b join breweries as br on b.brewery_id = br.id where b.style_id = ? order by b.name asc";

    public static final String GET_BEERS_FROM_BREWERY = "select br.id as brewery_id, br.name as name, br.city as city, br.descript as brewery_description, br.address1 as address1, br.address2 as address2, br.phone as phone, br.website as website, b.name as beer_name, b.descript as beer_description from breweries as br inner join beers as b on br.id = b.brewery_id where br.id = ?";

}
