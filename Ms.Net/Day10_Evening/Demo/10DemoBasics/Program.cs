namespace _10DemoBasics
{
    public class Program
    {
        static void Main(string[] args)
        {
            #region UnComment for Structure / Class Understanding

            //Person person1 = new Person();
            //person1.No = 10;
            //person1.Name = "Sachin";
            //person1.Print();

            //Person person2 = person1;
            //person2.Name = "Amit";

            //Console.WriteLine(person1.Name);
            //Console.WriteLine(person2.Name);

            #endregion

            #region Enum
            //Branch branch = new Branch();//Branch Mechanical

            //Branch branch = Branch.Civil;

            //Console.WriteLine(branch);
            //Console.WriteLine(Convert.ToInt32(branch));

            #endregion

            Console.ReadLine();
        }
    }


    public enum Branch
    {
        Mechacnical = 77,
        Chemical= 44,
        IT = 4,
        CS=7,
        Civil,
        ENTC
    }


    #region Struct

    //public struct Person
    //{
    //    private int _No;
    //    private string _Name;

    //    public string Name
    //    {
    //        get { return _Name; }
    //        set { _Name = value; }
    //    }
    //    public int No
    //    {
    //        get { return _No; }
    //        set { _No = value; }
    //    }


    //    public void Print()
    //    {
    //        Console.WriteLine(No.ToString() + Name);
    //    }

    //}
    #endregion

    #region Class
    //public class Person
    //{
    //    private int _No;
    //    private string _Name;

    //    public string Name
    //    {
    //        get { return _Name; }
    //        set { _Name = value; }
    //    }
    //    public int No
    //    {
    //        get { return _No; }
    //        set { _No = value; }
    //    }


    //    public void Print()
    //    {
    //        Console.WriteLine(No.ToString() + Name);
    //    }

    //}
    #endregion



}
