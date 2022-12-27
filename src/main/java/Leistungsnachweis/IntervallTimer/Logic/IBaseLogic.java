package Leistungsnachweis.IntervallTimer.Logic;

import Leistungsnachweis.IntervallTimer.DataTransfer.ExerciseDto;
import Leistungsnachweis.IntervallTimer.Response.Base.BaseControllerResponse;

import java.util.List;

public interface IBaseLogic<T> {
    T get(long id);
    List<T> getAll();
    ExerciseDto save(T dto);
    void delete(long id);
}
