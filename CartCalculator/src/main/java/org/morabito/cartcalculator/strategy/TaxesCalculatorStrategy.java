/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.morabito.cartcalculator.strategy;

import org.morabito.cartcalculator.data.LineItemData;

/**
 *
 * @author Salvatore Morabito
 */
public interface TaxesCalculatorStrategy {
    
    void calculateTaxesForLineItem(LineItemData lineItemData);
}
