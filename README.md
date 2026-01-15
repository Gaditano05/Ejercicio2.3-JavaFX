Este componente personalizado creado en JavaFX muestra un círculo que al pulsar el botón va cambiando de color.

El componente incluye:
- Propiedad del color.
- Evento personalizado en mi caso (ColorChangedEvent).
- Animación de transición entre colores
- Tests con JUnit 5 y TestFX


1. Funcionalidad

- El círculo comienza en color rojo

Al pulsar el botón:
- El color cambia
- Se ejecuta una animación
- Se lanza un evento personalizado

2. Uso del componente
   
   Como vemos en la imagen creamos en el HelloApplication una variable ColorCirculoControl,
   y escuchamos el evento.
<img width="842" height="230" alt="image" src="https://github.com/user-attachments/assets/c62c78ef-d938-42d0-8dee-6a0233add519" />

3. Test
   Para hacer los test, creamos en src (src/test/java/org/example/ejercicio23/control),
   y creamos dentro un fichero java en el que extiende de ApplicationTest.
   <img width="307" height="268" alt="image" src="https://github.com/user-attachments/assets/855f4f79-5792-448d-8950-291d7c591274" />

   Agregamos los test que queremos hacer, en mi caso:
     @Test
   
      void testColorInicial(){
   
          ColorCirculoControl control = new ColorCirculoControl();
   
          assertEquals(Color.RED, control.getColor(), "El color inicial es rojo");
   
      }
  
      @Test
   
      void testCambiarColor(){
   
          ColorCirculoControl control = new ColorCirculoControl();
   
          //Cambiamos el color
   
          control.setColor(Color.BLUE);
   
          assertEquals(Color.BLUE, control.getColor(), "El color cambia a azul");
   
      }
  
      @Test
   
      void testEventoColorCambiado(){
   
          ColorCirculoControl control = new ColorCirculoControl();
   
          final Color[] eventoRecibido = new Color[1];
   
          //Registramos los listener del evento
   
          control.addEventHandler(ColorChangedEvent.COLOR_CHANGED, event ->{
   
              eventoRecibido[0] = event.getNewColor();
   
          });
   
          //Cambiamos de color
   
          control.cambiarColor();
   
          assertEquals(Color.BLUE, eventoRecibido[0], "El evento notifica el nuevo color");
   
      }

   Los test incluyen:
     El componente incluye tests automáticos para:
         - Color inicial
         - Cambio de color mediante botón
         - Lanzamiento del evento ColorChangedEvent

   4. Herramientas utilizadas:
      - Java 21
      - JavaFX
      - Maven
      - JUnit 5
      - TestFX
   
