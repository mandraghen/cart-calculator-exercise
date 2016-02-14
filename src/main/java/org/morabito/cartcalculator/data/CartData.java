/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.morabito.cartcalculator.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Salvatore Morabito
 */
public class CartData {

    private List<LineItemData> lineItems;
    private BigDecimal totalTaxes;
    private BigDecimal subTotal;
    private BigDecimal total;

    /**
     * @return the lineItems
     */
    public List<LineItemData> getLineItems() {
        return lineItems;
    }

    /**
     * @param lineItems the lineItems to set
     */
    public void setLineItems(List<LineItemData> lineItems) {
        this.lineItems = lineItems;
    }
    
    public void addLineItem(LineItemData lineItem) {
        if(lineItems == null) {
            lineItems = new ArrayList<>();
        }
        lineItems.add(lineItem);
    }

    /**
     * @return the totalTaxes
     */
    public BigDecimal getTotalTaxes() {
        return totalTaxes;
    }

    /**
     * @param totalTaxes the totalTaxes to set
     */
    public void setTotalTaxes(BigDecimal totalTaxes) {
        this.totalTaxes = totalTaxes;
    }

    /**
     * @return the subTotal
     */
    public BigDecimal getSubTotal() {
        return subTotal;
    }

    /**
     * @param subTotal the subTotal to set
     */
    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * @return the total
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
    @Override
    public String toString() {
        return "CartData{" + "lineItems=" + lineItems + ", totalTaxes=" + totalTaxes + ", subTotal=" + subTotal + ", total=" + total + '}';
    }
}
