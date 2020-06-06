package br.com.rodrigo.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.rodrigo.cadastro.AlterarStatusOrderTest;
import br.com.rodrigo.cadastro.DeletarOrderTest;
import br.com.rodrigo.cadastro.IncluiOrderTest;
import br.com.rodrigo.cadastro.IncluiPetTest;
import br.com.rodrigo.cadastro.IncluiUsuarioTest;

@RunWith(Suite.class)
@SuiteClasses({
	IncluiUsuarioTest.class,
	IncluiPetTest.class,
	IncluiOrderTest.class,
	DeletarOrderTest.class,
	AlterarStatusOrderTest.class
})
public class SuiteTeste {
	

}
