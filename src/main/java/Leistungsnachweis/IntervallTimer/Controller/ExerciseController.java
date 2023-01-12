package Leistungsnachweis.IntervallTimer.Controller;

import Leistungsnachweis.IntervallTimer.DataTransfer.ExerciseDto;
import Leistungsnachweis.IntervallTimer.Logic.ExerciseLogic;
import Leistungsnachweis.IntervallTimer.Response.Base.BaseControllerResponse;
import Leistungsnachweis.IntervallTimer.Response.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(path = "exercise")
public class ExerciseController implements IBaseController<ExerciseDto> {
    private final ExerciseLogic exerciseLogic;

    @Autowired
    public ExerciseController(ExerciseLogic exerciseLogic) {
        this.exerciseLogic = exerciseLogic;
    }

    @PostMapping("get/{id}")
    public BaseControllerResponse<ExerciseDto> get(@PathParam("id") long id) {
        return null;
    }

    @GetMapping("getAll")
    public BaseControllerResponse<ExerciseDto> getAll() {
        BaseControllerResponse<ExerciseDto> response = new BaseControllerResponse<>();
        try{
            response.listResponse = this.exerciseLogic.getAll();
        }
        catch(Exception e) {
            response.message = e.getMessage();
            response.responseType = ResponseType.FAIL;
        }
        finally{
            if(response.responseType == ResponseType.INITIALIZED) {
                response.responseType = ResponseType.SUCCESSFUL;
                response.message = "Erfolgreich geladen";
            }
        }
        return response;
    }

    @PostMapping("newExercise")
    public BaseControllerResponse<ExerciseDto> save(@RequestBody ExerciseDto exerciseDto) {
        BaseControllerResponse<ExerciseDto> response = new BaseControllerResponse<>();
        try{
            response.singleResponse = this.exerciseLogic.save(exerciseDto);
        }
        catch(Exception e) {
            response.message = e.getMessage();
            response.responseType = ResponseType.FAIL;
        }
        finally{
            if(response.responseType == ResponseType.INITIALIZED) {
                response.responseType = ResponseType.SUCCESSFUL;
                response.message = "Erfolgreich gespeichert";
            }
        }
        return response;
    }

    @PostMapping("delete")
    public BaseControllerResponse<ExerciseDto> delete(@RequestBody long id) {
        BaseControllerResponse<ExerciseDto> response = new BaseControllerResponse<>();
        try{
            this.exerciseLogic.delete(id);
        }
        catch(Exception e) {
            response.message = e.getMessage();
            response.responseType = ResponseType.FAIL;
        }
        finally{
            if(response.responseType == ResponseType.INITIALIZED) {
                response.responseType = ResponseType.SUCCESSFUL;
                response.message = "Erfolgreich gelöscht";
            }
        }
        return response;
    }
}
