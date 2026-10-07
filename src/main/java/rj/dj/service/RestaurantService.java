package rj.dj.service;

import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import rj.dj.dto.FoodItem;

@Service
public class RestaurantService {

	public List<FoodItem> getAvailableFood() {
		System.out.println("Restuarant Service Call Execute Start...!!");
		LocalTime currentTime = LocalTime.now();

		LocalTime breakfastStart = LocalTime.of(9, 0);
		LocalTime lunchStart = LocalTime.of(12, 0);
		LocalTime lunchEnd = LocalTime.of(18, 0);
		LocalTime dinnerStart = LocalTime.of(18, 0);
		LocalTime dinnerEnd = LocalTime.of(23, 0);

		// Breakfast: 9:00 AM - 12:00 PM
		if (!currentTime.isBefore(breakfastStart) && currentTime.isBefore(lunchStart)) {
			System.out.println("Restuarant Service Call (NOW BREAK-FIRST TIME) Execute End...!!");
			return getBreakfast();
		}

		// Lunch: 12:00 PM - 6:00 PM
		if (!currentTime.isBefore(lunchStart) && currentTime.isBefore(lunchEnd)) {
			System.out.println("Restuarant Service Call (NOW LUNCH TIME) Execute End...!!");
			return getLunch();
		}

		// Dinner: 6:00 PM - 11:00 PM
		if (!currentTime.isBefore(dinnerStart) && currentTime.isBefore(dinnerEnd)) {
			System.out.println("Restuarant Service Call (NOW DINNER TIME) Execute End...!!");
			return getDinner();
		}
		System.out.println("Restuarant Service Call Execute End...!!");
		return Arrays.asList();
	}

	private List<FoodItem> getBreakfast() {
		return Arrays.asList(new FoodItem(1, "Masala Dosa", "Breakfast", 80.0),
				new FoodItem(2, "Idli Sambar", "Breakfast", 60.0), new FoodItem(3, "Poori Sabji", "Breakfast", 70.0),
				new FoodItem(4, "Aloo Paratha", "Breakfast", 90.0),
				new FoodItem(5, "Paneer Sandwich", "Breakfast", 100.0), new FoodItem(6, "Veg Upma", "Breakfast", 60.0));
	}

	private List<FoodItem> getLunch() {
		return Arrays.asList(new FoodItem(101, "Veg Thali", "Lunch", 150.0),
				new FoodItem(102, "Paneer Butter Masala", "Lunch", 180.0),
				new FoodItem(103, "Dal Tadka", "Lunch", 120.0), new FoodItem(104, "Jeera Rice", "Lunch", 100.0),
				new FoodItem(105, "Chicken Biryani", "Lunch", 220.0), new FoodItem(106, "Veg Biryani", "Lunch", 160.0),
				new FoodItem(107, "Roti Basket", "Lunch", 80.0),new FoodItem(108, "Non-Veg Thali", "Lunch", 150.0));
	}

	private List<FoodItem> getDinner() {
		return Arrays.asList(new FoodItem(201, "Chicken Biryani -1", "Dinner", 220.0),
				new FoodItem(202, "Paneer Tikka", "Dinner -1", 200.0),
				new FoodItem(203, "Butter Chicken", "Dinner -1", 250.0), new FoodItem(204, "Dal Makhani", "Dinner", 150.0),
				new FoodItem(205, "Veg Fried Rice", "Dinner -1", 140.0),
				new FoodItem(206, "Chicken Tikka", "Dinner-1", 240.0), new FoodItem(207, "Garlic Naan", "Dinner", 70.0));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
