package designpattern;

public class Main {

	public static void main(String[] args) throws Exception {
		iterator.Test test = new iterator.Test();
		test.Run();
		
		adapter.Test testAdapter = new adapter.Test();
		testAdapter.Run();
		
		templatemethod.Test testTemplateMethod = new templatemethod.Test();
		testTemplateMethod.Run();
		
		factorymethod.Test testfactorymethod = new factorymethod.Test();
		testfactorymethod.Run();
		
		prototype.Test testprototype = new prototype.Test();
		testprototype.Run();
		
		builder.Test testbuilder = new builder.Test();
		testbuilder.Run();
		
		bridge.Test testbridge = new bridge.Test();
		testbridge.Run();
		
		strategy.Test teststrategy = new strategy.Test();
		teststrategy.Run();
		
		composite.Test testcomposite = new composite.Test();
		testcomposite.Run();
		
		decorator.Test testdecorator = new decorator.Test();
		testdecorator.Run();
		
		chainresponsibility.Test testchain = new chainresponsibility.Test();
		testchain.Run();
		
		memento.Test testmemento = new memento.Test();
		testmemento.Run();
		
		state.Test teststate = new state.Test();
		teststate.Run();
		
		interpreter.Test testinterpreter = new interpreter.Test();
		testinterpreter.Run();
	}
}
