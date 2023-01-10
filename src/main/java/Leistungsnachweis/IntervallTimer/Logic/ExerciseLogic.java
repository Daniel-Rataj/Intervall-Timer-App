package Leistungsnachweis.IntervallTimer.Logic;


import Leistungsnachweis.IntervallTimer.DataAccess.Exercise;
import Leistungsnachweis.IntervallTimer.DataTransfer.ExerciseDto;
import Leistungsnachweis.IntervallTimer.Repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseLogic implements IBaseLogic<ExerciseDto> {

    public ExerciseLogic(ExerciseRepository exerciseRepository, EntityManager em) {
        this.exerciseRepository = exerciseRepository;
        this.em = em;
    }

    @Autowired
    private ExerciseRepository exerciseRepository;

    @PersistenceContext
    private EntityManager em;

    /**
     * Converts an Iterable-List of Exercises from the DB to a List of ExerciseDto´s
     * @param allExercises Iterable-List of Exercises from the DB
     * @return List<ExerciseDto>
     * */
    private List<ExerciseDto> convertExercisesToDtoList(Iterable<Exercise> allExercises) {
        List<ExerciseDto> result = new ArrayList<>();
        for (Leistungsnachweis.IntervallTimer.DataAccess.Exercise exercise: allExercises) {
            ExerciseDto exerciseDto = this.convertExerciseToDto(exercise);
            result.add(exerciseDto);
        }
        return result;
    }

    /**
     * Converts the Exercise object from the Database to an ExerciseDto
     * @param exercise Exercise Object from the database
     * @return ExerciseDto
     * */
    private ExerciseDto convertExerciseToDto(Exercise exercise) {
        return new ExerciseDto(
                exercise.getId(),
                exercise.getName(),
                exercise.getRepCount(),
                exercise.getLapTime(),
                exercise.getLapBreakTime(),
                exercise.getStartCountdown()
                );
    }

    /**
     * Converts an ExerciseDto to the Exercise object from the DB
     * @param exerciseDto ExerciseDto
     * @return Exercise
     * */
    private Exercise convertDtoToExercise(ExerciseDto exerciseDto) {
        Exercise dataAccessExercise = new Exercise();
        dataAccessExercise.setId(exerciseDto.getId());
        dataAccessExercise.setName(exerciseDto.getName());
        dataAccessExercise.setRepCount(exerciseDto.getRepCount());
        dataAccessExercise.setLapTime(exerciseDto.getLapTime());
        dataAccessExercise.setLapBreakTime(exerciseDto.getLapBreakTime());
        dataAccessExercise.setStartCountdown(exerciseDto.getStartCountdown());
        return dataAccessExercise;
    }

    public ExerciseDto get(long id) {
        ExerciseDto response = new ExerciseDto();
        java.util.Optional<Exercise> exercise = exerciseRepository.findById(id);
        if(exercise.isPresent()) {
            response = this.convertExerciseToDto(exercise.get());
        }
        return response;
    }

    public List<ExerciseDto> getAll() {
        /* TODO: Für Testzwecke wird hier hardcoded eine Liste zurückgegeben
        ArrayList<ExerciseDto> testListe = new ArrayList<>();

        testListe.add(new ExerciseDto(0, "test 1", 2, 5, 2, 5));
        testListe.add(new ExerciseDto(1, "test 2", 2, 30, 10, 5));
        testListe.add(new ExerciseDto(2, "test 3", 0,0,0, 0));
        return testListe;*/
        Iterable<Exercise> allExercises = this.exerciseRepository.findAll();
        return this.convertExercisesToDtoList(allExercises);
    }


    public ExerciseDto save(ExerciseDto dto) {
        Exercise exercise = convertDtoToExercise(dto);
        Exercise exerciseFromDB = this.exerciseRepository.save(exercise);
        return this.convertExerciseToDto(exerciseFromDB);
    }

    public void delete(long id) {
        this.exerciseRepository.deleteById(id);
    }
}
