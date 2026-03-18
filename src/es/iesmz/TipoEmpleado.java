package es.iesmz;

import java.util.List;

public enum TipoEmpleado {
    vendedor, encargado;

    static boolean isMember(String valor) {
        List<TipoEmpleado> tipos = List.of(TipoEmpleado.values());

        for (TipoEmpleado tipo: tipos) {
            if (tipo.name().equalsIgnoreCase(valor)) return true;
        }

        return false;
    }
}
