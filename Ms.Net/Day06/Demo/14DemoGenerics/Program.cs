namespace _14DemoGenerics
{
    //public delegate bool SomeDelegate(int k);

    public delegate Q SomeDelegate<P,Q>(P k);
    //public delegate void SomeDelegate<P, Q>(P p, Q q);
    //public delegate R SomeDelegate<P, Q,R>(P k, Q q, R r);
    //public delegate S SomeDelegate<P, Q,R,S>(P k, Q q, R r, S s);
    //public delegate T SomeDelegate<P, Q,R,S, T>(P k, Q q, R r, S s, T t);
    internal class Program
    {
        static void Main(string[] args)
        {
            #region Option 1: Normal Swap Code Called

            //int p = 100;
            //int q = 200;
            //Console.WriteLine("Before Swap p = {0}, q = {1}", p, q);

            //Maths maths1 = new Maths();
            //maths1.Swap(ref p, ref q);

            //Console.WriteLine("After Swap p = {0}, q = {1}", p, q);


            //string s1 = "Hello";
            //string s2 = "World";
            //Console.WriteLine("Before Swap s1 = {0}, s2 = {1}", s1, s2);

            //Maths maths2 = new Maths();
            //maths2.Swap(ref s1, ref s2);

            //Console.WriteLine("After Swap s1 = {0}, s2 = {1}", s1, s2);
            #endregion

            #region Option 2: Simple Generic Method Call in Generic Class

            //int p = 100;
            //int q = 200;
            //Console.WriteLine("Before Swap p = {0}, q = {1}", p, q);

            //Maths<int> maths1 = new Maths<int>();
            //maths1.Swap(ref p, ref q);

            //Console.WriteLine("After Swap p = {0}, q = {1}", p, q);


            //string s1 = "Hello";
            //string s2 = "World";
            //Console.WriteLine("Before Swap s1 = {0}, s2 = {1}", s1, s2);

            //Maths<string> maths2 = new Maths<string>();
            //maths2.Swap(ref s1, ref s2);

            //Console.WriteLine("After Swap s1 = {0}, s2 = {1}", s1, s2);

            #endregion

            #region Option 3: (Non)/Generic,Method Call inNormal Class


            //Maths maths1 = new Maths();

            ////Call normal method
            //maths1.SayHi("Mahesh");

            //int p = 100;
            //int q = 200;
            //Console.WriteLine("Before Swap p = {0}, q = {1}", p, q);

            ////Call generic method
            //maths1.Swap<int>(ref p, ref q);

            //Console.WriteLine("After Swap p = {0}, q = {1}", p, q);



            #endregion

            #region Unsafe Code

            //unsafe
            //{
            //    int* ptr;
            //}

            #endregion

            #region Option 4: 

            //SpecialMaths<int, string, bool, short> obj = 
            //    new SpecialMaths<int, string, bool, short>();

            //short result =
            //    obj.NonsenseMethod(10, "abc", true, 1);

            //Console.WriteLine(result);

            //string s1 = "Hello";
            //string s2 = "World";
            //Console.WriteLine("Before Swap s1 = {0}, s2 = {1}", s1, s2);

            //obj.Swap(ref s1, ref s2);

            //Console.WriteLine("After Swap s1 = {0}, s2 = {1}", s1, s2);

            #endregion

            #region Delegate, Generic Delegate, FUNC
            /////Using normal delegate
            //SomeDelegate pointer = new SomeDelegate(Check);
            //bool result = Check(20);

            /////Using generic delegate
            //SomeDelegate<int, bool> pointer =
            //    new SomeDelegate<int, bool>(Check);

            /////Using generic delegate FUNC
            //Func<int, bool> pointer = new Func<int, bool>(Check);


            //bool result = pointer(20);
            //Console.WriteLine(result);
            #endregion

            Console.ReadLine();
        }

        public static bool Check(int i)
        {
            return (i > 10);
        }
    }



    #region Option 4
    //public class Maths<T>
    //{
    //    public void Swap(ref T x, ref T y)
    //    {
    //        T z = x;
    //        x = y;
    //        y = z;
    //    }
    //}

    ////Non Generic class inheriting from Generic Class - with hard coded geenric parameter i.e. T as integer
    ////public class SpecialMaths: Maths<int>

    ////Generic class inheriting from Generic Class - with generic parameter of current derived class passed to base generic class 
    //public class SpecialMaths<P, Q, R, S> : Maths<Q>
    //{
    //    public S NonsenseMethod(P p, Q q, R r, S s)
    //    {
    //        //Some logic
    //        return s;
    //    }
    //}

    #endregion

    #region Option 3
    //public class Maths
    //{
    //    public void Swap<T>(ref T x, ref T y)
    //    {
    //        T z = x;
    //        x = y;
    //        y = z;
    //    }

    //    public void SayHi(string name)
    //    {
    //        Console.WriteLine("Hi " + name);
    //    }
    //}
    #endregion

    #region Option 2
    //public class Maths<T>
    //{
    //    public void Swap(ref T x, ref T y)
    //    {
    //        T z = x;
    //        x = y;
    //        y = z;
    //    }
    //}
    #endregion

    #region Option 1 

    //public class Maths
    //{
    //    public void Swap(ref int x, ref int y)
    //    {
    //        int z = x;
    //        x = y;
    //        y = z;
    //    }
    //    public void Swap(ref string x, ref string y)
    //    {
    //        string z = x;
    //        x = y;
    //        y = z;
    //    }

    //}


    //public class Maths
    //{
    //    public void Swap(ref int x , ref int y)
    //    {
    //        int z = x;
    //        x = y;
    //        y = z;
    //    }
    //}
    #endregion
}
