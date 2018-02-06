package quiz10;

import static org.junit.Assert.*;

import org.junit.Test;

public class EnglishToMetricConverterTester {

    @Test
    public void testFreezingConversion() {
        EnglishToMetricConverter e = new EnglishToMetricConverter();
        final double freezingF = 32.0;
        final double freezingC = 0.0;
        assertEquals(e.convertTemperature(freezingF), freezingC, 0.0001);        
    }

    @Test
    public void testBoilingConversion() {
        EnglishToMetricConverter e = new EnglishToMetricConverter();
        final double boilingF = 212.0;
        final double boilingC = 100.0;
        assertEquals(e.convertTemperature(boilingF), boilingC, 0.0001);        
    }
    
    @Test
    public void testConverter() {
    	EnglishToMetricConverter e = new EnglishToMetricConverter();
    	final double f = -40.0;
    	final double c = -40.0;
    	assertEquals(e.convertTemperature(f), c, 0.0001);
    }

    @Test
    public void testKmConverter() {
    	EnglishToMetricConverter e = new EnglishToMetricConverter();
    	final double m = 1.0;
    	final double km = 1.609;
    	assertEquals(e.convertDistance(m), km, 0.0001);
    }
    
    @Test
    public void testKmConverter2() {
    	EnglishToMetricConverter e = new EnglishToMetricConverter();
    	final double m = 5.25;
    	final double km = 5.25 * 1.609;
    	assertEquals(e.convertDistance(m), km, 0.0001);
    }
    
    @Test
    public void testKgConverter() {
    	EnglishToMetricConverter e = new EnglishToMetricConverter();
    	final double lb = 2.2;
    	final double kg = 1;
    	assertEquals(e.convertWeight(lb), kg, 0.0001);
    }
    
    @Test
    public void testKgConverter2() {
    	EnglishToMetricConverter e = new EnglishToMetricConverter();
    	final double lb = 220.0;
    	final double kg = 220.0 / 2.2;
    	assertEquals(e.convertWeight(lb), kg, 0.0001);
    }
}
