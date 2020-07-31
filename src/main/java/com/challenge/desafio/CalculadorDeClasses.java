package com.challenge.desafio;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

public class CalculadorDeClasses implements Calculavel {
    private List<BigDecimal> valoresSomar;
    private List<BigDecimal> valoresSubtrair;

    public CalculadorDeClasses() {
        this.valoresSomar = new ArrayList<>();
        this.valoresSubtrair = new ArrayList<>();
    }

    @Override
    public BigDecimal somar(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(Somar.class)) {
                try {
                    this.valoresSomar.add((BigDecimal) f.get(obj));
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            f.setAccessible(false);
        }
        BigDecimal resultado = BigDecimal.ZERO;
        for (BigDecimal v : this.valoresSomar) {
            resultado = resultado.add(v);
        }
        return resultado;
    }

    @Override
    public BigDecimal subtrair(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(Subtrair.class)) {
                try {
                    this.valoresSubtrair.add((BigDecimal) f.get(obj));
                } catch (IllegalArgumentException | IllegalAccessException e1) {
                    e1.printStackTrace();
                }
            }
            f.setAccessible(false);
        }
        BigDecimal resultado = BigDecimal.ZERO;
        for (BigDecimal v : this.valoresSubtrair) {
            resultado = resultado.subtract(v);
        }
        return resultado.abs();
    }

    @Override
    public BigDecimal totalizar(Object obj) {
        BigDecimal resultadoSoma = this.somar(obj);
        BigDecimal resultadoSubtracao = this.subtrair(obj);
        return resultadoSoma.subtract(resultadoSubtracao.abs());
    }

    public String capitalizeFirstLetter(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
    }
}