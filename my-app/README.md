*Copyright 2021 Javier Martínez Cristóbal
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*



# JUEGO DE LA VIDA
# README #

El “Juego de la vida” es un autómata celular, es decir, un modelo matemático para un sistema dinámico que evoluciona en pasos discretos, que se compone de una “rejilla” o “tablero” extendida hasta el infinito (teóricamente) en sus dos dimensiones que delimita unas celdas sobre las cual se van a producir las interacciones. Este juego puede ser encuadrado en la categoría de los llamados "juegos de simulación", denominación que reciben por imitar procesos de la vida real. 

### REGLAS ###

Si una célula está viva y dos o tres de sus vecinas también lo están, entonces continúa viva en el estado siguiente.
Si una célula está muerta y tres de sus vecinas están vivas, entonces pasa a estar viva en el estado siguiente.
El resto de células pasan a estar muertas en el estado siguiente.

### ¿Para qué es este repositorio? ###

* Este repositorio contiene todo lo necesario para realizar la simulación del juego de la vida de John Horton Conway
* Version final

### Realizado por ###
Javier Martinez Cristobal

### ¿Cómo funciona? ###

Para que el programa se ejecute necesita seguir las siguientes instrucciones:
* 1-Comando mvn clean compile assembly:single
* 2-Comando java -jar target/my-app-1.0-SNAPSHOT-jar-with-dependencies.jar (donde se encuentra nuestro archivo con extension .jar)
En caso de que no funcione a través de Maven se deberá ejecutar:
* 1- make ejecutar
* 2- make jar

### Visualmente ###

![Alt text](http://www.lcc.uma.es/~fjv/UMA/LCC/web/Teaching/trabajos_00_01/introduccionAC/gunfast.gif)

### Diagrama ###
![Alt text](file:///C:/Users/javim/IdeaProjects/gameOfLifemvn/class%20diagram.jpeg)