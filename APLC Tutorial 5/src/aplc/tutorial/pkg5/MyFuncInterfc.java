package aplc.tutorial.pkg5;

//Assuming that you're to create/define your own FUNCTIONAL INTERFACE
//Being a functional interface, it can only include one abstract method
//IT is recommended to be annotated
@FunctionalInterface
public interface MyFuncInterfc {
    int apply(int a);
}
