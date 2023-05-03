package ibf2022.assessment.paf.batch3.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.assessment.paf.batch3.models.Order;
import ibf2022.assessment.paf.batch3.repositories.OrderRepository;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;

@Service
public class BeerService {

	@Autowired
	private OrderRepository orderRepo;

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public String placeOrder(List<Order> orders, String breweryId) {
		// TODO: Task 5 

		UUID uuid = UUID.randomUUID();
        String orderId = uuid.toString().substring(0, 8);

		JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
		for (Order o : orders) {
			arrBuilder.add(o.toJSON());
		}

		JsonObject result = Json.createObjectBuilder()
							.add("orderId", orderId)
							.add("date", LocalDateTime.now().toString())
							.add("breweryId", breweryId)
							.add("orders", arrBuilder)
							.build();
		
		this.orderRepo.insertOrder(result.toString());

		return orderId;
	}

}
