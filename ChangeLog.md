ChangeLog
=========
Version 3.0 TAREA 2
-------------------
Se añade el ataque con double dispatch
Se añade el equip con double dispatch
Se corrigen errores de la tarea pasada
Se añade el controller y sus funcionalidades
Se añade el observer para poder el ganador del match
Se añade la cola de turnos en el controller



Version 2.0 TAREA 1
-------------------
Notas de la VERSION TAREA 1:
Se hicieron los siguientes cambios en el modelo:
Se crea la clase AbstractMage y IMage
Se corrigen los cambios de la Tarea 1
Se crea el ataque con double dispatch
se crea el equip con double dispatch 
Se agregan los addListener para notificar la muerte al controller

Se agrega la clase Controller:
Capacidad de crear objetos del modelo
Capacidad de "gettear" los atributos de los IChacters
Creación del inventario + manipulación de esta
Se crea el Observer para notificar la muerte de enemigos y playerChacters
Inicio de turno con BeginTurn()
Para saber el fin del turno se llama a endTurn() después de realizar un ataque
Notificación de victoria cuando se muerten todos los enemigos
Notificación de derrora cuando se muere toda la party



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
