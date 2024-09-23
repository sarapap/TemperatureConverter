
public class TemperatureConverter {

    /**
     * Converts Fahrenheit to Celsius.
     *
     * @param fahrenheit The temperature in Fahrenheit.
     * @return The temperature in Celsius.
     */
    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    /**
     * Converts Celsius to Fahrenheit.
     *
     * @param celsius The temperature in Celsius.
     * @return The temperature in Fahrenheit.
     */
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    /**
     * Checks if the given Celsius temperature is extreme.
     *
     * @param celsius The temperature in Celsius.
     * @return True if the temperature is below -40 or above 50, otherwise false.
     */
    public boolean isExtremeTemperature(double celsius) {
        return celsius < -40 || celsius > 50;
    }

    public static float kelvinToCel(float kel){
        return (float) (kel - 273.15);
    }

    public static  double	kelvinToFah(double kel) {
        return Math.round((kel-273.15)* (9/5) + 32);
    }

    public static void main(String[] args) {
        TemperatureConverter converter = new TemperatureConverter();
        System.out.println(converter.fahrenheitToCelsius(32));
        System.out.println(converter.fahrenheitToCelsius(212));
        System.out.println(converter.fahrenheitToCelsius(-40));
        System.out.println(converter.celsiusToFahrenheit(0));
        System.out.println(converter.celsiusToFahrenheit(100));
        System.out.println(converter.celsiusToFahrenheit(-40));
        System.out.println(converter.isExtremeTemperature(-50));
        System.out.println(converter.isExtremeTemperature(20));
        System.out.println(converter.isExtremeTemperature(60));
        System.out.println(TemperatureConverter.kelvinToCel(273.15F));
        System.out.println(TemperatureConverter.kelvinToFah(273.15));
    }
}
