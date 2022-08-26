# JAVAFX-controller-for-LED-Strips
### INTRODUCTION

LED light strips have been one of the most popular trends among teenagers while the actual strip
could be affordable, when the package comes with a small remote controller it can cost up to a
hundred dollars!
In this report, I am going to demonstrate how to control LED light strips without a remote and
have a more wide variety of color types and patterns with the help of the Arduino grove board
and java platform.

### CONTEXT:

By staring the pandemic around the world while the industrial usage of electricity decreased the
residential usage of electric increased significantly. One of the main is the reason of this increase
is the house lighting. LED strips can be a good substitution for a place that does not need high
bright light intensity in a household. For example, the rooms, bathroom, and even the kitchen can
be a good placement for LED strips. Since they use less energy comparing to regular lighting
resources and they are environmentally friendly they can be a suitable option for making a house
more modern or even saving money on electricity bills[1].
While LED strips by themselves can have a reasonable price which can be used in large areas
when they contain the remote the price start to going up significantly which can be one of the
reasons that people rather buy the regular lighting recourse.
I decided to make a software controller for this LED strip which can be beneficial in two ways
first the overall price would decrease to almost one-fourth of a LED strip with a controller and
secondly it will give the household a chance to get one step closer to being environmentally
friendly.

### TECHNICAL REQUIREMENTS / SPECIFICATIONS

- The system is able to change the color of the LED strip into :
    - Blue
    - Green
    - Rainbow cycle
    - Chasing white
- The system is able to change the light intensity by moving the slider.
- The system can be turn off by the "OFF" button on the java controller.
- The system is able to display the name of the color of the led strip during each occasion
    
    on the OLED screen.
    
    - Is important to note the LED strip needs to be 5 volts so it would not need any transistor for its
    circuit.
    - It is preferable to use an extra voltage resource instead of getting the voltage from the board.
    This reduces the chance of burning either the LED strip or the board.
    
    ### COMPONENTS LIST:

Physical components

- Arduino grove board
- wire jumpers ( male to male ) x3
- LED Light strip WS2812B RGB 5050SMD-
    
    DC5V
    

Software components :

- Arduino
- Java

### PROCEDURE:
First, the wiring of the system needs to be completed the LED strip includes three main wires 5v, GND, and Din.
the LED strip would be connected to a male jumper and the male jumper would connect the board to the LED strip.
The 5v pin has been connected to the 5v on the grove board and the GND has been connected to the GND pin on the board.
The Din will be connected to an analog output-9~- that is not currently in use ( PIN 9).
By using Adafruit_NeoPixel.h and U8x8lib.h we will import an important component that we need to work with.
Moreover, I used an online resource to find some general pattering for my colors such as rainbow patterns and chasing white.
After testing the online resource code and making sure the LED strip turn on and work. I started to set up my java code for the remote controller.
First I imported the essential library of JavaFX and added my VM option.
I made 6 new objects as a button and within try and catch of each button, I specified a byte value to be sent to the Arduino when the mouse is pressed. Furthermore, for the first three colors, I changed the background of the button with help of CSS code and button.setStyle().
As the last part of the Java main class, I set up a slider with a minimum value of zero and a maximum value of 100; then in the try and catch, I specified two different bytes to be sent to Arduino in the case that either slider value is more than 50 or less than 50.
Moreover, I added the SerialPortSerice class to make the bridge of connection between Arduino and java. Going back to Arduino I started my condition statement for each case of receiving data from java. each button case has two outputs: the name of the color that displays on OLED and the change is LED strip color.
finally, I set up the two values that initialized for the slider in java to change my setup brightness accordingly.


