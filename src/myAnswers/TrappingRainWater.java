package myAnswers;
import java.util.ArrayList;

public class TrappingRainWater {
	
	public static int trap(int[] height) {
		
		// first check whether the elevation map is able to hold rain water or not
		if (height.length == 0 || height.length == 1 || height.length == 2 || getMax(height) == 0) {
			return 0;
		}
		
		int trappedRain = 0;
		final int min = getMin(height);
		final int max = getMax(height);
		for (int bottom = min; bottom <= max; bottom++) {
			
			ArrayList<Integer> minIndex = getTargetIndex(height, bottom);
			ArrayList<Integer> toAdd = getIndex(height, bottom);
			
			if (minIndex.size() == height.length) {
				// no remaining bar can trap water
				break;
			}
			trappedRain += minIndex.size();
			
			if (toAdd.size() > 0) {
				for (int i = 0; i < toAdd.size(); i++) {
					height[toAdd.get(i)]++;
				}
			}
		}
		return trappedRain;
	}

	public static int getMax(int[] array) {
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}
	
	public static int getMin(int[] array) {
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}
	
	public static ArrayList<Integer> getIndex(int[] array, int target) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				result.add(i);
			}
		}
		return result;
	}
	
	// make sure to get rid of all mins in head and in tail
	public static ArrayList<Integer> getTargetIndex(int[] array, int target) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		// get left valid bound
		int leftValid = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != target) {
				leftValid = i;
				break;
			}
		}
		// get right valid bound
		int rightValid = array.length - 1;
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] != target) {
				rightValid = i;
				break;
			}
		}
		// get all target in between leftValid and rightValid
		for (int i = leftValid; i <= rightValid; i++) {
			if (array[i] == target) {
				result.add(i);
			}
		}
		return result;
	}

}
