/**
 * Клас, що створює конкретні об'єкти View для відображення результатів обчислень.
 */
public class ViewableResult implements Viewable {

    @Override
    public View createView() {
        return new ViewResult();
    }
}
