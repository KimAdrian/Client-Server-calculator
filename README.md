# Client-Server-calculator
Simple Client Server calculator <br/>
This is a modified version of the [ClientServer_echo_example](https://github.com/KimAdrian/ClientServer_echo_example) <br/>
The server has been modified to perform calculations based on the user input and send it back to the client side.<br/>
The client class still functions in a similar manner to the [echo client](https://github.com/KimAdrian/ClientServer_echo_example/blob/master/src/Client.java) <br/>
A majority of the changes were made to the Server class to enable it to perform simple calculations, i.e +,-,*,/ <br/>

### Changes

```java
//Use StringTokenizer to break the equation into operand and operation
StringTokenizer stringTokenizer = new StringTokenizer(inputLine);
float operandOne = Float.parseFloat(stringTokenizer.nextToken());
String operation = stringTokenizer.nextToken();
float operandTwo = Float.parseFloat(stringTokenizer.nextToken());
float result = 0;
//Perform required operation
switch (operation) {
    case "+":
        result = operandOne + operandTwo;
        break;
    case "-":
        result = operandOne - operandTwo;
        break;
    case "*":
         result = operandOne * operandTwo;
         break;
    case "/":
         result = operandOne / operandTwo;
         break;
}
System.out.println("Server: Answer = "+ result);
out.println(result);
```
### Explanation
The string <code>inputLine</code> will be received from the <code>Client</code> class. 
The <code>StringTokenizer</code> class will be used to split the received string into three parts; two operands and an operator.
The operator will determine the type of calculation to be performed on the two operands.
The choice of using a float for the operands was to accomodate for decimal values so as to increase accuracy.<br/>
#### Example
```
inputLine = 24 / 2
The StringTokenizer class will divide it as follows:
    float operandOne = 24.0;
    string operation = "/";
    float operandTwo = 2.0;
    
 With the three values obtained, the required operation will be performed via the switch statement. In this case:
    result = 24.0 / 2.0
    result = 12.0
    
After determining the result, the Server class will print the value to its console:
    Server: Answer = 12.0

The answer will then be sent back to the Client class to be displayed to the user via the out object
```
### Errors that may occur and what to do
if the inputLine string does not have whitespaces in between the operands, and the operator
the error below will occur
```
Exception in thread "main" java.lang.NumberFormatException: For input string: "24/2"
	at java.base/jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
	at java.base/jdk.internal.math.FloatingDecimal.parseFloat(FloatingDecimal.java:122)
	at java.base/java.lang.Float.parseFloat(Float.java:455)
	at Server.main(Server.java:25)
```
In the event that this occurs the server and client should be restarted, and the correct format used for the inputLine

|Correct format|Wrong format|
|:------------:|:----------:|
|1 + 1         |1+1         |
|1 - 1         | 1-1        |
|2 * 2         |2*2         |
|4 / 2         |4/2         |

