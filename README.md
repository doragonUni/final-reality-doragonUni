Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---

**Version Tarea1**


Se modifica el package Model con tal de respetar los principios SOLID, teniendo esto en cuenta, lo que se hizo fue eliminar las enumeraciones debido a que limitan la extensibilidad del código a un futuro, luego se divide el método waitTurn() debido a que no estaba implendado bajo el principio de Single responsability por lo que se decide a bajarlo a cada clase correspondiente.
Se crean las clases de cada tipo y se les agregan los atributos restantes a los PlayerCharacters y a Enemy
Los Weapons por su parte, tambien se eliminan las enumeraciones y se crean las clases independientes de cada arma además que se agregan las clases IWeapon y AbstractWeapon que vienen a reemplazar la implementación de la clase Weapon.


Puede ver en el Changelog.md seccion **VERSION 2.0 TAREA 1** los cambios explícitos para esta entrega.





