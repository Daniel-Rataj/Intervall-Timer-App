package Leistungsnachweis.IntervallTimer.Controller;

import Leistungsnachweis.IntervallTimer.Data.Exercise;
import Leistungsnachweis.IntervallTimer.Logic.ExerciseLogic;
import Leistungsnachweis.IntervallTimer.Response.Base.BaseControllerResponse;
import Leistungsnachweis.IntervallTimer.Response.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(path = "exercise")
public class ExerciseController implements IBaseController<Exercise> {
    private final ExerciseLogic exerciseLogic;

    @Autowired
    public ExerciseController(ExerciseLogic exerciseLogic) {
        this.exerciseLogic = exerciseLogic;
    }

    @PostMapping("exercises/{id}")
    public BaseControllerResponse get(@PathParam("id") long id) {
        return null;
    }

    @GetMapping("allExercises")
    public BaseControllerResponse getAll() {
        BaseControllerResponse response = new BaseControllerResponse();
        try{
            response.listResponse = this.exerciseLogic.getAll();
        }
        catch(Exception e) {
            response.message = e.getMessage();
            response.responseType = ResponseType.FAIL;
        }
        finally{
            return response;
        }
    }

    public BaseControllerResponse save(Exercise newExercise) {
        return null;
    }

    public BaseControllerResponse delete(long id) {
        return null;
    }
}
