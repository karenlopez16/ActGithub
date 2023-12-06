package RandomStringDate;

import java.util.Scanner;


public class ContraseñaValida {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean contrasenaValida = false;

        while (!contrasenaValida) {
            System.out.print("Introduce una contraseña: ");
            String contrasena = sc.nextLine();

            // Validar la contrasenya utilitzant la nova funció
            contrasenaValida = validarContrasena(contrasena);

            if (!contrasenaValida) {
                System.out.println("Contraseña no válida. Inténtalo de nuevo.");
            }
        }

        System.out.println("¡Contraseña válida!");

        sc.close();
    }

    // Nova funció per validar la contrasenya
    private static boolean validarContrasena(String contrasena) {
        int longitud = contrasena.length();
        int mayusculas = 0;
        int minusculas = 0;
        int digitos = 0;
        int caracteresEspeciales = 0;

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

        return (longitud >= 8 && mayusculas >= 2 && minusculas >= 3 && digitos > 0 &&
                caracteresEspeciales > 0 && !contrasena.contains("@"));
    }
}
