/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.morabito.cartcalculator.factory.impl;

import org.morabito.cartcalculator.factory.ServiceFactory;
import org.morabito.cartcalculator.service.CartCalculatorService;
import org.morabito.cartcalculator.service.CartParserService;
import org.morabito.cartcalculator.service.CartTaxesCalculatorService;
import org.morabito.cartcalculator.service.impl.CartCalculatorServiceImpl;
import org.morabito.cartcalculator.service.impl.CartParserServiceImpl;
import org.morabito.cartcalculator.service.impl.CartTaxesCalculatorServiceImpl;
import org.morabito.cartcalculator.strategy.LineItemParserStrategy;
import org.morabito.cartcalculator.strategy.TaxesCalculatorStrategy;
import org.morabito.cartcalculator.strategy.impl.LineItemParserStrategyImpl;
import org.morabito.cartcalculator.strategy.impl.TaxesCalculatorStrategyImpl;

/**
 *
 * @author Salvatore Morabito
 */
public class ServiceFactoryImpl extends ServiceFactory {

    private static ServiceFactory instance;

    private ServiceFactoryImpl() {
        //private constructor since this factory is a singleton
    }

    public static ServiceFactory getInstance() {
        if (instance == null) {
            instance = new ServiceFactoryImpl();
        }
        return instance;
    }

    @Override
    public CartCalculatorService getCartCalculatorService() {
        return getService(CartCalculatorServiceImpl.class);
    }

    @Override
    public CartParserService getCartParserService() {
        return getService(CartParserServiceImpl.class);
    }

    @Override
    public LineItemParserStrategy getLineItemParserStrategy() {
        return getService(LineItemParserStrategyImpl.class);
    }
    
    @Override
    public CartTaxesCalculatorService getCartTaxesCalculatorService() {
        return getService(CartTaxesCalculatorServiceImpl.class);
    }

    @Override
    public TaxesCalculatorStrategy getTaxesCalculatorStrategy() {
        return getService(TaxesCalculatorStrategyImpl.class);
    }
}
