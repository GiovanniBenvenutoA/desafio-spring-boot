package cl.tecnova.ms.repository;


import cl.tecnova.ms.entities.StatusTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusTaskRepository extends JpaRepository<StatusTask, Long> {
}
