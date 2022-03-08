package org.insurance.utils;

public class Utility {
	public static Double calcPremium(Double basePremium, int minage, int currentage, 
			int surgeyrs, Double surgeage, String smoking
			, Double smokingsurge, String drinking, Double drinkingsurge, String illness, Double illnesssurge) {
		
		Double agePremium = 0.0;
		Double smokingPremium = 0.0;
		Double drinkingPremium = 0.0;
		Double illnessPremium = 0.0;
		// age calculation
		if(currentage > minage) {
			
			agePremium = basePremium * (((int)Math.round((double)(currentage - minage) / surgeyrs) * surgeage) / 100) ;
		}
		// smoking surge calculation
		if("Yes".equals(smoking)) {
			smokingPremium = basePremium * (smokingsurge / 100);
		}
		
		// drinking surge calculation
		if("Yes".equals(drinking)) {
			drinkingPremium = basePremium * (drinkingsurge / 100);
		}
		
		// illness surge calculation
		if("Yes".equals(illness)) {
			illnessPremium = basePremium * (illnesssurge / 100);
		}
		
		
		return (basePremium + agePremium + smokingPremium + drinkingPremium + illnessPremium);
	}
	public static void main(String[] args) {
		System.out.println(calcPremium(10000.0, 20, 24, 10, 5.0, "No", 5.0, "Yes", 5.0, "No", 5.0));
	}
}
