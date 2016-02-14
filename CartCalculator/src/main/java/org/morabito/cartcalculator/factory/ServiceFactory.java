/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.morabito.cartcalculator.factory;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.morabito.cartcalculator.factory.impl.ServiceFactoryImpl;
import org.morabito.cartcalculator.service.CartCalculatorService;
import org.morabito.cartcalculator.service.CartParserService;
import org.morabito.cartcalculator.service.CartTaxesCalculatorService;
import org.morabito.cartcalculator.strategy.LineItemParserStrategy;
import org.morabito.cartcalculator.strategy.TaxesCalculatorStrategy;

/**
 *
 * This factory should work as bean container (like spring IoC or java EE container)
 * 
 * @author Salvatore Morabito
 */
public abstract class ServiceFactory {

    private static final Logger LOG = Logger.getLogger(ServiceFactory.class);
    private static final Map<String, Object> SERVICES_CACHE = new HashMap<>();

    public static ServiceFactory getServiceFactory() {
        //check some env variable or property to choose factory
        return ServiceFactoryImpl.getInstance();
    }

    protected <T> T getService(Class<T> clazz) {
        String key = clazz.getCanonicalName();
        if (SERVICES_CACHE.containsKey(key)) {
            return (T) SERVICES_CACHE.get(key);
        }

        T newClazz = null;
        try {
            newClazz = clazz.newInstance();
            SERVICES_CACHE.put(key, newClazz);
        } catch (InstantiationException | IllegalAccessException ex) {
            LOG.error("Error instantiating service for class: " + clazz, ex);
        }

        return newClazz;
    }

    public abstract CartCalculatorService getCartCalculatorService();

    public abstract CartParserService getCartParserService();

    public abstract LineItemParserStrategy getLineItemParserStrategy();
    
    public abstract CartTaxesCalculatorService getCartTaxesCalculatorService();
    
    public abstract TaxesCalculatorStrategy getTaxesCalculatorStrategy();
}
