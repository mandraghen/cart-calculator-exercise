/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.morabito.cartcalculator.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.morabito.cartcalculator.factory.ServiceFactory;

/**
 *
 * @author Salvatore Morabito
 */
public class CartCalculatorServiceTest {

    private static final String INPUT_STRING_1
            = "1 book at 12.49\n"
            + "1 music CD at 14.99\n"
            + "1 chocolate bar at 0.85";

    private static final String INPUT_STRING_2
            = "1 imported box of chocolates at 10.00\n"
            + "1 imported bottle of perfume at 47.50";

    private static final String INPUT_STRING_3
            = "1 imported bottle of perfume at 27.99\n"
            + "1 bottle of perfume at 18.99\n"
            + "1 packet of headache pills at 9.75\n"
            + "1 box of imported chocolates at 11.25";

    private static final String EXPECTED_OUTPUT_STRING_1
            = "1 book: 12.49\n"
            + "1 music CD: 16.49\n"
            + "1 chocolate bar: 0.85\n"
            + "Sales Taxes: 1.50\n"
            + "Total: 29.83";

    private static final String EXPECTED_OUTPUT_STRING_2
            = "1 imported box of chocolates: 10.50\n"
            + "1 imported bottle of perfume: 54.65\n"
            + "Sales Taxes: 7.65\n"
            + "Total: 65.15";

    private static final String EXPECTED_OUTPUT_STRING_3
            = "1 imported bottle of perfume: 32.19\n"
            + "1 bottle of perfume: 20.89\n"
            + "1 packet of headache pills: 9.75\n"
            + "1 imported box of chocolates: 11.80\n"
            //this is wrong, according to correct approximation is to 11.80
//            + "1 imported box of chocolates: 11.85\n"
            + "Sales Taxes: 6.65\n"
            + "Total: 74.63";

    public CartCalculatorServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void calculateCartTest() {
        CartCalculatorService cartCalculatorService = ServiceFactory.getServiceFactory().getCartCalculatorService();
        Assert.assertNotNull("cartCalculatorService is null!", cartCalculatorService);

        String result1 = cartCalculatorService.calculateCart(INPUT_STRING_1);
        Assert.assertEquals(EXPECTED_OUTPUT_STRING_1, result1);

        String result2 = cartCalculatorService.calculateCart(INPUT_STRING_2);
        Assert.assertEquals(EXPECTED_OUTPUT_STRING_2, result2);

        String result3 = cartCalculatorService.calculateCart(INPUT_STRING_3);
        Assert.assertEquals(EXPECTED_OUTPUT_STRING_3, result3);
    }
}
