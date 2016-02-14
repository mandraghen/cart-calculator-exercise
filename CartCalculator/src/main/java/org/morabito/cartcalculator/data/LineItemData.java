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
public class LineItemData {

    private ProductData product;
    private int quantity;
    private BigDecimal netPrice;
    private BigDecimal grossPrice;
    private BigDecimal taxAmount;

    /**
     * @return the product
     */
    public ProductData getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(ProductData product) {
        this.product = product;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the netPrice
     */
    public BigDecimal getNetPrice() {
        return netPrice;
    }

    /**
     * @param netPrice the netPrice to set
     */
    public void setNetPrice(BigDecimal netPrice) {
        this.netPrice = netPrice;
    }

    /**
     * @return the grossPrice
     */
    public BigDecimal getGrossPrice() {
        return grossPrice;
    }

    /**
     * @param grossPrice the grossPrice to set
     */
    public void setGrossPrice(BigDecimal grossPrice) {
        this.grossPrice = grossPrice;
    }
    
    /**
     * @return the taxAmount
     */
    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    /**
     * @param taxAmount the taxAmount to set
     */
    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }
    
    @Override
    public String toString() {
        return "LineItemData{" + "product=" + product + ", quantity=" + quantity + ", netPrice=" + netPrice + ", grossPrice=" + grossPrice + ", taxAmount=" + taxAmount + '}';
    }
}
