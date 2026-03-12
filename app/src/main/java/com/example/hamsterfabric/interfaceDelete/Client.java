package com.example.hamsterfabric.interfaceDelete;

public class Client {
    public  Interface inter;

    // Сеттер, чтобы можно было установить клиенту мессенджер
    public void set (Interface inter) {
        this.inter = inter;
    }

    // Метод для отправки сообщения от имени клиента через выбранный мессенджер
    public void send() {
        if (inter != null) {
            inter.execute();
        } else {
            System.out.println("Мессенджер не установлен!");
        }
    }
}
