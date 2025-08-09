namespace _19Demo_C_Features
{
    internal class Program
    {
        static void Main(string[] args)
        {
            #region Partial Classes
            //Maths obj = new Maths();
            //Console.WriteLine(obj.Add(10, 20));
            //Console.WriteLine(obj.Sub(10, 20));
            #endregion

            #region Implicit Type
            //var v = 100;  //as good as int v = 100;
            //v = "abcd";

            //var v = new Emp();//as good as Emp v = new Emp();

            //var v;//ERR HERE

            //Console.WriteLine(v.GetType());

            #endregion

            #region Use Properties

            //Emp emp = new Emp();
            //emp.No = 100;
            //emp.Name = "Drishtyadyumnya";

            //var emp = new Emp();
            //emp.No = 100;
            //emp.Name = "Drishtyadyumnya";
            //Console.WriteLine(emp.ToString());
            #endregion

            #region Object Initializer

            //var emp = new Emp() { No = 100, Name = "Manoj" };
            //Console.WriteLine(emp.ToString());

            #endregion

            #region Object Initializer

           // var emp = new { No = 100, Name = "Manoj" };
           //emp.Name = "abcd";

            Console.WriteLine(emp.ToString());

            #endregion

            Console.ReadLine();
        }

        //public void F1(var v)
        //{

        //}
    }
    #region Emp Class
    //public class Emp
    //{
    //    #region Auto Property
    //    public int No { get; set; }
    //    public string Name { get; set; }
    //    #endregion

    //    #region Old Way of writing property
    //    //private int _No;
    //    //private string _Name;

    //    //public string Name
    //    //{
    //    //    get { return _Name; }
    //    //    set { _Name = value; }
    //    //}

    //    //public int No
    //    //{
    //    //    get { return _No; }
    //    //    set { _No = value; }
    //    //}
    //    #endregion

    //    public override string ToString()
    //    {
    //        return No + Name;
    //    }
    //}
    #endregion
}
