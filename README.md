 1. Encapsulation

* **Data Hiding:** The core data fields (`balance`, `accountNumber`, `transactionHistory`) are declared using the **`private`** access modifier.
* **Protection:** This prevents external code from directly modifying the account's state, safeguarding the data's integrity.
* **Controlled Access:** Changes to the `balance` can only happen through **`public`** methods (`deposit()`, `withdraw()`), which contain necessary **validation logic** (e.g., checking if funds are sufficient).

 2. Abstraction

* **Focus on Interface:** Abstraction hides complex implementation details, showing only the essential functionality.
* **Simplified Usage:** Users of the class interact with simple, high-level methods (e.g., `withdraw(amount)`). They don't need to know the specific underlying operations, such as the arithmetic subtraction, the balance check, or the process of updating the `transactionHistory` list.

3. Inheritance

* **Code Reusability:** The **`SavingsAccount`** class **`extends Account`**, establishing a logical parent-child relationship.
* **Shared Functionality:** `SavingsAccount` automatically inherits all public and protected attributes and methods (like `deposit()`, `withdraw()`, `getBalance()`) from the parent `Account` class.
* **Specialization:** The subclass adds its own unique behavior, such as the **`applyInterest()`** method, which is specific to a savings account, without having to rewrite the base account functionality. 

 4. Class and Object

* **Class (Blueprint):** `Account` and `SavingsAccount` are the **classes** that define the structure and behavior of a bank account.
* **Object (Instance):** The variables **`checking`** and **`savings`** created in the `main` method are the actual **objects** or instances of these classes, each holding its own unique `balance` and `transactionHistory`.

 5. Polymorphism (Potential)

* **Many Forms:** Although not fully demonstrated by method overriding in the current code, the inheritance structure lays the foundation for **polymorphism**.
* **Future Behavior:** A different subclass (e.g., `CheckingAccount`) could **override** the inherited `withdraw()` method to implement distinct behavior, such as allowing a small overdraft limit, while still being treated as a generic `Account` type.
