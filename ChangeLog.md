ChangeLog
=========


Version 3.0 TAREA 2
-------------------
(B.1)Notas de la VERSION TAREA 2:
(B.1)Se hicieron los siguientes cambios en el modelo:
(B.1)Se crea la clase AbstractMage y IMage
(B.1)Se corrigen los cambios de la Tarea 1
(B.1)Se crea el ataque con double dispatch
(B.1)se crea el equip con double dispatch 
(B.1)Se agregan los addListener para notificar la muerte al controller

(B.1)Se agrega la clase Controller:
(B.2)Capacidad de crear objetos del modelo
(B.3)Capacidad de "gettear" los atributos de los IChacters
(B.4)Creación del inventario + manipulación de esta
(B.5)Se crea el Observer para notificar la muerte de enemigos y playerChacters
(B.6)Inicio de turno con BeginTurn()
(B.7)Para saber el fin del turno se llama a endTurn() después de realizar un ataque
(B.8)Notificación de victoria cuando se muerten todos los enemigos
(B.9)Notificación de derrora cuando se muere toda la party


Version 2.0 TAREA 1
-------------------
Notas de la VERSION TAREA 1: Se hicieron los siguientes cambios:

CAMBIOS GLOBALES:

(B.1)SE ELIMINAN LAS ENUMERACIONES TANTO PARA WEAPON Y CHARACTER
(B.2)SE ACUTALIZAN LOS EQUALS Y HASHCODE DE ACUERDO A LA CLASE EN CUESTIÓN
(B.3)SE CREAN LOS GETTERS DE LOS ATRIBUTOS
CAMBIOS A CHARACTER

(B.1) Class Enemy extends AbstractCharacter PASA A Class Enemy implements ICharacter
(B.2)Se crean las 5 clases: Knight, Thief, Engineer, BlackMage, WhiteMage. Todas implementan AbstractCharacter
(B.3)Se añaden nuevos atributos: Hp, Defense a toda clase que implemente ICharacter
(B.4) Se añade atributo mana a BlackMage, WhiteMage
(B.5) POR EL MOMENTO Se añaden los equipBow, equipSword, equipKnife, equipStaff, equipAxe y se implementan en las clases correspondientes.
(B.6) waitTurn(), addtoQueue() y los getters de HP, DEF son agregados a la interfaz
(B.7) por (B.6) la clase Enemy y Abstract Character implementan sus propios waitTurn(), addtoQueue()
CAMBIOS A WEAPON

(B.1) Class Weapon Pasa a IWeapon, AbstractWeapon Implements IWeapon
(B.2) Se crean las clases: Axe, Bow, Staff, Sword, Knife y todas extienden de AbstractWeapon
(B.3) Se añade el atributo magicDamage a la clase Staff

Version 1.0
-----------
- (RC.1) Implemented missing tests
- (B.5) Updated License
- (B.4) Implementation and testing of Enemy class (ensured 100% branch coverage)
- (B.3) Created .gitignore
- (B.2) Implementation of most base elements of the model
- (B.1) Created project

A note on the version naming
----------------------------
- B.n: Version ``x.y`` _beta x_, alternative to ``x.y-b.n``.
  For example: ``v1.0-b.3``.
- RC.n: Release candidate x, alternative to ``x.y-rc.n``.
  For example: ``v1.0-rc.2``.
