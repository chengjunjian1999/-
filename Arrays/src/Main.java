
public class Main {
	public static void main(String[] args) {
		Array arr = new Array();
		arr.addFirst(1);
		arr.addFirst(2);
		arr.add(0, 4);
		System.out.println(arr);
		arr.removeFirst();
		System.out.println(arr);
	
	}
}
