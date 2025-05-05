package br.edu.fatec.lp2.factory;

import br.edu.fatec.lp2.enums.FiguraType;
import br.edu.fatec.lp2.factory.FiguraFactory;
import br.edu.fatec.lp2.figuras.Calculable;
import br.edu.fatec.lp2.figuras.Circulo;
import br.edu.fatec.lp2.figuras.Cubo;
import br.edu.fatec.lp2.figuras.Hexagono;
import br.edu.fatec.lp2.figuras.Losango;
import br.edu.fatec.lp2.figuras.Paralelograma;
import br.edu.fatec.lp2.figuras.Quadrado;
import br.edu.fatec.lp2.figuras.Retangulo;
import br.edu.fatec.lp2.figuras.Trapezio;
import br.edu.fatec.lp2.figuras.Triangulo;
import br.edu.fatec.lp2.integration.ErrorPerformCalcException;
import br.edu.fatec.lp2.integration.LogPerformedCalculation;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FiguraFactory implements Factory<Calculable, FiguraType> {
	private LogPerformedCalculation logPerformedCalculation;

	@Override
	public Calculable create(final FiguraType ft, double... params) throws ErrorPerformCalcException {
		Calculable obj = null;
		switch(ft) {
			case QUADRADO: 
				obj =  new Quadrado(params[0]); 
				break;
			case RETANGULO: 
				obj =  new Retangulo(params[0], params[1]); 
				break;
			case CIRCULO:
				obj = new Circulo(params[0]);
				break;
			case TRIANGULO:
				obj = new Triangulo(params[0], params[1]);
				break;
			case PARALELOGRAMA:
				obj = new Paralelograma(params[0], params[1]);
				break;
			case TRAPEZIO:
				obj = new Trapezio(params[0], params[1], params[2]);
				break;
			case HEXAGONO:
				obj = new Hexagono(params[0]);
				break;
			case LOSANGO:
				obj = new Losango(params[0], params[1]);
				break;
			case CUBO:
				obj = new Cubo(params[0]);
				break;
		}
		logPerformedCalculation.logResultValue(obj);
		return obj;
	}
}
