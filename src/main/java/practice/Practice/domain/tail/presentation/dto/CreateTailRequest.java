package practice.Practice.domain.tail.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateTailRequest {

    private Long userId;

    private String tailName;

    private double length;
}
