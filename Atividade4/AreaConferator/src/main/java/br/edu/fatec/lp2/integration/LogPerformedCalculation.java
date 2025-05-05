package br.edu.fatec.lp2.integration;

import br.edu.fatec.lp2.figuras.Calculable;

public interface LogPerformedCalculation {
    boolean logResultValue(Calculable calculable) throws ErrorPerformCalcException; 
}