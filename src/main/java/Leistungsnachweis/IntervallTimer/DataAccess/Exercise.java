package Leistungsnachweis.IntervallTimer.DataAccess;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name = "tbl_exercise")
public class Exercise {
    @Id
    @GeneratedValue
    @Column(name = "pk_exercise")
    private long id;
    private String name;

    private int repCount;
    private int lapTime;
    private int lapBreakTime;
    private int startCountdown;

    public Exercise() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRepCount() {
        return repCount;
    }

    public void setRepCount(int repCount) {
        this.repCount = repCount;
    }

    public int getLapTime() {
        return lapTime;
    }

    public void setLapTime(int lapTime) {
        this.lapTime = lapTime;
    }

    public int getLapBreakTime() {
        return lapBreakTime;
    }

    public void setLapBreakTime(int lapBreakTime) {
        this.lapBreakTime = lapBreakTime;
    }

    public int getStartCountdown() {
        return startCountdown;
    }

    public void setStartCountdown(int startCountdown) {
        this.startCountdown = startCountdown;
    }
}

