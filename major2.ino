#include <Adafruit_NeoPixel.h>
 # include <U8x8lib.h>
#ifdef __AVR__
#include <avr/power.h>
#endif
#define REDLED 4
#define PIN 9
#include <Arduino.h>
#include <U8x8lib.h>
 auto display = U8X8_SSD1306_128X64_NONAME_HW_I2C ( U8X8_PIN_NONE ) ;

Adafruit_NeoPixel strip = Adafruit_NeoPixel(120, PIN, NEO_GRB + NEO_KHZ800);
void setup() {
   display.begin();
 display.setFlipMode(0);
 display.clearDisplay();
   Serial.begin(9600);
   strip.begin();
  strip.setBrightness(40);
  strip.show(); 
}
void val() {
  const auto  value = analogRead(PIN);
    const byte data[] = {0, 0, highByte(value), lowByte(value)};

    Serial.write(data, 4);
    Serial.println();  }

void loop() {

  display.setFont(u8x8_font_profont29_2x3_r);
 display.setCursor(0, 0);
const auto receivedData = Serial.read();

  if ( receivedData == 255){
    display.clearDisplay();
   display.print("BLUE");
   return colorWipe(strip.Color(0, 0, 255), 50); // Blue
  }else if( receivedData ==127){
    display.clearDisplay();
    display.print("RED");
   return colorWipe(strip.Color(255, 0, 0), 50); // Red
  }else if(receivedData==63){
    display.clearDisplay();
    display.print("GREEN");
   return colorWipe(strip.Color(0, 255, 0), 50); // Green
  }else if (receivedData==31){
    display.clearDisplay();
    display.print("RAINBOW");
    rainbow(20);
  }else if(receivedData==15){
    display.clearDisplay();
    display.print("WHITE");
    return theaterChase(strip.Color(127, 127, 127), 50); // White
 
    }
    
 else if (receivedData==23){
  display.clearDisplay();
    display.print("BYE!");
  return colorWipe(strip.Color(0, 0, 0), 50); // Green
 } else if(receivedData==9){
  strip.setBrightness(40);
    
   }else if(receivedData==7)
   strip.setBrightness(5);
  else {
    (REDLED, HIGH);
  }
}
 
void colorWipe(uint32_t c, uint8_t wait) {
  for(uint16_t i=0; i<strip.numPixels(); i++) {
    strip.setPixelColor(i, c);
    strip.show();
    delay(wait);
  }
}
void rainbow(uint8_t wait) {
  uint16_t i, j;

  for(j=0; j<256; j++) {
    for(i=0; i<strip.numPixels(); i++) {
      strip.setPixelColor(i, Wheel((i+j) & 255));
    }
    strip.show();
    delay(wait);
  }
}
uint32_t Wheel(byte WheelPos) {
  WheelPos = 255 - WheelPos;
  if(WheelPos < 85) {
    return strip.Color(255 - WheelPos * 3, 0, WheelPos * 3);
  }
  if(WheelPos < 170) {
    WheelPos -= 85;
    return strip.Color(0, WheelPos * 3, 255 - WheelPos * 3);
  }
  WheelPos -= 170;
  return strip.Color(WheelPos * 3, 255 - WheelPos * 3, 0);
}
void theaterChase(uint32_t c, uint8_t wait) {
  for (int j=0; j<10; j++) {  
    for (int q=0; q < 3; q++) {
      for (uint16_t i=0; i < strip.numPixels(); i=i+3) {
        strip.setPixelColor(i+q, c);  
      strip.show();

      delay(wait);

      for (uint16_t i=0; i < strip.numPixels(); i=i+3) {
        strip.setPixelColor(i+q, 0);      
      }
    }
  }
}
