package Leistungsnachweis.IntervallTimer.Logic;

import Leistungsnachweis.IntervallTimer.Response.Base.BaseControllerResponse;

import java.util.List;

public interface IBaseLogic<T> {
    T get(long id);
    List<T> getAll();
    BaseControllerResponse save(T dto);
    BaseControllerResponse delete(long id);
}
