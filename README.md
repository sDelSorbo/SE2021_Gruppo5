# Scientific Programmable Calculator -  Group 5

Application implementing a
scientific programmable calculator
supporting complex numbers
based on Java

## Members
- Marco Pastore
- Giovanni Paolo Tobia
- Roberto Catania
- Salvatore del Sorbo


## Documents
- [Trello Board](https://trello.com/b/pMJVqzBj/complex-calculator)
- [ProductBacklog on GoogleSheet](https://docs.google.com/spreadsheets/d/14UquHFHBIGx-HTueg0Jz7TeBvM6C4fpM-KOCCMaoxsU/edit#gid=0)
- [FirstSprintPlanning on GoogleSheet](https://docs.google.com/spreadsheets/d/14UquHFHBIGx-HTueg0Jz7TeBvM6C4fpM-KOCCMaoxsU/edit#gid=623614192)
- [Dod, Dof](https://docs.google.com/spreadsheets/d/14UquHFHBIGx-HTueg0Jz7TeBvM6C4fpM-KOCCMaoxsU/edit#gid=1751564930)
- [Software Architecture](https://docs.google.com/document/d/1LJW1D86G4Fjmwc3ORH5G7jr4w8MLYj2CTo4fMrzn9iU/edit)

## Getting Started
If you want to start to use the calculator, you must insert inside the text area a complex number in cartesian notation, or using the keyboard and than press enter, or using the bottons present on the interface and than press "=". Than the number is shown in the stack table, in this way it is possible to continue performing the operations on the numbers present in the stack (For the operation that require two operands it's necessary that the stack has at least two elements).

<img width="703" alt="Schermata 2021-12-12 alle 10 25 53" src="https://user-images.githubusercontent.com/86788672/145707131-369e27a2-cf59-4879-bc09-6b2e15ab059f.png">


![prova1](https://user-images.githubusercontent.com/86788672/145712129-864cd70d-351e-43f2-85dc-629ea227e027.gif)


# GUI Components
 - 2 Table view (Fort the stack and for the user defined operations)
 - 36 bottons for the operations
 - 1 Botton to extend the calculator 
 - 3 Botton to manage the user defined operations
 - 2 Labels
 - 3 Text box (for the name of the user defined operation, for the insert of complex number and for the value of the variables)
 - 1 Text area (for the list of operations)
 - 1 Combo box to select the variables
 - 1 menu bar (Containing the features to save and restore variables, to export and import the user defined operations, the manual, the possibility to use the dark mode, and the exit)

## Manual & Features
 • It is possible to enter complex numbers in the format a + bj.
 
 • The operations supported on complex numbers are +, -, *, /, sqrt to calculate the root, + - which reverses the sign, mod to calculate the modulus, arg to
   calculate the argument, exp to calculate the exponential, log to calculate the natural logarithm, sin for the sine, cos for the cos, tan for the tangent.
   
 • It is possible to operate on the stack, including: drop, which removes the element in the dup stack, which makes a copy of the last element
   stack, swap, which \ n swaps the last two elements of the stack; above what a copy of the penultimate element of the stack; or you can type the
   clear command to delete all elements from the stack.
   
 • By clicking the inv key, it is also possible to take advantage of the inverse trigonometric functions
 
 • '> x' to insert the value at the top of the stack into the variable.
 
 • '<x' to insert the value into the variable at the top of the stack.
 
 • '+ x' to add the value at the top of the stack to the variable.
 
 • '-x' to subtract the value at the top of the stack from the variable.
 
 • By pressing the Expand key you can enter programmable operations.
 
 • To insert programmable operations it is necessary to define \ n a name and a list of operations separated by a space.
 
 • The programmable operations can be removed by typing the name of the operation to be deleted and clicking on the remove button or by selecting an operation
   from the table and right clicking.
 
 • The programmable operations can be modified by typing the name of the operation to be deleted and clicking on the modify button or by double clicking on
   an operation directly from the table.
   
 <img width="703" alt="Schermata 2021-12-12 alle 10 44 47" src="https://user-images.githubusercontent.com/86788672/145707692-99003f00-8ca7-4fdf-a0cc-93e48c575269.png">

Clicking on the extend bottton, the calculator shows the section to define the customize operations.

<img width="1163" alt="Schermata 2021-12-12 alle 10 45 49" src="https://user-images.githubusercontent.com/86788672/145707694-80f7f3f3-a5e8-4979-809b-271ec87d42d4.png">

Example of usage.

![prova2](https://user-images.githubusercontent.com/86788672/145711985-3957d8f9-cee7-4546-94ea-019fd05447a4.gif)


In the menu bar into the File menu, there is the possibility to export or import the user defined operations, in order to save and restore new and old operations.

<img width="260" alt="Schermata 2021-12-12 alle 11 02 32" src="https://user-images.githubusercontent.com/86788672/145708111-fbcb8715-3c0f-470b-b2d4-0f569cbc685d.png">                          <img width="260" alt="Schermata 2021-12-12 alle 11 02 42" src="https://user-images.githubusercontent.com/86788672/145708115-718b13c2-313d-4a32-a645-0eacbfea699e.png">
