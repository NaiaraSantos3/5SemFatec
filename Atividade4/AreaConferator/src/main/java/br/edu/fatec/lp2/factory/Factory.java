package br.edu.fatec.lp2.factory;

import br.edu.fatec.lp2.integration.ErrorPerformCalcException;

public interface Factory<R, T> {
	R create(final T ft, double... params) throws ErrorPerformCalcException;
}
