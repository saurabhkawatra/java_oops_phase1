
class demo1 {

	public static void main(String[] args) {
		System.out.println("Welcome to java....");
            System.out.println("welcome again");
	}
}
class demo2 {
	public static void main(String[] args)
	{
		System.out.println("this is main of demo2");
		demo1 de1=new demo1();
		System.out.println("demo1 object created from class demo2 main");
		demo de = new demo();
		
	}
}
class demo {   
    static int a, b;    
public static void main(int args) {
    System.out.println("Using demo class Main with int arg");
    a =30;
    b =40;
    System.out.println("Product is: "+a*b);
}
public static void main(String[] args) {
    System.out.println("Using demo class Main with string arg");
     a =10;
     b =20;
     System.out.println("Product is: "+a*b);        
} 
}       
class Anonym{
public static void main(String arg[])
{

    demo.main(1);
    demo.main(null);
}
}
