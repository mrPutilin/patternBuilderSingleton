package singleton;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        for (Integer integer : source) {
            if (integer < treshold) {
                logger.log("Элемент " + integer + " не проходит");
            } else {
                result.add(integer);
                logger.log("Элемент " + integer + " проходит");
            }
        }
        logger.log("Выводим результат на экран");

        return result;
    }

}
