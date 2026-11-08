import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class NewsAgency {

    private final List<NewsObserver> subscribers = new CopyOnWriteArrayList<>();

    public void subscribe(NewsObserver subscriber) {

        if(subscriber != null && !subscribers.contains(subscriber)) {

            subscribers.add(subscriber);
            System.out.println("Subscriber added.");
        }
    }
    public void unsubscribe(NewsObserver subscriber) {

        if(subscribers.remove(subscriber)) System.out.println("Subscriber removed.");

    }
    public void publishNews(News news) {

        if(news == null) throw new IllegalArgumentException("News cannot be null.");

        System.out.println("\nNEWS AGENCY PUBLISHED: " + news.getTitle());

        for(NewsObserver subscriber : subscribers) {
            subscriber.update(news);
        }
    }
    public int getSubscriberCount() { return subscribers.size(); }
}
