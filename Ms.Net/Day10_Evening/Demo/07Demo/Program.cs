namespace _07Demo
{
    internal class Program
    {
        static void Main(string[] args)
        {
            A a = new A();
            B b = new B();

            MyDelegate pointer = new MyDelegate(b.M2);

            a.M1(pointer);
            Console.ReadLine();
        }
    }

    public delegate void MyDelegate();
    public class A
    {
        public void M1(MyDelegate pointer)
        {
            // Call B's M2 method here.
            // Conditions:
            //1. You will not create B's object here.
            //2. You will not have B or
            //   Object type or String parameter in A.M1
            // 3. M2 will not be static
            pointer();
        }
    }
    public class B
    {
        public void M2()
        {
            Console.WriteLine("This is B's M2 Method");
        }
    }


}
