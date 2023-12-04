# JAVAFX Controller for LED Strips

## Introduction

LED light strips have become a popular trend among teenagers, providing an affordable lighting solution. However, when the package includes a remote controller, the overall cost can rise significantly, sometimes up to a hundred dollars. This report demonstrates how to control LED light strips without a remote, offering a broader range of color types and patterns using the Arduino Grove board and Java platform.

## Context

Amidst the global pandemic, residential electricity usage increased significantly, with house lighting being a major contributor. LED strips serve as an energy-efficient and environmentally friendly alternative for areas with lower light intensity requirements in households. To promote sustainability and reduce costs, this project aims to create a software controller for LED strips, eliminating the need for expensive remote controllers and bringing households closer to environmental friendliness.

## Technical Requirements / Specifications

- The system can change the LED strip's color to:
  - Blue
  - Green
  - Rainbow cycle
  - Chasing white
- The system adjusts light intensity via a slider.
- An "OFF" button on the Java controller turns off the LED strip.
- The system displays the LED strip's color name on the OLED screen during each occasion.

Note: The LED strip must be 5 volts, eliminating the need for additional transistors in its circuit. It's recommended to use an external voltage source instead of relying on the board to reduce the risk of damaging either the LED strip or the board.

## Components List

### Physical Components

- Arduino Grove board
- Male-to-male wire jumpers (x3)
- LED Light strip WS2812B RGB 5050SMD-DC5V

### Software Components

- Arduino
- Java

## Procedure

1. **Wiring:** Connect the LED strip's three main wires (5v, GND, Din) to male jumper wires. Connect the male jumper wires to the board, with 5v to the 5v pin and GND to the GND pin. Connect Din to an analog output (PIN 9).

2. **Code Import:** Use `Adafruit_NeoPixel.h` and `U8x8lib.h` to import essential components for working with LED strips.

3. **Pattern Setup:** Find and test online resources for color patterns such as rainbow and chasing white.

4. **Java Code Setup:**
   - Import JavaFX library and set VM options.
   - Create buttons for each color, and specify byte values to be sent to Arduino on mouse press.
   - Implement CSS code to change button background colors for the first three colors.
   - Set up a slider with values from 0 to 100, specifying byte values for slider positions.
   - Use the `SerialPortService` class for the connection between Arduino and Java.

5. **Arduino Code:**
   - Implement condition statements for each case of receiving data from Java.
   - For each button, display the color name on the OLED and change the LED strip color.
   - Adjust LED strip brightness based on Java slider values.

## References

- James Andrew Smith, Associate Professor, Department of Electrical Engineering and Computer Science, Lassonde School of Engineering
- Eric Prandovszky, Laboratory Technologist, Department of Electrical Engineering and Computer Science, Lassonde School of Engineering

Feel free to use and modify the code to enhance your LED strip control experience! If you have any questions or feedback, please reach out to us.
