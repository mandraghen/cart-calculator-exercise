/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.morabito.cartcalculator.service;

import org.morabito.cartcalculator.data.CartData;

/**
 *
 * @author Salvatore Morabito
 */
public interface CartParserService {

    CartData parseCart(String cartInput);
}
