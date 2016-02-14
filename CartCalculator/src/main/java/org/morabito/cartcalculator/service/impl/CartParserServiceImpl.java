/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.morabito.cartcalculator.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import org.apache.log4j.Logger;
import org.morabito.cartcalculator.data.CartData;
import org.morabito.cartcalculator.data.LineItemData;
import org.morabito.cartcalculator.factory.ServiceFactory;
import org.morabito.cartcalculator.service.CartParserService;
import org.morabito.cartcalculator.strategy.LineItemParserStrategy;

/**
 *
 * @author Salvatore Morabito
 */
public class CartParserServiceImpl implements CartParserService {

    private static final Logger LOG = Logger.getLogger(CartParserServiceImpl.class);

    //TODO some null check could be necessary
    @Override
    public CartData parseCart(final String cartInput) {
        LOG.debug("parseCart: cartInput = " + cartInput);

        LineItemParserStrategy lineItemParserStrategy = ServiceFactory.getServiceFactory().getLineItemParserStrategy();

        CartData cartData = new CartData();
        String[] lineItems = cartInput.split("\\n");
        BigDecimal subTotal = null;

        for (String lineItemString : lineItems) {
            try {
                LineItemData lineItem = lineItemParserStrategy.parseLineItem(lineItemString);
                cartData.addLineItem(lineItem);

                if (subTotal == null) {
                    subTotal = lineItem.getNetPrice();
                } else {
                    subTotal = subTotal.add(lineItem.getNetPrice());
                }
            } catch (NumberFormatException | ParseException e) {
                LOG.warn("Error parsing line item , skipping line...", e);
            }
        }

        cartData.setSubTotal(subTotal);

        return cartData;
    }
}
