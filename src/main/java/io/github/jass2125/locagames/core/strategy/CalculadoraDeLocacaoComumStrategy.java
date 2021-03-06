/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.locagames.core.strategy;

import io.github.jass2125.locagames.core.negocio.Locacao;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author Anderson Souza
 * @since 14:56:26, 24-Feb-2016
 */
public class CalculadoraDeLocacaoComumStrategy implements CalculadoraDeLocacaoStrategy {

    private static String tipo = "COMUM";

    @Override
    public BigDecimal calcularPrecoDaLocacao(Locacao location) {
        long days = ChronoUnit.DAYS.between(location.getDataDeDevolucao(), LocalDate.now());
        if (days <= 0) {
            return new BigDecimal(3);
        }
        return new BigDecimal(3 + 1 + (days * 3));
    }

    @Override
    public String toString() {
        return this.tipo;
    }

}
