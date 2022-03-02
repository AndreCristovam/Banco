package interfaces;

import models.Conta;

public interface IConta {

	void sacar(Double valor);

	void tranferir(Conta destino, Double valor);

	void depositar(Double valor);

}
