/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.morabito.cartcalculator.data;

import java.math.BigDecimal;

/**
 *
 * @author Salvatore Morabito
 */
public class ProductData {

    private String name;
    private BigDecimal price;
    private boolean imported;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return the imported
     */
    public boolean isImported() {
        return imported;
    }

    /**
     * @param imported the imported to set
     */
    public void setImported(boolean imported) {
        this.imported = imported;
    }

    @Override
    public String toString() {
        return "ProductData{" + "name=" + name + ", price=" + price + ", imported=" + imported + '}';
    }
}
