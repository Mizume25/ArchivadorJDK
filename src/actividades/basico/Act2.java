package actividades.basico;

public class Act2 {

	public static void main(String[] args) {
		
		System.out.println("OPERADORES ARITMETICO-LÓGICOS");
		
		/*OPERADOR: + - * / "%" -->  Resto*/
		
		int a;
		int b;
		
		a = 7;
		b = 8;
		
		//EXPRESION AIRTMETICA
		System.out.println((a + b) + (a - b) + (a * b) + (a / b) + (a % b));
		
		/* (a + b) + (a - b) + (a * b) + (a / b) + (a % b)
		= 15 + (-1) + 56 + 0 + 7
		= 15 - 1 + 56 + 0 + 7
		= 14 + 56 + 0 + 7
		= 70 + 0 + 7
		= 70 + 7
		= 77
		 * */
		
		
		System.out.println("OPERADORES ARITMETICO-ASGINATIVOS");
		
		/*OPERADOR: +=X  -=X *=X /=X  %=X  */
		
		int c;
		int d;
		
		d = 7;
		c = 8;
		
		//EXPRESION AIRTMETICA
		System.out.println((c+=d) + (c -= d) + (c *= d) + (c /= d) + (c %= d));
		
		/* (c+=b) + (c -= b) + (c *= d) + (c /= d) + (c %= d)
		 * 
		1. (c += d) → c = 8 + 7 = 15, 
		2. (c -= d) → c = 15 - 7 = 8, 
		3. (c *= d) → c = 8 * 7 = 56, 
		4. (c /= d) → c = 56 / 7 = 8, 
		5. (c %= d) → c = 8 % 7 = 1
		SUMA TOTAL: 15 + 8 + 56 + 8 + 1 = 88*/
		
		System.out.println("OPERADORES ARITMETICO-UNITARIO");
		
		/*OPERADOR: ++X/X++ --X/X-- */
		
		int e;
		int f;
		
		e = 10;
		f = 15;
		
		//EXPRESION AIRMETICA
		System.out.println((++e) + (e++) + (--f) + (f--));
		
		/* OPERACIÓN:
		1. (++e)  → e = 10+1 = 11 → valor: 11
		2. (e++)  → usa e=11 → valor: 11 → luego e = 11+1 = 12
		3. (--f)  → f = 15-1 = 14 → valor: 14
		4. (f--)  → usa f=14 → valor: 14 → luego f = 14-1 = 13
		
		SUMA: 11 + 11 + 14 + 14 = 50
		*/
		
		
		
		
		
		
	}

}
