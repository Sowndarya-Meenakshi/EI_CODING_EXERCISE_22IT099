# Student Fee Calculation System - Decorator Design Pattern

This Java project demonstrates the **Decorator Design Pattern** for dynamically calculating student fees by adding optional components like hostel, sports, and scholarship discounts to a base tuition fee. Decorators wrap the fee object to extend functionality without subclassing, allowing flexible fee composition.


**Code Structure:**
- **FeeComponent.java**: Component interface defining getFee() and getDescription() methods.
- **TuitionFee.java**: Concrete component implementing base tuition fee.
- **FeeDecorator.java**: Abstract decorator class wrapping FeeComponent, delegating calls.
- **HostelFeeDecorator.java**: Concrete decorator adding hostel fee to the total.
- **SportsFeeDecorator.java**: Concrete decorator adding sports fee to the total.
- **ScholarshipDiscountDecorator.java**: Concrete decorator applying discount, ensuring non-negative total.
- **Main.java**: Console application for user input, fee composition via decorators, and output display.

**How to Run:**
1. Compile: `javac -d bin Main.java src/**/*.java`
2. Run: `java -cp bin Main`
3. Follow prompts: Enter tuition, add fees/discounts (y/n), view breakdown.

