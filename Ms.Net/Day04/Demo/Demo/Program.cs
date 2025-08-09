

using System;
using MathsLib;
namespace Demo
{
    public class Program
    {
        static void Main(string[] args)
        {
            //int i = 100;
            //Console.WriteLine("Hello C#");
            //Console.ReadLine();

            Console.WriteLine("Enter value for X");
            string xValue = Console.ReadLine();

            Console.WriteLine("Enter value for Y");
            string yValue = Console.ReadLine();



            Maths obj = new Maths();

            int x = Convert.ToInt32(xValue);
            int y = Convert.ToInt32(yValue);
            int result = obj.Add(x, y);
            Console.WriteLine(result);
            Console.ReadLine();

        }
    }
}
