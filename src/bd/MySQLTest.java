package bd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import veiculo.model.Veiculo;

class MySQLTest {

	/**
	 * Testa a inserção e deleção de um veículo na base de dados.
	 */
	@Test
	void test() {
		Veiculo v = new Veiculo("Prius", "LoL1337", "Filial A", "B");
		new MySQL().insert(v);
		new MySQL().delete(v);
	}

}
