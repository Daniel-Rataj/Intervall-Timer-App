package Leistungsnachweis.IntervallTimer.Controller;
import Leistungsnachweis.IntervallTimer.Response.Base.BaseControllerResponse;

public interface IBaseController<T> {
    BaseControllerResponse get(long id);
    BaseControllerResponse getAll();
    BaseControllerResponse save(T dto);
    BaseControllerResponse delete(long id);
}
