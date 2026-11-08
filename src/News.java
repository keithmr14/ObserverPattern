import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class News {

    private final String title;
    private final String content;
    private final NewsCategory category;
    private final LocalDateTime publishedAt;

    public News(String title, String content, NewsCategory category) {

        this.title = title;
        this.content = content;
        this.category = category;
        this.publishedAt = LocalDateTime.now();
    }

    public String getTitle() { return title; }
    public String getContent() { return content; }
    public NewsCategory getCategory() { return category; }
    public LocalDateTime getPublishedAt() { return publishedAt; }

    @Override
    public String toString() {

        return "[" + category + "] " + title + "\n" + content
                + "\nPublished: " + publishedAt.format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
