package com.challenge.testes;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import com.challenge.desafio.CalculadorDeClasses;

import org.junit.Test;

public class CalcTest {

    @Test
    public void calculaSoma() {
        ClasseTeste teste = new ClasseTeste(15, 25, 0, 1, 1, 1);
        CalculadorDeClasses calculadora = new CalculadorDeClasses();
        assertEquals(new BigDecimal(30), calculadora.somar(teste));
    }
    
    @Test
    public void calculaSubtracao() {
        ClasseTeste teste = new ClasseTeste(2, 2, 2, 1, 1, 1);
        CalculadorDeClasses calculadora = new CalculadorDeClasses();
        assertEquals(new BigDecimal(-3), calculadora.subtrair(teste));

    }
    @Test
    public void calculaTotalizacao() {
        ClasseTeste teste = new ClasseTeste(2, 2, 2, 1, 1, 1);
        CalculadorDeClasses calculadora = new CalculadorDeClasses();
        assertEquals(new BigDecimal(3), calculadora.totalizar(teste));
    }

}