package com.cice;

import com.cice.dtos.Cliente;
import com.cice.threads.ThreadCajera;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Ejercicio de Multitareas e hilos - JARROBA

public class Main {

    public static void main(String[] args) {

        //Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
        //Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });

        // Tiempo inicial de referencia
        //long initialTime = System.currentTimeMillis();
        //ThreadCajera cajera1 = new ThreadCajera("Cajera 1", cliente1, initialTime);
        //ThreadCajera cajera2 = new ThreadCajera("Cajera 2", cliente2, initialTime);

        //cajera1.start();
        //cajera2.start();

        List<Cliente>clientes = new ArrayList<>();
        clientes.add(new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2 })); // 12 Seg
        clientes.add(new Cliente("Cliente 2", new int[] { 1, 1, 5, 1, 1 })); //  9 Seg
        clientes.add(new Cliente("Cliente 3", new int[] { 5, 3, 1, 5, 2 })); // 16 Seg
        clientes.add(new Cliente("Cliente 4", new int[] { 2, 4, 3, 2, 5 })); // 16 Seg
        clientes.add(new Cliente("Cliente 5", new int[] { 1, 3, 2, 2, 3 })); // 11 Seg
        clientes.add(new Cliente("Cliente 6", new int[] { 4, 2, 1, 3, 1 })); // 11 Seg
        clientes.add(new Cliente("Cliente 7", new int[] { 3, 3, 2, 4, 7 })); // 19 Seg
        clientes.add(new Cliente("Cliente 8", new int[] { 6, 1, 3, 1, 3 })); // 14 Seg
        // Tiempo total en procesar todos los pedidos = 108 segundos

        long init = System.currentTimeMillis();  // Instante inicial del procesamiento

        ExecutorService executor = Executors.newFixedThreadPool(2); // 2 HILOS
        for (Cliente cliente : clientes) {  //Cada vuelta q da y coge a un cliente, genera un hilo
            executor.execute(new ThreadCajera("cajera tipo", cliente, init)); //cola de cajeras
        }

        executor.shutdown();	// Cierro el Executor
        while (!executor.isTerminated()) {
            // Espero a que terminen de ejecutarse todos los procesos
            // para pasar a las siguientes instrucciones
        }

        long fin = System.currentTimeMillis();	// Instante final del procesamiento
        System.out.println("Tiempo total de procesamiento: "+(fin-init)/1000+" Segundos");
    }
}
