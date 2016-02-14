/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.morabito.cartcalculator.service.impl;

import java.math.BigDecimal;
import org.morabito.cartcalculator.data.CartData;
import org.morabito.cartcalculator.data.LineItemData;
import org.morabito.cartcalculator.factory.ServiceFactory;
import org.morabito.cartcalculator.service.CartTaxesCalculatorService;
import org.morabito.cartcalculator.strategy.TaxesCalculatorStrategy;

/**
 *
 * @author Salvatore Morabito
 */
public class CartTaxesCalculatorServiceImpl implements CartTaxesCalculatorService {

    @Override
    public void calculateTaxesAndTotals(CartData cartData) {
        TaxesCalculatorStrategy taxesCalculatorStrategy = ServiceFactory.getServiceFactory().getTaxesCalculatorStrategy();
                
        BigDecimal total = null;
        BigDecimal totalTaxes = null;
        for (LineItemData lineItemData : cartData.getLineItems()) {
            taxesCalculatorStrategy.calculateTaxesForLineItem(lineItemData);

            if (total == null) {
                total = lineItemData.getGrossPrice();
            } else {
                total = total.add(lineItemData.getGrossPrice());
            }

            if (totalTaxes == null) {
                totalTaxes = lineItemData.getTaxAmount();
            } else {
                totalTaxes = totalTaxes.add(lineItemData.getTaxAmount());
            }
        }

        cartData.setTotalTaxes(totalTaxes);
        cartData.setTotal(total);
    }
}
