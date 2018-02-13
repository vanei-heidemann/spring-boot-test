package test.city;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDAO extends JpaRepository<City, String> {
    Page<City> findAll(Pageable pageable);
}
