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
        System.out.println("EJECUTAR PRUEBA");
    }

    @Test
    @DisplayName("Calcula el salario bruto dependiendo del empleado. Incluye solo valores válidos.")
    public void testCalcularSalarioBruto() {
        List<TipoEmpleado> tipoEmpleado = List.of(TipoEmpleado.vendedor, TipoEmpleado.vendedor,
                TipoEmpleado.vendedor, TipoEmpleado.encargado, TipoEmpleado.encargado,
                TipoEmpleado.encargado, TipoEmpleado.encargado, TipoEmpleado.encargado);

        List<Float> ventasMes = List.of(2000f, 1500f, 1499.99f, 1250f, 1000f,
                999.99f, 500f, 0f);

        List<Float> ventasExtra = List.of(8f, 3f, 0f, 8f, 0f, 3f, 0f, 8f);

        List<Float> resultados = List.of(1360f, 1260f, 1100f, 1760f, 1600f, 1560f, 1500f, 1660f);

        for (int i = 0; i < tipoEmpleado.size(); i++) {
            float resultadoReal = EmpleadoBR.calculaSalarioBruto(tipoEmpleado.get(i),
                    ventasMes.get(i), ventasExtra.get(i));
            float resultadoEsperado = resultados.get(i);

            assertEquals(resultadoEsperado, resultadoReal, 0.01);
        }
    }

    @Test
    @DisplayName("Calcula el salario bruto dependiendo del empleado, probando tipos nulos.")
    public void testCalcularSalarioBrutoTipoNulo() {
        float resultadoReal = EmpleadoBR.calculaSalarioBruto(null, 1500f,  8f);
        float resultadoEsperado = -1f;

        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }

    @Test
    @DisplayName("Calcula el salario bruto dependiendo del empleado, probando ventas por mes negativas.")
    public void testCalcularSalarioBrutoMesNegativo() {
        float resultadoReal = EmpleadoBR.calculaSalarioBruto(TipoEmpleado.vendedor, -1f, 8f);
        float resultadoEsperado = -1f;

        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }

    @Test
    @DisplayName("Calcula el salario bruto dependiendo del empleado, probando ventas extra negativas.")
    public void testCalcularSalarioBrutoExtraNegativo() {
        float resultadoReal = EmpleadoBR.calculaSalarioBruto(TipoEmpleado.vendedor, 1500f, -1f);
        float resultadoEsperado = -1f;

        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }

    @Test
    @DisplayName("Calcula el salario neto de un empleado. Incluye solo valores válidos.")
    public void testCalcularSalarioNeto() {
        List<Float> salarios = List.of(2000f, 1500f, 1499.99f, 1250f, 1000f,
                999.99f, 500f, 0f);
        List<Float> resultados = List.of(1640f, 1230f, 1259.9916f, 1050f, 840f, 999.99f, 500f, 0f);

        for (int i = 0; i < salarios.size(); i++) {
            float resultadoReal = EmpleadoBR.calculaSalarioNeto(salarios.get(i));
            float resultadoEsperado = resultados.get(i);

            assertEquals(resultadoEsperado, resultadoReal, 0.01);
        }
    }

    @Test
    @DisplayName("Calcula el salario neto de un empleado, probando entradas negativas.")
    public void testCalcularSalarioNetoNegativo() {
        float resultadoReal = EmpleadoBR.calculaSalarioNeto(-1f);
        float resultadoEsperado = -1f;

        assertEquals(resultadoEsperado, resultadoReal, 0.01);
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
