package com.cice.runnables;

import com.cice.dtos.Cliente;

public class CajeraRunnable implements Runnable {

    private String nombre;

    private Cliente cliente;

    private long initialTime;

    @Override
    public void run() {

        System.out.println("La cajera " + Thread.currentThread().getName()
                + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + this.cliente.getNombre()
                + " EN EL TIEMPO: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");

        for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
            // Se procesa el pedido en X segundos
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) + " del " + this.cliente.getNombre()+
                    "->Tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        }

        System.out.println("La cajera " + Thread.currentThread().getName() + " HA TERMINADO DE PROCESAR "
                + this.cliente.getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");

    }
    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
