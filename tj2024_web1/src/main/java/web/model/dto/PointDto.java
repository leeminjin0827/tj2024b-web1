package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 롬북을 활용한 DTO 구성
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString

public class PointDto {
	
	private int pno;
	private String pdetail;
	private int mpoint;
	private String pdate;
	private int mno;
	
} // c end
