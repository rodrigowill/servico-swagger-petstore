package br.com.rodrigo.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.rodrigo.cadastro.ConsultaUsuarioTest;
import br.com.rodrigo.cadastro.IncluiUsuarioTest;

@RunWith(Suite.class)
@SuiteClasses({
	IncluiUsuarioTest.class,
	ConsultaUsuarioTest.class,
})
public class SuiteTeste {
	

}
