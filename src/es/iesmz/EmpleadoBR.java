package es.iesmz;

public class EmpleadoBR {
    /* OTROS METODOS */

    public static float calculaSalarioBruto(TipoEmpleado tipo, float ventasMes, float horasExtra) {
        // Declarar variables de salario
        float salarioBase;
        float salario;

        // Si TipoEmpleado es nulo, ventasMes u horasExtra son valores negativos
        // devuelve -1
        if (ventasMes < 0 || horasExtra < 0) {
            return -1;
        }

        // Salario base de TipoEmpleado.vendedor := 1000€
        // Salario base de TipoEmpleado.encargado := 1500€
        if (tipo == TipoEmpleado.vendedor) {
            salarioBase = 1000;
        } else if (tipo == TipoEmpleado.encargado) {
            salarioBase = 1500;
        } else {
            return -1;
        }

        // A salario base se le suma una prima de 100€ si ventaMes es mayor o igual a 1000€
        // Pero de 200€ si es de al menos 1500€
        if (ventasMes >= 1000 && ventasMes < 1500) {
            salario = salarioBase + 100;
        } else if (ventasMes >= 1500) {
            salario = salarioBase + 200;
        }

        // Las horas extra se pagan a 20€
        salario = horasExtra * 20;

        return salario;
    }

    public static float calculaSalarioNeto(float salarioBruto) {
        // Declarar variables de retencion
        float retencion = 0;

        // Si salarioBruto es menor a 0 entonces devuelve -1
        if (salarioBruto < 0) {
            return -1;
        }

        // Si salarioBruto es menor de 1000€ no se aplica retencion
        // Para rango de salarios de entre 1000 y 1500€ se aplica un 16%
        // Para salarios mayores de 1500€ se aplica un 18%
        if (salarioBruto >= 1000 && salarioBruto <= 1500) {
            retencion = (float) (salarioBruto * 1.16);
            // retencion del 16%
        } else if (salarioBruto > 1500) {
            // retencion del 18%
            retencion = (float) (salarioBruto * 1.18);;
        }

        return salarioBruto * (1 - (retencion / 100));
    }
}
