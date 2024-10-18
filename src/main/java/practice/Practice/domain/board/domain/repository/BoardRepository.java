package practice.Practice.domain.board.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.Practice.domain.board.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
