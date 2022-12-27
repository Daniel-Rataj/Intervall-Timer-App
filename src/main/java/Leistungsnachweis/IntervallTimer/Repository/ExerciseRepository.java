package Leistungsnachweis.IntervallTimer.Repository;

import Leistungsnachweis.IntervallTimer.DataAccess.Exercise;
import org.springframework.data.repository.CrudRepository;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
}
