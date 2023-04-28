package ibf2022.assessment.paf.batch3.services;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.assessment.paf.batch3.models.Order;
import ibf2022.assessment.paf.batch3.repositories.OrderRepository;

@Service
public class BeerService {

	@Autowired
	private OrderRepository orderRepo;

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public String placeOrder(Order o, Integer breweryId) {
		// TODO: Task 5 

		UUID uuid = UUID.randomUUID();
        String orderId = uuid.toString().substring(0, 8);
		o.setOrderId(orderId);
		o.setDate(LocalDateTime.now());
		o.setBreweryId(breweryId);
		o.addOrder(88, 3);
		o.addOrder(50, 2);
		o.addOrder(76, 5);

		this.orderRepo.insertOrder(o);

		return orderId;
	}

}
