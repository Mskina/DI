package ventanafrase_solucion;



class Frase {
   //Atributos
   private String cadena;
   
   //Constructores
   public Frase() {}
   
   public Frase(String cadena) {
      this.cadena = cadena;
   }
   
   //Resto de m�todos
    
   public void setCadena(String cadena){
      this.cadena=cadena;
   }
   
   /**
    * Devuelve el atributo cadena
    */       
   public String obtenerFrase(){
      return cadena;
   }
   /**
    * Elimina los espacios en blanco al principio y al final de la cadena
    */       
   public void eliminarBlancos() {
      cadena = cadena.trim();
   }
   
   /**
    * Devuelve el n�mero de letras que hay en la cadena
    */
   public int contarLetras() {
      int num = 0;
      char car;
      
      for (int i = 0; i < cadena.length(); i++) {
         car = cadena.charAt(i);
         if ( (car != ' ') & (car != ',') & (car != '.') & (car != ';') & (car != ':') )
            num++;
      }
      
      return num;   
   }
   
   /**
    * Devuelve un StringBuffer con la cadena invertida.
    */       
   public StringBuffer invertirFrase() {
      return new StringBuffer(cadena).reverse();
      
      //Otra forma: usando el m�todo append de StringBuffer
/*    StringBuffer strb = new StringBuffer("");
      for ( int i = cadena.length() - 1; i >= 0 ;i-- )
         strb.append(cadena.charAt(i));
      
      return strb;
*/
   }
   
   /**
    * Devuelve el numero de palabras que hay en la cadena
    */       
   public int contarPalabras() {
      int num = 0;
      String temp = cadena;
      
      while ( temp.indexOf(' ') != -1 ) {
         temp = temp.substring(temp.indexOf(' ')).trim();
         num++;
      }
      
      //Si temp sigue teniendo algo al salir del bucle, entonces
      //falta sumar la ultima palabra puesto que no hay espacios
      //al final.
      if (temp.length() > 0)
         num++;
         
      return num;
   }       
   
   /**
    * Devuelve un array de Strings. Cada celda del array
    * contendra una palabra de la cadena    
    */       
   public String[] separarPalabras() {
      String[] palabras = new String[contarPalabras()];
      String temp = cadena;
      int espacio;
      
      for (int i = 0; i < palabras.length; i++) {
         if (i == palabras.length - 1) {
            palabras[i] = temp;
         }
         else{
            espacio = temp.indexOf(' ');          //posici�n del espacio
            palabras[i] = temp.substring(0,espacio);
            temp = temp.substring(espacio).trim();
         }
      }
      
      return palabras;
   }
   
   /**
    * Devuelve la primera posici�n de una vocal en la cadena
    * En caso de que no tenga vocales, devuelve -1    
    */       
   public int primeraVocal() {
      int pos = -1;
      
      for (int i = 0; i < cadena.length(); i++) {
         if ( cadena.charAt(i) == 'a' || cadena.charAt(i) == 'A'
           || cadena.charAt(i) == 'e' || cadena.charAt(i) == 'E' 
           || cadena.charAt(i) == 'i' || cadena.charAt(i) == 'I'
           || cadena.charAt(i) == 'o' || cadena.charAt(i) == 'O'
           || cadena.charAt(i) == 'u' || cadena.charAt(i) == 'U')
           
               return i;
      }
      
      return pos;
   }
   
   /**
    * Devuelve la �ltima posici�n de una vocal en la cadena
    * En caso de que no tenga vocales, devuelve -1    
    */
   public int ultimaVocal() {
      int pos = -1;
      
      for (int i = cadena.length() - 1; i >= 0; i--) {
         if ( cadena.charAt(i) == 'a' || cadena.charAt(i) == 'A'
           || cadena.charAt(i) == 'e' || cadena.charAt(i) == 'E' 
           || cadena.charAt(i) == 'i' || cadena.charAt(i) == 'I'
           || cadena.charAt(i) == 'o' || cadena.charAt(i) == 'O'
           || cadena.charAt(i) == 'u' || cadena.charAt(i) == 'U')
           
               return i;
      }
      
      return pos;
   }
   
   /**
    * Devuelve true si la primera letra es may�scula y false si no lo es
    */       
   public boolean comprobarMayuscula() {
      return ( cadena.substring(0,1).equals(cadena.substring(0,1).toUpperCase()) );
      
      //Otras formas
      //return (Character.isUpperCase(cadena.charAt(0))); 
      //return ( cadena.substring(0,1).compareTo( cadena.substring(0,1).toUpperCase() ) == 0 );
   }
   
   /**
    * Devuelve un StringBuffer con la cadena convertida a may�sculas
    */       
   public StringBuffer convertirMayuscula() {
      return new StringBuffer(cadena.toUpperCase());
   }
   
   /**
    * Devuelve un StringBuffer con la cadena convertida a may�sculas
    */
   public StringBuffer convertirMinuscula() {
      return new StringBuffer(cadena.toLowerCase());
   }
   
   /**
    * Devuelve un array de caracteres con el contenido de cadena
    */       
   public char[] vectorizar() {
      return cadena.toCharArray();
   }
}
