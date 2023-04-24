/*

Example of BH1750 library usage.

This example initialises the BH1750 object using the default high resolution
continuous mode and then makes a light level reading every second.

Connections

  - VCC to 3V3 or 5V
  - GND to GND
  - SCL to SCL (A5 on Arduino Uno, Leonardo, etc or 21 on Mega and Due, on
    esp8266 free selectable)
  - SDA to SDA (A4 on Arduino Uno, Leonardo, etc or 20 on Mega and Due, on
    esp8266 free selectable)
  - ADD to (not connected) or GND

ADD pin is used to set sensor I2C address. If it has voltage greater or equal
to 0.7VCC voltage (e.g. you've connected it to VCC) the sensor address will be
0x5C. In other case (if ADD voltage less than 0.7 * VCC) the sensor address
will be 0x23 (by default).

*/

#include <BH1750.h>
#include <Wire.h>
// #include <DFRobot_DHT11.h>
// #define DHT11_PIN 15
#include <SPI.h>
#include <Adafruit_Sensor.h>
#include <Adafruit_BME280.h>

//DFRobot_DHT11 DHT;
BH1750 lightMeter;

#define BME_SCK 5
#define BME_MISO 18
#define BME_MOSI 19
#define BME_CS 4

#define SEALEVELPRESSURE_HPA (1013.25)

Adafruit_BME280 bme(BME_CS, BME_MOSI, BME_MISO, BME_SCK); // software SPI

unsigned long delayTime;

void setup() {
  Serial.begin(9600);
  unsigned status;
  // Initialize the I2C bus (BH1750 library doesn't do this automatically)
  Wire.begin();
  bme.begin(); 

  // Serial.print("Temperature = ");
  // Serial.print(bme.readTemperature());
  // Serial.println(" °C");
  
  // On esp8266 you can select SCL and SDA pins using Wire.begin(D4, D3);
  // For Wemos / Lolin D1 Mini Pro and the Ambient Light shield use
  // Wire.begin(D2, D1);

  lightMeter.begin();

  // float lux = lightMeter.readLightLevel();
  // Serial.println("");
  // Serial.print("Light: ");
  // Serial.println(lux);
  
  // Serial.print("Humidity = ");
  // Serial.print(bme.readHumidity());
  // Serial.println(" %");
}

void loop() {
    float lux = lightMeter.readLightLevel();
    Serial.println("");
    Serial.print("Light: ");
    Serial.println(lux);

    Serial.print("Temperature = ");
    Serial.print(bme.readTemperature());
    Serial.println(" °C");

    Serial.print("Humidity = ");
    Serial.print(bme.readHumidity());
    Serial.println(" %");
  
    Serial.println();
    delay(1000);
}
