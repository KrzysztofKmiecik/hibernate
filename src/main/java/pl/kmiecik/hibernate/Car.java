package pl.kmiecik.hibernate;


import javax.persistence.*;
import java.util.StringJoiner;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "car_mark")
    private String mark;
    private String model;
    @Enumerated(EnumType.STRING)
    private Color color;

    public Car( String mark, String model, Color color) {
        this.mark = mark;
        this.model = model;
        this.color = color;
    }

    public Car() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Car.class.getSimpleName() + "[", "]")
                .add("Id=" + Id)
                .add("mark='" + mark + "'")
                .add("model='" + model + "'")
                .add("color=" + color)
                .toString();
    }
}
