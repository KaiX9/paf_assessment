package ibf2022.assessment.paf.batch3.repositories;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	// TODO: Task 5
	public Document insertOrder(String json) {

		Document doc = Document.parse(json);
		Document docInserted = mongoTemplate.insert(doc, "orders");
		return docInserted;		

	}

}
