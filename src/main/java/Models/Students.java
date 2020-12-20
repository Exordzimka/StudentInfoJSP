package Models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "students")
@Data
public class Students implements Serializable
{
    private static final long serialVersionUID = 1L;

    public Students(){}

    public Students(String name, String secondName, String lastName, Groups group)
    {
        setName(name);
        setSecondName(secondName);
        setLastName(lastName);
        setGroup(group);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "second_name", nullable = false)
    private String secondName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @ManyToOne (optional = false, cascade = CascadeType.ALL)
    @JoinColumn (name = "group_id", nullable = false)
    private Groups groups;

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSecondName()
    {
        return secondName;
    }

    public void setSecondName(String secondName)
    {
        this.secondName = secondName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Groups getGroup()
    {
        return groups;
    }

    public void setGroup(Groups group)
    {
        this.groups = group;
    }
}
