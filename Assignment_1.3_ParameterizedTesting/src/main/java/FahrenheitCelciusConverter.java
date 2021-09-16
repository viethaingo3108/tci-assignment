public class FahrenheitCelciusConverter {
    private int celsius;
    private int fahrenheit;

    public FahrenheitCelciusConverter(int celsius, int fahrenheit) {
        this.celsius = celsius;
        this.fahrenheit = fahrenheit;
    }

    public int getCelsius() {
        return celsius;
    }

    public int getFahrenheit() {
        return fahrenheit;
    }

    /**
     * @should convert celsius to fahrenheit*/
    public int toFahrenheit(int celsiusNumber){
        fahrenheit = (9/5)*celsiusNumber + 32;
        return fahrenheit;
    }

    /**
     * @should convert fahrenheit to celsius*/
    public int toCelsius(int fahrenheitNumber){
        celsius = (fahrenheitNumber-32)*(5/9);
        return celsius;
    }
}
