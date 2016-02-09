import java.util.ArrayList;
import java.util.List;

// SAM Interface
@FunctionalInterface
interface X
{
	void show();
	//void disp();
}
interface W
{
	int add(int x, int y);
}
/*class Y implements X{
	@Override
	public void show(){
		System.out.println("Y Show");
	}
}*/
public class InterfaceUse {
static void evenOdd(int i){
	if(i%2==0){
		System.out.println("Even "+i);
	}
	else
	{
		System.out.println("Odd "+i);
	}
}
	public static void main(String[] args) {
		/*Y obj = new Y();
		obj.show();
*/
		// class ___ implements X{ }
		X obj = new X(){
			@Override
			public void show(){
				System.out.println("Y Show");
			}
		};
		obj.show();
		// Java 8 Style
		X obj2 =()->System.out.println("Lambda Show");
		X obj3 =()->{
			System.out.println("******************");
			System.out.println("Lambda Show");
		};
		obj2.show();
		W obj4 = (a,b)->a+b;
		System.out.println(obj4.add(100,200));
		List<Integer> list  = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(3);
		System.out.println(list);
		list.add(1000);
		list.add(2000);
		System.out.println(list);
		list.remove(0);
		System.out.println(list);
		for(int i =0 ; i<list.size(); i++){
			if(list.get(i)%2==0){
				System.out.println("Even "+list.get(i));
			}
			else
			{
				System.out.println("Odd "+list.get(i));
			}
			//System.out.println(list.get(i));
		}
		// Java 5
		for(int i : list){
			InterfaceUse.evenOdd(i);
		}
		// Java 8
		list.forEach(InterfaceUse::evenOdd);
		
		
		
	}

}
