package com.vn.appweb.test;

import com.vn.appweb.modelo.ConsultaSQL;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class TestConsultaDatosPersona {

    public TestConsultaDatosPersona() {
    }

    @Test
    public void testSelectSQL() {
        ConsultaSQL conSQL = new ConsultaSQL();
        assertEquals(1, conSQL.leerTabla("Nombre de Prueba").size());
        assertEquals("Nombre de prueba", conSQL.leerTabla("Nombre de prueba").get(0).getNombre());
        assertEquals("Nombre de prueba", conSQL.leerTabla("bre").get(0).getNombre());
    }
}
