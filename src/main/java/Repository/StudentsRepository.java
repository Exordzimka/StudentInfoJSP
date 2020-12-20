package Repository;

import Models.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long>, JpaSpecificationExecutor<Students>
{
    ArrayList<Students> findByName(String name);
}