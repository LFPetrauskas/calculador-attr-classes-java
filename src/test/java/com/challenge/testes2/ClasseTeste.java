package com.challenge.testes2;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

public class ClasseTeste {
    @Somar
    public int valorA;

    @Somar
    public int valorB;

    @Somar
    public int valorC;

    @Subtrair
    public int valorD;

    @Subtrair
    public int valorE;

    @Subtrair
    public int valorF;

    public ClasseTeste(int valorA, int valorB, int valorC, int valorD, int valorE, int valorF) {
        this.valorA = valorA;
        this.valorB = valorB;
        this.valorC = valorC;
        this.valorD = valorD;
        this.valorE = valorE;
        this.valorF = valorF;
    }
}