package rj.dj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItem {

	private Integer id;
	private String name;
	private String category;
	private Double price;	
}
