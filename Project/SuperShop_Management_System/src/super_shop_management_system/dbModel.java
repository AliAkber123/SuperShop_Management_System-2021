
package super_shop_management_system;


public class dbModel {
    private String id, name , price, quantity , size, unit, datetime;

    public dbModel(String id, String name, String price, String quantity, String size, String unit, String datetime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.size = size;
        this.unit = unit;
        this.datetime = datetime;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getSize() {
        return size;
    }

    public String getUnit() {
        return unit;
    }

    public String getDatetime() {
        return datetime;
    }
    
    
}
