package Calculator;

public class CalculatorTest {

	public static void main(String[] args) {
		String expressString = "( ( 10 ) ) x -2 + 3 - 4 / 2";
		Calculator calc = new Calculator();
        System.out.println(calc.calculate(expressString));
	}

}
