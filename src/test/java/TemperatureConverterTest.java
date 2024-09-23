
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TemperatureConverterTest {


    private TemperatureConverter converter;

    @BeforeEach
    public void setUp() {
        converter = new TemperatureConverter();
    }

    @Test
    void fahrenheitToCelsius() {
        Assertions.assertEquals(0, converter.fahrenheitToCelsius(32), 0.01);
        Assertions.assertEquals(100, converter.fahrenheitToCelsius(212), 0.01);
        Assertions.assertEquals(-40, converter.fahrenheitToCelsius(-40), 0.01);
    }

    @Test
    public void testCelsiusToFahrenheit() {
        Assertions.assertEquals(32, converter.celsiusToFahrenheit(0), 0.01);
        Assertions.assertEquals(212, converter.celsiusToFahrenheit(100), 0.01);
        Assertions.assertEquals(-40, converter.celsiusToFahrenheit(-40), 0.01);
    }

    @Test
    public void testIsExtremeTemperature() {
        Assertions.assertTrue(converter.isExtremeTemperature(-50));
        Assertions.assertFalse(converter.isExtremeTemperature(20));
        Assertions.assertTrue(converter.isExtremeTemperature(60));
    }

    @Test
    public void testKelvinToCel() {
        Assertions.assertEquals(0.0, TemperatureConverter.kelvinToCel(273.15F), 0.001);
    }

    @Test
    public void testKelvinToFah() {
        Assertions.assertEquals(32.0, TemperatureConverter.kelvinToFah(273.15), 0.001);
    }

}
