package calculator;

public class Calculator implements ICalculator{
	float result ;
	@Override
	public int add(int x, int y) {
		return x + y;
	}

	@Override
	public float divide(int x, int y) {
		return ((float) x /(float) y);
	}

}
