package com.mycompany.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.callcenter.Call;
import com.mycompany.callcenter.CallCenterJob;
import com.mycompany.callcenter.Dispatcher;
import org.junit.Test;

/**
 *
 * @author eviloria
 */
public class CallCentertTest {

    public CallCentertTest() {
    }

    
    @Test
    public void hello() {
        /**
         * Numero de empleados tipo operadores
         */
        int operatorNum = 7;
        /**
         * Numero de empleados tipo supervisores
         */
        int supervisorNum = 2;
        
          /**
         * Numero de empleados tipo directores
         */
        int directorNum = 1;
         /**
         * Numero de Llamadas entrantes
         */
        int callNum = 11;
         /**
          * Numero de Llamadas Concurentes
         */
         int concurentCall = 10;

        /**
         * Instancaimos la clase Dispatcher para configurar los parametro de entrada de la operacion
         */ 
        Dispatcher dispatcher = new Dispatcher(concurentCall, operatorNum, supervisorNum, directorNum);
        
        /**
         * Creamos una coleccion de hilos por el numero de llamadas a gestionar en el proceso
         */
        Thread calls[] = new Thread[callNum];
        for (int i = 0; i < callNum; i++) {
            calls[i] = new Thread(new CallCenterJob(dispatcher), new Call(i).toString());
        }
        for (int i = 0; i < callNum; i++) {
            calls[i].start();
        }
    }
}
