/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.morabito.cartcalculator.strategy.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import org.apache.log4j.Logger;
import org.morabito.cartcalculator.data.LineItemData;
import org.morabito.cartcalculator.data.ProductData;
import org.morabito.cartcalculator.strategy.LineItemParserStrategy;

/**
 *
 * @author Salvatore Morabito
 */
public class LineItemParserStrategyImpl implements LineItemParserStrategy {

    private static final Logger LOG = Logger.getLogger(LineItemParserStrategyImpl.class);

    private static final String IMPORTED_STRING = "imported";
    private static final String WORD_SEPARATOR = " ";

    @Override
    public LineItemData parseLineItem(String lineItem) throws NumberFormatException, ParseException {
        ProductData productData = new ProductData();
        LineItemData lineItemData = new LineItemData();
        lineItemData.setProduct(productData);

        String[] lineItemWords = lineItem.split(WORD_SEPARATOR);

        //first word must be the quantity
        String quantityString = lineItemWords[0];
        int quantity = Integer.parseInt(quantityString);
        lineItemData.setQuantity(quantity);

        //string "at" must be present before price at the end of the lineItem
        //so price must be the last word
        String priceString = lineItemWords[lineItemWords.length - 1];
        //get english format because the decimal separator is the dot (.)
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
        BigDecimal price;
        if (numberFormat instanceof DecimalFormat) {
            DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
            decimalFormat.setParseBigDecimal(true);
            Number priceNumber = decimalFormat.parse(priceString);
            price = (BigDecimal) priceNumber;
            productData.setPrice((BigDecimal) priceNumber);
        } else {
            price = new BigDecimal(priceString);
        }
        productData.setPrice(price);

        lineItemData.setNetPrice(price.multiply(BigDecimal.valueOf(quantity)));

        StringBuilder productNameBuilder = new StringBuilder();
        boolean firstIteration = true;
        for (int i = 1; i < lineItemWords.length - 2; i++) {
            if (IMPORTED_STRING.equals(lineItemWords[i])) {
                productData.setImported(true);
                continue;
            }
            
            if (!firstIteration) {
                productNameBuilder.append(WORD_SEPARATOR);
            } else {
                firstIteration = false;
            }

            productNameBuilder.append(lineItemWords[i]);
        }
        String productName = productNameBuilder.toString();
        productData.setName(productName);

        LOG.debug("Parsed product name: " + productName);

        return lineItemData;
    }
}
