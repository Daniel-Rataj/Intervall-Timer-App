package Leistungsnachweis.IntervallTimer.Logic;


import Leistungsnachweis.IntervallTimer.Data.Exercise;
import Leistungsnachweis.IntervallTimer.Response.Base.BaseControllerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseLogic implements IBaseLogic<Exercise> {

    public Exercise get(long id) {
        return null;
    }

    public List<Exercise> getAll() {
        return List.of(
                new Exercise(0, "Boxsack-Intervall", 3, 20, 0, 5),
                new Exercise(1, "Head Movement", 5, 120, 30, 5)
        );
    }

    public BaseControllerResponse save(Exercise dto) {
        return null;
    }

    public BaseControllerResponse delete(long id) {
        return null;
    }
}
