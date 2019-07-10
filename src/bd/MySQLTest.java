package bd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import veiculo.model.Veiculo;

class MySQLTest {

	/**
	 * Testa a inser��o e dele��o de um ve�culo na base de dados.
	 */
	@Test
	void test() {
		Veiculo v = new Veiculo("Prius", "LoL1337", "Filial A", "B");
		new MySQL().insert(v);
		new MySQL().delete(v);
	}

}
