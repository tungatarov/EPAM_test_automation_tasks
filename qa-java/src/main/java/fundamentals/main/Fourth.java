package fundamentals.main;

class Fourth {

	/* 4. Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль. */
	 	public static void main(String[] args) {
				int sum = 0; 
				int com = 1; 
				for(int i = 0; i < args.length; i++) {
					 	sum += Integer.parseInt(args[i]);
					 	com *= Integer.parseInt(args[i]);
				}
			System.out.println("sum: " + sum);
			System.out.println("composition: "+ com);
		}
}