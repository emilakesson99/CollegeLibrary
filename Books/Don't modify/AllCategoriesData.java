import java.util.ArrayList;
import java.util.List;

public class AllCategoriesData {

    private static final List<String> categories = new ArrayList<>();

    /**
     * Add a new category if it doesn't already exist
     *
     * @param category
     */
    public static void addCategory(String category) {
        if (!checkCategory(category)) {
            categories.add(category);
        }
    }

    public static List<String> getCategories() {
        return new ArrayList<>(categories);
    }

    public static boolean checkCategory(String checkC) {
        return categories.contains(checkC);
    }

}
