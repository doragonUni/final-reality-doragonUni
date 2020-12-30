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
**Versión Tarea3**
**COMO JUGAR**
Bienvenido a Final Reality version creada por Lung Pang Wang.
## Inicio
Para ejecutar el programa porfavor presionar el boton Run haciendo click derecho en el archivo FinalReality.java una vez "runeado", debería aparecer una Ventana con un Menú con el título "Main menu Final Reality Beta" y aparecerán 3 botones; Character Menu, Weapon Menu y Start Game!. Porfavor no presionar Start Game si no ha creado sus personajes ni les ha equipado un arma, ya que si presiona el boton antes de tiempo no tendrá ningún efecto pues no estaría cumpliendo los requisitos para empezar el juego. Si no estan las condiciones el botón no hará nada. 
*Creación de personajes y enemigos*
Si presiona Character Menu, cambiará a una escena donde podrá crear hasta 4 personajes para su equipo donde cada personaje deberá asignarle el nombre, hp, defensa (recomiendo altamente que el nombre sea el mismo que el tipo del personaje, i.e si vas a crear un Knight, para comodidad podría llamarlo Knight para que la sección de equipamiento no pierda el tiempo). También, tendrá que decir la cantidad numérica hasta 5 para la creación de enemigos, si intenta crear por ejemplo 6,7, etc. solo se crearán 5. Por otra parte, si ya tiene los 4 personajes creados no podrá crear más. Los enemigos al crearse su hp, defensa, daño y peso son de manera aleatoria. (No es la idea que el jugador pueda crear enemigos a gusto de él).
## Creación de armas
Luego deberá volver al menu con el bottón Back para ir al Weapon Menu presionando el boton con este mismo nombre, el inventario tendrá hasta 10 slots disponibles, es decir si crea 10 y luego quiere crear uno más no podrá hacerlo por el límite de esta, pero si tiene 10 items en el inventario y realiza algún equipamiento podrá crear otra arma y se le va a agregar al inventario, es decir podría tener hasta un total de 15 armas. (Al igual que la creación de personajes, recomiendo altamente que el nombre del arma sea el mismo que el tipo de esta, i.e si vas a crear un Staff, para comodidad podría llamarlo Staff para que la sección de equipamiento no pierda el tiempo). En la creación de armas el daño y el peso al igual que los enemigos también son de manera aleatoria pero por ejemplo el Sword tiene mayores puntos de daño y peso que el Staff por dar un ejemplo. (De manera análoga tampoco es la idea que el jugador pueda crearse armas super poderosas) 
## Equipamiento
Luego de haber creado los personajes, la cantidad de enemigos y las armas que necesita, deberá equiparselas a sus jugadores con el botón View Line Up presente tanto en la seleción de personajes como creación de armas para poder ver su equipo y los enemigos. En esta parte es fundamental que escoja las mejores armas para poder llevarse la victoria debido a que si un personaje tiene defensa 10 y su arma tiene un daño menor al de la defensa del objetivo su personaje no le inflinjirá daño.
*Empezar el juego*
Recuerde, como se menciona al inicio, el juego no empezará si es que no estan todos sus jugadores equipados, tampoco empezará si es que tiene menos de 4 jugadores o si es que no ha creado ningun enemigo, por lo tanto es fundamental que cree los personajes, las armas y fije la cantidad de enemigos, recuerde también que un personaje no puede equiparse todos los tipos sino que tiene una cantidad limitada, por ejemplo el Black Mage solo podrá equiparse el Knife y el Staff si y si quiere intentar equiparle un Axe, Bow, Sword el juego no lo dejará tampoco.
Una vez cumplido los requisitos si presiona el botón Start Game! podrá empezar a jugar, en el display del centro superior de la ventana, tendrá un visor donde se le indicará de quién es el turno, como los enemigos atacan de manera instantánea usted podrá ver el último ataque realizado por ellos cuando le toca a usted, tenga ojo que podría existir que 2 enemigos distintos ataquen antes que usted (debido a sus velocidades y pesos) y en este caso solo se verá el último enemigo que realizó el ataque. Cuando sea su turno podrá volver al inventario y cambiar las armas equipadas y luego realizar un Ataque para terminar su turno. Su turno solo puede terminar cuando realice un ataque de lo contrario el juego esperará a que realice uno. Para atacar tendrá abajo en el cuadro inferior una entrada de Texto para que usted escriba el nombre del enemigo (por lo general, los enemigos se llaman enemy0, enemy1,...,enemy4) tendrá que escribir el nombre, por ejemplo enemy0 y luego presionar el botón atacar para realizar el ataque. Aviso, cuando usted o la CPU logren acabar con la vida de un personaje/enemigo, en el display aparecerá que el jugador está "dead" y si por algun motivo usted quisiera atacar un enemigo muerto no podrá hacerlo no perderá el turno pero sí su tiempo, asi que porfavor mire bien el display antes de atacar a su objetivo. Los enemigos por su parte solamente escogen automáticamente un personaje vivo de su party
## Fin del juego
Usted ganará si es que logra matar a todos los enemigos y perderá si se le mueren sus personajes. Si gana deberá aparecer un fondo y un sonido de victoria, si pierde le aparecerá otro fondo de tonalidad morada y sin sonido. En ambos casos tendrá 2 opciones; Exit y Play Again. Exit lo que hace es cerrar la ventana y Play Again inicia otro juego, pero para este caso sus personajes desaparecerán por lo que tendrá que crear las armas, enemigos, personajes y equiparle las armas nuevamente. Por ejemplo si es que encontró que la partida estuvo muy fácil, podría disminuir el Hp y la Defensa de sus jugadores ó si encontró el juego muy dificil podría aumentar su hp y su defensa para un mayor aguante.


---
**Agradecimientos y miceláneos**
Utilicé una escena del anime Dr. Stone para la escena de creación de armas, para el equipamiento utilicé el fondo de la pelicula Kimi no na Wa, para los sonidos todos fueron "samples" gratuitos extraidos de Youtube y para la escena de Victoria créditos a Fornite con su logotipo Victory Royale



---
**Version Tarea2**


Corrección de errores de la entrega previa, implementación del ataque  y equipamiento de armas usando Double Dispatch, se agrega
el controlador el cual es capaz de crear los objetos del modelo, conocer sus datos y manipular el inventario y los ataques. Adicionalmente se 
crea el patrón de diseño Observer Pattern para avisar cuando un jugador queda fuera de combate. Finalmente el controlador también sabrá cuando empieza
el turno con el método beginTurn() y el fin con endTurn() el cual es llamado después de realizar un ataque.

Puede ver en el Changelog.md seccion **VERSION 3.0 TAREA 2** los cambios explícitos para esta entrega.

---

**Version Tarea1**


Se modifica el package Model con tal de respetar los principios SOLID, teniendo esto en cuenta, lo que se hizo fue eliminar las enumeraciones debido a que limitan la extensibilidad del código a un futuro, luego se divide el método waitTurn() debido a que no estaba implendado bajo el principio de Single responsability por lo que se decide a bajarlo a cada clase correspondiente.
Se crean las clases de cada tipo y se les agregan los atributos restantes a los PlayerCharacters y a Enemy
Los Weapons por su parte, tambien se eliminan las enumeraciones y se crean las clases independientes de cada arma además que se agregan las clases IWeapon y AbstractWeapon que vienen a reemplazar la implementación de la clase Weapon.

Puede ver en el Changelog.md seccion **VERSION 2.0 TAREA 1** los cambios explícitos para esta entrega.







