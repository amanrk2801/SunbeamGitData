namespace _06DemoDelegate
{
    delegate bool MyDelegate(int i);
    internal class Program
    {
        static void Main(string[] args)
        {
            ////Direct call to Check
            //bool result = Check(20);
            //Console.WriteLine(result);

            MyDelegate pointer = new MyDelegate(Check);
            bool result = pointer(20);
            Console.WriteLine(result);

            Console.ReadLine();
        }

        public static bool Check(int i)
        {
            return (i > 10);
           //if (i > 10) 
           // {
           //     return true;
           // }
           //else
           // {
           //     return false;
           // }
        }
    }
}
