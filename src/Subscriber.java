import java.util.EnumSet;
import java.util.Set;

public class Subscriber implements NewsObserver {

    private final String name;
    private Set<NewsCategory> preferences;

    public Subscriber(String name, Set<NewsCategory> preferences) {

        this.name = name;
        setPreferences(preferences);
    }

    public String getName() { return name; }

    public synchronized void setPreferences(Set<NewsCategory> preferences) {

        this.preferences = (preferences == null || preferences.isEmpty())
                ? EnumSet.noneOf(NewsCategory.class)
                : EnumSet.copyOf(preferences);
    }

    public synchronized Set<NewsCategory> getPreferences() {

        return Set.copyOf(preferences);
    }

    @Override
    public void update(News news) {

        Set<NewsCategory> current = getPreferences();

        if(current.isEmpty() || current.contains(news.getCategory())) {

            System.out.println("\nNotification for " + name + ":");
            System.out.println(news);
        }
    }
}
