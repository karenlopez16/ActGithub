# Programa ContraseñaValida en Java

## Descripció
Aquest programa en Java verifica la validesa d'una contrasenya introduïda per l'usuari. Verifica diversos requisits com la longitud, l'ús de majúscules, minúscules, dígits, i caràcters especials.

## Ús
L'usuari ha de proporcionar una contrasenya i el programa mostrarà els errors si no compleix els requisits especificats. Es continua demanant una nova contrasenya fins que s'introdueix una vàlida.

## Requisits de la contrasenya
- La contrasenya ha de tenir almenys 8 caràcters.
- Ha de contenir com a mínim 2 lletres majúscules.
- Ha de contenir com a mínim 3 lletres minúscules.
- Ha de contenir almenys 1 dígit.
- Ha de contenir almenys 1 caràcter especial de la llista: !\"$%&/()
- No pot contenir el caràcter @.

## Exemple de codi
```java

package RandomStringDate;

import java.util.Scanner;

public class ContraseñaValida {

	public static void main(String[] args) {

		
		        Scanner sc = new Scanner(System.in);

		        boolean contrasenaValida = false;

		        while (!contrasenaValida) {
		            System.out.print("Introduce una contraseña: ");
		            String contrasena = sc.nextLine();

		            // Validar la contraseña
		            int longitud = contrasena.length();
		            int mayusculas = 0;
		            int minusculas = 0;
		            int digitos = 0;
		            int caracteresEspeciales = 0;

		            // Contar letras mayúsculas, minúsculas, dígitos y caracteres especiales
		            for (char c : contrasena.toCharArray()) {
		                if (Character.isUpperCase(c)) {
		                    mayusculas++;
		                } else if (Character.isLowerCase(c)) {
		                    minusculas++;
		                } else if (Character.isDigit(c)) {
		                    digitos++;
		                } else if ("!\"$%&/()".indexOf(c) != -1) {
		                    caracteresEspeciales++;
		                }
		            }

		            // Mostrar errores si la contraseña no es válida
		            if (longitud < 8) {
		                System.out.println("- La contraseña debe tener al menos 8 caracteres.");
		            }

		            if (mayusculas < 2) {
		                System.out.println("- La contraseña debe tener al menos 2 letras mayúsculas. Actualmente tienes " + mayusculas + ".");
		            }

		            if (minusculas < 3) {
		                System.out.println("- La contraseña debe tener al menos 3 letras minúsculas. Actualmente tienes " + minusculas + ".");
		            }

		            if (digitos == 0) {
		                System.out.println("- La contraseña debe tener al menos un dígito.");
		            }

		            if (caracteresEspeciales == 0) {
		                System.out.println("- La contraseña debe tener al menos uno de estos caracteres: !\"$%&/()");
		            }

		            if (contrasena.contains("@")) {
		                System.out.println("- La contraseña no debe contener el carácter @.");
		            }

		            // Verificar si la contraseña es válida
		            if (longitud >= 8 && mayusculas >= 2 && minusculas >= 3 && digitos > 0 && caracteresEspeciales > 0 && !contrasena.contains("@")) {
		                System.out.println("¡Contraseña válida!");
		                contrasenaValida = true;
		            } else {
		                System.out.println("Contraseña no válida. Inténtalo de nuevo.");
		            }
		        }

		        sc.close();
		    }
		}
