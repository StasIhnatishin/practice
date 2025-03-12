public class StatisticsCommand implements Command {
    @Override
    public void execute() {
        Calc.getInstance().computeStatistics();
    }
}