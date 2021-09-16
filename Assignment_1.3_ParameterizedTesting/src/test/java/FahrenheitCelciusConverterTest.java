import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class FahrenheitCelciusConverterTest {

    private int VALID_CELSIUS;
    private int VALID_FAHRENHEIT;

    /**
     * @verifies convert celsius to fahrenheit
     * @see FahrenheitCelciusConverter#toFahrenheit(int)
     */
    @ParameterizedTest
    @ValueSource(ints = {32,98,212})
    public void toFahrenheit_shouldConvertCelsiusToFahrenheit(int fahrenheit){
        FahrenheitCelciusConverter fcc = new FahrenheitCelciusConverter(VALID_CELSIUS, fahrenheit);

//        assertThat(fcc.toFahrenheit(0)).isEqualTo(32);
//        assertThat(fcc.toFahrenheit(37)).isEqualTo(98);
//        assertThat(fcc.toFahrenheit(100)).isEqualTo(212);
        assertThat(fcc.toFahrenheit(VALID_CELSIUS)).isEqualTo(fahrenheit);
    }

    /**
     * @verifies convert fahrenheit to celsius
     * @see FahrenheitCelciusConverter#toCelsius(int)
     */
    @ParameterizedTest
    @ValueSource(ints = {0,37,100})
    public void toCelsius_shouldConvertFahrenheitToCelsius(int celsius) {
        FahrenheitCelciusConverter fcc = new FahrenheitCelciusConverter(celsius, VALID_FAHRENHEIT);

        assertThat(fcc.toCelsius(VALID_FAHRENHEIT)).isEqualTo(celsius);
    }
}