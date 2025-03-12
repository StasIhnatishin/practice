
/**
 * Команда для скасування останньої операції.
 */
public class UndoCommand implements Command {
    @Override
    public void execute() {
        Calc.getInstance().undo();
    }
}
