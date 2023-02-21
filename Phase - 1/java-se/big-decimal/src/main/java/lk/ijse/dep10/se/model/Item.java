package lk.ijse.dep10.se.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Item implements Serializable {
    private String code;
    private String description;
    private BigDecimal buyingPrice;
    private BigDecimal sellingPrice;
    private int quantity;

    public Item() {
    }

    public Item(String code, String description, BigDecimal buyingPrice, BigDecimal sellingPrice, int quantity) {
        this.code = code;
        this.description = description;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(BigDecimal buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getProfit() {
        return this.sellingPrice.subtract(this.buyingPrice).setScale(2);
    }

    public BigDecimal getTotal() {
        return this.buyingPrice.multiply(new BigDecimal(quantity)).setScale(2);
    }

    public BigDecimal getTotalProfit() {
        return getProfit().multiply(new BigDecimal(quantity)).setScale(2);
    }
}
