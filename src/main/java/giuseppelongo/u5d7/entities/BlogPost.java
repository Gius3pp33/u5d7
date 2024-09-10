package giuseppelongo.u5d7.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogPost {
    private int id;

    private String category;

    private String title;

    private String cover;

    private String content;

    private int timeToRead;

}
