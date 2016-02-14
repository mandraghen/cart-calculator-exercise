/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.morabito.cartcalculator.service.impl;

import org.apache.log4j.Logger;
import org.morabito.cartcalculator.data.CartData;
import org.morabito.cartcalculator.data.LineItemData;
import org.morabito.cartcalculator.factory.ServiceFactory;
import org.morabito.cartcalculator.service.CartCalculatorService;
import org.morabito.cartcalculator.service.CartParserService;
import org.morabito.cartcalculator.service.CartTaxesCalculatorService;

/**
 *
 * @author Salvatore Morabito
 */
public class CartCalculatorServiceImpl implements CartCalculatorService {

    private static final Logger LOG = Logger.getLogger(CartCalculatorServiceImpl.class);

    @Override
    public String calculateCart(final String cartInput) {
        LOG.debug("calculateCart: cartInput = " + cartInput);

        CartParserService cartParserService = ServiceFactory.getServiceFactory().getCartParserService();
        CartData cartData = cartParserService.parseCart(cartInput);

        //calculate taxes and totals
        CartTaxesCalculatorService cartTaxesCalculatorService = ServiceFactory.getServiceFactory().getCartTaxesCalculatorService();
        cartTaxesCalculatorService.calculateTaxesAndTotals(cartData);

        LOG.debug("cartData = " + cartData);

        String prettyPrintCart = prettyPrintCart(cartData);

        LOG.debug("prettyPrintCart: \n" + prettyPrintCart);

        return prettyPrintCart;
    }

    protected String prettyPrintCart(CartData cartData) {
        StringBuilder cartDescription = new StringBuilder();
        for (LineItemData lineItem : cartData.getLineItems()) {
            cartDescription.append(lineItem.getQuantity()).append(" ");

            if (lineItem.getProduct().isImported()) {
                cartDescription.append("imported ");
            }

            cartDescription.append(lineItem.getProduct().getName())
                    .append(":").append(" ").append(lineItem.getGrossPrice()).append("\n");
        }

        cartDescription.append("Sales Taxes: ").append(cartData.getTotalTaxes()).append("\n");
        cartDescription.append("Total: ").append(cartData.getTotal());

        return cartDescription.toString();
    }
}
