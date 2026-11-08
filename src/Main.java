import java.util.EnumSet;

public class Main {

    public static void main(String[] args) {

        NewsAgency agency = new NewsAgency();

        Subscriber alex = new Subscriber("Alex",
                EnumSet.of(NewsCategory.TECHNOLOGY, NewsCategory.BUSINESS));
        Subscriber sam = new Subscriber("Sam",
                EnumSet.of(NewsCategory.SPORTS));
        Subscriber jordan = new Subscriber("Jordan",
                EnumSet.noneOf(NewsCategory.class));

        agency.subscribe(alex);
        agency.subscribe(sam);
        agency.subscribe(jordan);

        agency.publishNews(new News("New AI Innovation Announced",
                "A new artificial intelligence development was announced today.",
                NewsCategory.TECHNOLOGY));

        sam.setPreferences(EnumSet.of(NewsCategory.SPORTS, NewsCategory.GENERAL));

        agency.unsubscribe(jordan);

        agency.publishNews(new News("National Team Wins Championship",
                "The national team secured the championship title.",
                NewsCategory.SPORTS));

        System.out.println("\nCurrent subscribers: " + agency.getSubscriberCount());
    }
}
