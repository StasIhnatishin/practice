public class UndoCommand implements Command {
    @Override
    public void execute() {
        Calc.getInstance().undo();
    }
}
