import javax.persistence.*;
import java.util.List;

@Entity
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "association")
    private List<Chapter> chapters;
}

@Entity
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String district;

    @OneToOne
    private Member president;

    @OneToMany(mappedBy = "chapter")
    private List<Member> members;

    @ManyToOne
    private Association association;
}

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String status;
    private Date renewalDate;

    @ManyToOne
    private Chapter chapter;

}
