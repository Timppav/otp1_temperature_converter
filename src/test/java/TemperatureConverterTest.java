import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {
    TemperatureConverter tc = new TemperatureConverter();

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0, tc.fahrenheitToCelsius(32.0));
        assertEquals(100, tc.fahrenheitToCelsius(212.0));
    }

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, tc.celsiusToFahrenheit(0.0));
        assertEquals(212.0, tc.celsiusToFahrenheit(100.0));
    }

    @Test
    void testKelvinToCelsius() {
        assertEquals(26.85, tc.kelvinToCelsius(300.0));
        assertEquals(-273.15, tc.kelvinToCelsius(0.0));
    }

    @Test
    void testCelsiusToKelvin() {
        assertEquals(300.0, tc.celsiusToKelvin(26.85));
        assertEquals(0.0, tc.celsiusToKelvin(-273.15));
    }

    @Test
    void testIsExtremeTemperature() {
        assertFalse(tc.isExtremeTemperature(20.0));
        assertTrue(tc.isExtremeTemperature(100.0));
        assertTrue(tc.isExtremeTemperature(-50.0));
    }
}