package patterns.chain_command;

public class OrderInvoker {
    public void executeCommand(Command c) { c.execute(); }
}