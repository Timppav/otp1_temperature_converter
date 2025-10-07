public class TemperatureConverter {
    public double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5 / 9;
        return Math.round(celsius * 100) / 100.0;
    }

    public double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (celsius * 9) / 5 + 32;
        return Math.round(fahrenheit * 100) / 100.0;
    }

    public double kelvinToCelsius(double kelvin) {
        double celsius = kelvin - 273.15;
        return Math.round(celsius * 100) / 100.0;
    }

    public double celsiusToKelvin(double celsius) {
        double kelvin = celsius + 273.15;
        return Math.round(kelvin * 100) / 100.0;
    }

    public boolean isExtremeTemperature(double celsius) {
        return celsius > 50 | celsius < -40;
    }
}
