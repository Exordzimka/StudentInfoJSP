package Models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "groups")
@Data
public class Groups implements Serializable
{

    private static final long serialVersionUID = 1L;

    public Groups(){}

    public Groups(String title, String curatorFamily, String titleDirection)
    {
        setTitle(title);
        setCuratorFamily(curatorFamily);
        setTitleDirection(titleDirection);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "curator_family", nullable = false)
    private String curatorFamily;

    @Column(name = "title_direction", nullable = false)
    private String titleDirection;

    @OneToMany (mappedBy = "groups", fetch = FetchType.EAGER)
    private Collection<Students> students;

    public Long getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getCuratorFamily()
    {
        return curatorFamily;
    }

    public void setCuratorFamily(String curatorFamily)
    {
        this.curatorFamily = curatorFamily;
    }

    public String getTitleDirection()
    {
        return titleDirection;
    }

    public void setTitleDirection(String titleDirection)
    {
        this.titleDirection = titleDirection;
    }
}
