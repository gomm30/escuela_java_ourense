package com.vn.liboperaarrays;

/**
 *
 * @author pc
 */
public class OperarArrays {
    
    
    // Equivalente a decir qué estructura tendrán las funciones callback
    @FunctionalInterface
    public interface FunCallbackOperarArrays {
        // Sólo podemos declarar (que luego implementar) un método
        //double operar(double x, double y);
        Object operar(Object x, Object y);
    }

//    public static double[] operarArrays(
//            double[] arrX,
//            double[] arrY,
//            FunCallbackOperarArrays operaCllbk) {
//        double[] arrayResult = null;
//        if (arrX.length == arrY.length) {
//            arrayResult = new double[arrX.length];
//            for (int i = 0; i < arrX.length; i++) {
//                arrayResult[i] = operaCllbk.operar(arrX[i], arrY[i]);
//            }
//        }
//        return arrayResult;
//    }
    
    public static Object[] operarArrays(
            Object[] arrX,
            Object[] arrY,
            FunCallbackOperarArrays operaCllbk) {
        Object[] arrayResult = null;
        if (arrX.length == arrY.length) {
            arrayResult = new Object[arrX.length];
            for (int i = 0; i < arrX.length; i++) {
                arrayResult[i] = operaCllbk.operar(arrX[i], arrY[i]);
            }
        }
        return arrayResult;
    }
}
