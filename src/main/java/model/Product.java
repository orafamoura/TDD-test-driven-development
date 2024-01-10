package model;

public class Product {

    public Long id;
    public String name;
    public Integer quantity;
    public Double discount;
    public Double valueAdd;
    public Double value;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getValueAdd() {
        return valueAdd;
    }

    public void setValueAdd(Double valueAdd) {
        this.valueAdd = valueAdd;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double calculateTotalValue() {
        return 0.0;
    }
}