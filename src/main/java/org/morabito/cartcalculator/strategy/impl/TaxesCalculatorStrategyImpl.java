/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.morabito.cartcalculator.strategy.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.morabito.cartcalculator.data.LineItemData;
import org.morabito.cartcalculator.data.ProductData;
import org.morabito.cartcalculator.strategy.TaxesCalculatorStrategy;

/**
 *
 * @author Salvatore Morabito
 */
public class TaxesCalculatorStrategyImpl implements TaxesCalculatorStrategy {

    //there is no other way to determine if a product is taxable or not
    private static final String[] FREE_TAX_PRODUCTS = {"chocolate", "book", "pill"};

    private static final int BASE_TAXES_RATE = 10;
    private static final int IMPORTED_TAXES_RATE = 5;
    private static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);
    private static final BigDecimal ROUND_AMOUNT = BigDecimal.valueOf(0.05);

    @Override
    public void calculateTaxesForLineItem(LineItemData lineItemData) {
        int taxRate = 0;
        ProductData product = lineItemData.getProduct();

        if (isBasicTaxesApplicableForProduct(product)) {
            taxRate += BASE_TAXES_RATE;
        }

        if (product.isImported()) {
            taxRate += IMPORTED_TAXES_RATE;
        }

        BigDecimal taxAmount = lineItemData.getNetPrice().multiply(BigDecimal.valueOf(taxRate)).divide(ONE_HUNDRED, 2, RoundingMode.HALF_UP);
        taxAmount = taxAmount.divide(ROUND_AMOUNT, 0, RoundingMode.HALF_UP).multiply(ROUND_AMOUNT);
        lineItemData.setTaxAmount(taxAmount);
        lineItemData.setGrossPrice(lineItemData.getNetPrice().add(taxAmount));
    }

    protected boolean isBasicTaxesApplicableForProduct(ProductData productData) {
        for (String productType : FREE_TAX_PRODUCTS) {
            if (productData.getName().contains(productType)) {
                return false;
            }
        }
        return true;
    }
}
