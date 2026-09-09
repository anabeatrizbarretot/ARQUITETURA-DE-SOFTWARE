import java.util.Collections;
import java.util.List;

class Photo {
    private int id;
    private String path;
    private String description;

    public Photo(int id, String path, String description) {
        this.id = id;
        this.path = path;
        this.description = description;
    }

    public int getId() { return id; }
    public String getPath() { return path; }
    public String getDescription() { return description; }
}

class Item {
    private int id;
    private String name;
    private double price;
    private double weight;
    private List<Photo> images;

    public Item(int id, String name, double price, double weight, List<Photo> images) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.images = images;
    }

    public double getWeight() { return weight; }
    public double getPrice() { return price; }
}

class ItemItems {
    private int id;
    private Item item;
    private int quantity;
    private double itemPrice;

    public ItemItems(int id, Item item, int quantity) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
        this.itemPrice = item.getPrice();
    }

    public double getSubTotal() {
        return itemPrice * quantity;
    }

    public double getWeight() {
        return item.getWeight() * quantity;
    }
}

class ShoppingCart {
    private int id;
    private List<ItemItems> items;

    public ShoppingCart(int id, List<ItemItems> items) {
        this.id = id;
        this.items = items;
    }

    public List<ItemItems> getItems() { return items; }
}

class ShippingCost {
    private int id;
    private Location address;
    private double cost;
    private int days;
    private DeliveryCompany deliveryCompany;

    public ShippingCost(int id, Location address, double cost, int days, DeliveryCompany deliveryCompany) {
        this.id = id;
        this.address = address;
        this.cost = cost;
        this.days = days;
        this.deliveryCompany = deliveryCompany;
    }

    public double getCost() { return cost; }
    public int getDays() { return days; }
}

interface DeliveryCompany {
    int getId();
    String getName();
    ShippingCost calcShippingCost(Location address, ShoppingCart cart);
}

class Location {
    private int id;
    private String street;
    private String city;
    private String zipcode;
    private String number;

    public Location(int id, String street, String city, String zipcode, String number) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.number = number;
    }

    public ShippingCost calculateShipping(DeliveryCompany deliveryCompany, ShoppingCart cart) {
        return deliveryCompany.calcShippingCost(this, cart);
    }

    public String getZipcode() { return zipcode; }
}

class CorreiosDeliveryService implements DeliveryCompany {
    private int id;
    private String name;

    public CorreiosDeliveryService(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() { return id; }

    @Override
    public String getName() { return name; }

    @Override
    public ShippingCost calcShippingCost(Location address, ShoppingCart cart) {
        double calculatedCost = 30.00;
        int deliveryDays = 5;

        return new ShippingCost(1, address, calculatedCost, deliveryDays, this);
    }
}

public class EcommerceShipping {
    public static void main(String[] args) {
        Location endereco = new Location(1, "Av. Paulista", "São Paulo", "01310-100", "1000");
        DeliveryCompany correios = new CorreiosDeliveryService(10, "Correios Express");
        ShoppingCart carrinho = new ShoppingCart(1, Collections.emptyList());

        ShippingCost frete = endereco.calculateShipping(correios, carrinho);

        System.out.println("Frete calculado com sucesso!");
        System.out.println("Valor: R$ " + frete.getCost());
        System.out.println("Prazo: " + frete.getDays() + " dias úteis");
    }
}