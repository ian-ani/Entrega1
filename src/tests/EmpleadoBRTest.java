package tests;

/* LIBRERIAS */

import es.iesmz.EmpleadoBR;
import es.iesmz.TipoEmpleado;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoBRTest {
    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        // TODO
    }

    @BeforeEach
    public void setUp() throws Exception {
        // TODO
    }

    @Test
    @DisplayName("Calcula el salario bruto dependiendo del empleado.")
    public void testCalcularSalarioBruto() {
        List<TipoEmpleado> tipoEmpleado = List.of(TipoEmpleado.vendedor, TipoEmpleado.vendedor, TipoEmpleado.vendedor,
                TipoEmpleado.encargado, TipoEmpleado.encargado, TipoEmpleado.encargado, TipoEmpleado.encargado,
                TipoEmpleado.encargado, TipoEmpleado.vendedor, TipoEmpleado.vendedor, null);

        List<Float> ventasMes = List.of(2000f, 1500f, 1499.99f, 1250f, 1000f, 999.99f, 500f, 0f, -1f, 1500f, 1500f);
        List<Float> ventasExtra = List.of();


        float resultadoReal = EmpleadoBR.calculaSalarioBruto(TipoEmpleado.vendedor, 2000, 8);
        float resultadoEsperado = 1360.0f;

        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }

    @Test
    @DisplayName("Calcula el salario neto de un empleado.")
    public void testCalcularSalarioNeto() {

    }

    @AfterEach
    public void tearDown() throws Exception {
        // TODO
    }

    @AfterAll
    public static void tearDownAfterClas() throws Exception {
        // TODO
    }
}
