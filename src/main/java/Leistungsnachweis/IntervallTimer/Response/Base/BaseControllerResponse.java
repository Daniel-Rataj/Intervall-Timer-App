package Leistungsnachweis.IntervallTimer.Response.Base;


import Leistungsnachweis.IntervallTimer.Data.Exercise;
import Leistungsnachweis.IntervallTimer.Response.ResponseType;

import java.util.List;

public class BaseControllerResponse<T> {
    public ResponseType responseType = ResponseType.INITIALIZED;
    public String message = null;
    public T singleResponse = null;
    public List<T> listResponse = null;
}
