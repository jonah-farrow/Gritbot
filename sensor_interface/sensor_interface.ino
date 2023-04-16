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
#include <DFRobot_DHT11.h>
#define DHT11_PIN 15

DFRobot_DHT11 DHT;
BH1750 lightMeter;

void setup() {
  Serial.begin(115200);

  // Initialize the I2C bus (BH1750 library doesn't do this automatically)
  Wire.begin();
  // On esp8266 you can select SCL and SDA pins using Wire.begin(D4, D3);
  // For Wemos / Lolin D1 Mini Pro and the Ambient Light shield use
  // Wire.begin(D2, D1);

  lightMeter.begin();

  
}

void loop() {
  float lux = lightMeter.readLightLevel();
  Serial.print("Light: ");
  Serial.print(lux);
  DHT.read(DHT11_PIN);
  Serial.print("  Temp:");
  Serial.print(DHT.temperature);
  Serial.print("  Humi:");
  Serial.print(DHT.humidity);
  Serial.println("  ");
  delay(1000);
}
