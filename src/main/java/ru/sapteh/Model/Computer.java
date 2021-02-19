package ru.sapteh.Model;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@Table(name = "ConfigPC")
@Entity
public class Computer {
    public Computer(int ram, int hdd, int powerSupple, String videoCard) {
        this.ram = ram;
        this.hdd = hdd;
        this.powerSupple = powerSupple;
        this.videoCard = videoCard;
    }

    public Computer(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "RAM")
    private int ram;

    @Column(name = "HDD")
    private int hdd;

    @Column(name = "Power_supply")
    private int powerSupple;

    @Column(name = "Video_card")
    private String videoCard;

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", ram='" + ram + '\'' +
                ", hdd='" + hdd + '\'' +
                ", powerSupple=" + powerSupple +
                ", videoCard='" + videoCard + '\'' +
                '}';
    }
}
