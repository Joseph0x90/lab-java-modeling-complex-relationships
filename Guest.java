@Entity
public class Event {
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
public class Conference extends Event {
    @OneToMany(mappedBy = "conference")
    private List<Speaker> speakers;
}

@Entity
public class Exposition extends Event {
}

@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ResponseStatus status;

    @ManyToOne
    @JoinColumn(name = "event_id")
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
    @JoinColumn(name = "conference_id")
    private Conference conference;
}

public enum ResponseStatus {
    ATTENDING,
    NOT_ATTENDING,
    NO_RESPONSE
}
