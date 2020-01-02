# **TRICKS OR TREATS** - Game Snake com temática de HALLOWEEN
    
# JAVA
### Versão utilizada para fazer o EP2

```java
    java version "12.0.2" 2019-07-16
    Java(TM) SE Runtime Environment (build 12.0.2+10)
    Java HotSpot(TM) 64-Bit Server VM (build 12.0.2+10, mixed mode, sharing)
```   
    
### Testado também na versão

```java
    java version "13.0.1" 2019-10-15
    Java(TM) SE Runtime Environment (build 13.0.1+9)
    Java HotSpot(TM) 64-Bit Server VM (build 13.0.1+9, mixed mode, sharing)
```   
    
### IDE utilizada

```java   
    IntelliJ IDEA 2019.2
```   

### Bibliotecas utilizadas

```java   
    import javax.swing.JFrame;
    import javax.swing.ImageIcon;
    import javax.swing.JPanel;
    import javax.swing.Timer;
    import java.awt.*;
    import java.util.ArrayList;
    import java.awt.image.BufferedImage;
    import java.awt.event.*;
    import java.awt.image.*;
    import javax.imageio.ImageIO;
    import java.awt.event.KeyEvent;
    import java.awt.Color;
    import java.awt.Graphics;
    import java.awt.Font;
    import java.awt.event.ActionListener;
    import java.awt.event.ActionEvent;
    import java.awt.event.KeyListener;
    import java.util.Random;
 ```     
   
# Como executar o código

### Na IDE IntelliJ IDEA 2019.2
```
    Dar open project não na pasta ep2, mas sim na pasta SnakeGame.
    Dar o run no arquivo src/Main/Game.java
```  
### Executável - dentro da pasta SnakeGame/ dar o comando:
```java
    java -jar SnakeGame.jar
    
```
    
# Menu do jogo

```   
    O menu possui quatro opções e elas devem ser controladas através das "setinhas" do teclado, e escolhidas 
    através da tecla "Enter".
```   
    
### Opções do menu 
```java
    Comum Pumpkin
    Kitty Ghost
    Star Dracula
    Quit 
```   

# Modos de jogo
### Comum Pumpkin:

```   
    Snake classica, sem habilidades especiais. 
    Está snake não pode atravessar as bordas do jogo, o obstáculo da tela e nem a si mesma
```   
    
### Kitty Ghost:

```   
    Está snake pode atravessar o obstáculo da tela, mas não pode atravessar as bordas do jogo e nem a si mesma.
```   
    
### Star Dracula:

```   
    Recebe o dobro de pontos ao comer as frutas.
    Está snake pode atravessar as bordas do jogo, mas não pode atravessar o obstáculo da tela e nem a si mesma.
```   
* ***Todas as snakes são controladas usando as "setinhas" do teclado***
    
# Tipos de frutas

```Simple Candy```
![](SnakeGame/Resources/Fruits/simpleCandy.png)  **Doce comum, dá um ponto e aumenta o tamanho da Snake.**


```Big Pumpkin```
![](SnakeGame/Resources/Fruits/bigPumpkin.png)  **Dá o dobro de pontos da Simple Candy e aumenta o tamanho da Snake da mesma forma que a Simple Candy.**


```Decrease Saw```
![](SnakeGame/Resources/Fruits/decreaseSaw.png) **Diminui o tamanho da Snake para o tamanho inicial, sem fornecer nem retirar pontos.**


```Bomb Poison```
![](SnakeGame/Resources/Fruits/bombPoison.png)  **Veneno que causa a morte da Snake.**


* As frutas aparecem em locais aleatórios do mapa. 
* Elas ficam na tela por volta de 8 a 9 segundos, quando este tempo acaba, a fruta desaparece e surgi outra. 
* Existe uma probalidade de cada fruta surgir:

```java
Simple Candy: 40%

Big Pumpkin: 20%

Decrease Saw: 13.3%

Bomb Poison: 26.6%
```

# Obstáculo
### *Castle*
![](SnakeGame/Resources/Fruits/obstacleCastle.png)   **Obtáculo na tela, que causa a morte da Snake (com exeção da Kitty Ghost).**

# Diagrama de Classes
![](DiagramaDeClasses.png)
