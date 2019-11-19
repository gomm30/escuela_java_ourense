package com.vn;

import com.vn.liboperaarrays.OperarArrays;
import com.vn.liboperaarrays.OperarArrays.FunCallbackOperarArrays;

/**
 *
 * @author pc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Double[] array_A = {1.0,2.0,3.0,4.0,5.0};
        Double[] array_B = {2.0,3.0,4.0,5.0,6.0};
        
        Object[] arraySumaAB = OperarArrays.operarArrays(array_A, array_B, Main::suma);
        arrayEnTabla(arraySumaAB);

        // Manera más típica de crear funciones lambda.
        Object[] arrayRestaAB = OperarArrays.operarArrays(array_A, array_B, (Object x, Object y) -> {
            return (Double)x - (Double)y;
        });
        arrayEnTabla(arrayRestaAB);

        Object[] arrayMultiplicaAB = OperarArrays.operarArrays(array_A, array_B, Main::multiplica);
        arrayEnTabla(arrayMultiplicaAB);

        FunCallbackOperarArrays divide = (Object x, Object y) -> {
            return (Double)x / (Double)y;
        };
        Object[] arrayDivideAB = OperarArrays.operarArrays(array_A, array_B, divide);
        arrayEnTabla(arrayDivideAB);

        // Manera más típica de crear funciones lambda.
        Object[] arrayConcateaAB = OperarArrays.operarArrays(array_A, array_B, (Object x, Object y) -> {
            return "( " + x + " , " + y + " )";
        });
        arrayEnTabla(arrayConcateaAB);
    }

    public static void arrayEnTabla(Object[] array) {
        String tabla = "\n<table border = 2>\n  <tr>\n";
        for (int index = 0; index < array.length; index++) {
            final Object element = array[index];
            tabla += "    <td>" + element + "</td>\n";
        }
        System.out.println(tabla + "  </tr>\n</table>\n");
    }

//    public static void arrayEnTabla(double[] array) {
//        String tabla = "\n<table border = 2>\n  <tr>\n";
//        for (int index = 0; index < array.length; index++) {
//            final double element = array[index];
//            tabla += "    <td>" + element + "</td>\n";
//        }
//        System.out.println(tabla + "  </tr>\n</table>\n");
//    }
    public static Object suma(Object x, Object y) {
        return (Double)x + (Double)y;
    }

    public static Object multiplica(Object x, Object y) {
        return (Double)x * (Double)y;
    }

}
