import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "event_type")
public abstract class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private int duration;
    private String location;
    private String title;

    @OneToMany(mappedBy = "event")
    private List<Guest> guests;
}

@Entity
@DiscriminatorValue("Conference")
public class Conference extends Event {
    @OneToMany(mappedBy = "conference")
    private List<Speaker> speakers;
}

@Entity
@DiscriminatorValue("Exposition")
public class Exposition extends Event {
}

@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String status;

    @ManyToOne
    private Event event;
}

@Entity
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int presentationDuration;

    @ManyToOne
    private Conference conference;
}
