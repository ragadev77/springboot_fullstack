package test.app.konsumen.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.app.konsumen.Models.*;

@Repository
public interface KonsumenRepository extends JpaRepository<Konsumen, Integer> {
    
}
