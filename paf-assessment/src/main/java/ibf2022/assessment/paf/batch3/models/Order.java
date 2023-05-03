package ibf2022.assessment.paf.batch3.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonObjectBuilder;

public class Order {
    
    private String orderId;
    private LocalDateTime date;
    private int breweryId;
    private int beerId;
    private int quantity;
    
    private List<Order> orders = new ArrayList<Order>();

    public Order(int beerId, int quantity) {
        this.beerId = beerId;
        this.quantity = quantity;
    }

    public Order() {
    }

    public void addOrder(int beerId, int quantity) {
        Order order = new Order(beerId, quantity);
        orders.add(order);
    }

    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public int getBreweryId() {
        return breweryId;
    }
    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
    }
    public int getBeerId() {
        return beerId;
    }
    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    
    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", date=" + date + ", breweryId=" + breweryId + ", beerId=" + beerId
                + ", quantity=" + quantity + ", orders=" + orders + "]";
    }
    
    public JsonObjectBuilder toJSON() {
        return Json.createObjectBuilder()
                .add("beerId", beerId)
                .add("quantity", quantity);
    }
}
