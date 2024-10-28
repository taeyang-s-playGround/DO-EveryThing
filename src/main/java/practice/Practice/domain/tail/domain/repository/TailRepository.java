package practice.Practice.domain.tail.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.Practice.domain.tail.domain.Tail;

public interface TailRepository extends JpaRepository<Tail, Long> {
}
