using System;
using System.Collections;
using System.Text;

namespace _13DemoCollection
{
    internal class Program
    {
        static void Main(string[] args)
        {
            #region Emp objects declared / defined

            Emp emp1 = new Emp();
            emp1.No = 1;
            emp1.Name = "Jayesh";
            emp1.Address = "Karad";
            emp1.EMail = "j@a.com";

            Emp emp2 = new Emp();
            emp2.No = 2;
            emp2.Name = "Shailesh";
            emp2.Address = "Kolhapur";
            emp2.EMail = "s@a.com";

            Emp emp3 = new Emp();
            emp3.No = 3;
            emp3.Name = "Shri";
            emp3.Address = "Mumbai";
            emp3.EMail = "sh@a.com";


            #endregion

            #region Int Array of Limited Size

            ////int[] arr = new int[3];
            ////arr[0] = 99;
            ////arr[1] = 22;
            ////arr[2] = 55;
            ////arr[3] = 30;//This is where out of bound exception is given

            //int[] arr = new int[] { 10,20,30,40,50 };

            //for (int i = 0; i < arr.Length; i++)
            //{
            //    Console.WriteLine(arr[i]);
            //}


            #endregion

            #region Emp Array of Limited Size
            //Emp[] arr = new Emp[3];
            //arr[0] = emp1;
            //arr[1] = emp2;
            //arr[2] = emp3;

            //for (int i = 0; i < arr.Length; i++)
            //{
            //    Emp emp = arr[i];
            //    //Console.WriteLine(emp.No.ToString() + emp.Name + emp.Address);
            //    Console.WriteLine(emp.ToString());
            //}
            #endregion

            #region Boxing, UnBoxing, String Usage
            //Below - Both string declaration are same 
            //We use the second one heavily!

            //String str = new String(new Char['a', 'b','c'])
            //string str = "abc";

            //int i = 99;     //Stack
            //object obj = i; //Heap : Boxing
            //if (obj is int)
            //{
            //    int j = Convert.ToInt32(obj); // UnBoxing
            //    Console.WriteLine(j);
            //}
            #endregion

            #region Limited Size with Casting / Boxing / UnBoxing

            //object[] arr = new object[5];
            //arr[0] = emp1;
            //arr[1] = 100;
            //arr[2] = "abcd";
            //arr[3] = emp2;
            //arr[4] = DateTime.Now;


            //for (int i = 0; i < arr.Length; i++)
            //{
            //    object obj = arr[i];
            //    if (obj is int)
            //    {
            //        int data = Convert.ToInt32(obj);
            //        Console.WriteLine(data);
            //    }
            //    else if (obj is string) 
            //    {
            //        string str = Convert.ToString(obj);
            //        Console.WriteLine(str);
            //    }
            //    else if (obj is Emp)
            //    {
            //        Emp emp = (Emp)obj;
            //        Console.WriteLine(emp.ToString());
            //    }
            //    else
            //    {
            //        Console.WriteLine("Unknown type of data found!");
            //    }
            //}

            #endregion

            #region No Limit Object Array Casting / Boxing / UnBoxing

            //ArrayList arr = new ArrayList();
            //arr.Add(emp1);
            //arr.Add(100);
            //arr.Add("abcd");
            //arr.Add(emp2);
            //arr.Add(DateTime.Now);
            //arr.Add(emp3);

            //for (int i = 0; i < arr.Count; i++)
            //{
            //    object obj = arr[i];
            //    if (obj is int)
            //    {
            //        int data = Convert.ToInt32(obj);
            //        Console.WriteLine(data);
            //    }
            //    else if (obj is string)
            //    {
            //        string str = Convert.ToString(obj);
            //        Console.WriteLine(str);
            //    }
            //    else if (obj is Emp)
            //    {
            //        Emp emp = (Emp)obj;
            //        Console.WriteLine(emp.ToString());
            //    }
            //    else
            //    {
            //        Console.WriteLine("Unknown type of data found!");
            //    }
            //}

            #endregion

            #region Problem with ArrayList
            //ArrayList arr = new ArrayList();

            //arr.Add(emp1);
            //arr.Add(emp2);
            //arr.Add(emp3);

            //Console.WriteLine("Enter EMail to search");
            //string email = Console.ReadLine();  

            //foreach (object obj in arr)
            //{
            //    Emp emp = (Emp)obj;

            //    if (emp.EMail.ToLower() == email.ToLower())
            //    {
            //        Console.WriteLine(emp.ToString());
            //        break;
            //    }
            //}
            #endregion

            #region Hashtable 
            //Hashtable arr = new Hashtable();

            //arr.Add(emp1.EMail.ToLower(), emp1);
            //arr.Add(emp2.EMail.ToLower(), emp2);
            //arr.Add(emp3.EMail.ToLower(), emp3);

            //Console.WriteLine("Enter EMail to search");
            //string email = Console.ReadLine();

            //object filteredEmp = arr[email.ToLower()];

            //if (filteredEmp != null)
            //{
            //    Emp emp = (Emp)filteredEmp;
            //    Console.WriteLine(emp.ToString());
            //}
            //else
            //{
            //    Console.WriteLine("Object not found");
            //}
            #endregion

            #region Generic List<Emp>
            //List<Emp> arr = new List<Emp>();
            //arr.Add(emp1);
            //arr.Add(emp2);
            //arr.Add(emp3);

            #region Iterate Through Generic List<Emp>

            //foreach (Emp emp in arr)
            //{
            //    Console.WriteLine(emp.ToString());
            //}

            #endregion

            #region Problem with List<T>
            //Console.WriteLine("Enter EMail to search");
            //string email = Console.ReadLine();

            //foreach (Emp emp in arr)
            //{
            //    if (emp.EMail.ToLower() == email.ToLower())
            //    {
            //        Console.WriteLine(emp.ToString());
            //        break;
            //    }
            //}
            #endregion
            #endregion

            #region Stack<Emp>

            //Stack<Emp> arr = new Stack<Emp>();
            //arr.Push(emp1);
            //arr.Push(emp2);
            //arr.Push(emp3);

            #region Iterate Through Generic Stack<Emp>

            //foreach (Emp emp in arr)
            //{
            //    Console.WriteLine(emp.ToString());
            //}

            #endregion


            #endregion

            #region Queue<Emp>

            //Queue<Emp> arr = new Queue<Emp>();
            //arr.Enqueue(emp1);
            //arr.Enqueue(emp2);
            //arr.Enqueue(emp3);

            #region Iterate Through Generic Queue<Emp>

            //foreach (Emp emp in arr)
            //{
            //    Console.WriteLine(emp.ToString());
            //}

            #endregion


            #endregion

            #region Generic Dictionary<string, Emp>
            //Dictionary<string, Emp> arr = new Dictionary<string, Emp>();
            //arr.Add(emp1.EMail.ToLower() ,emp1);
            //arr.Add(emp2.EMail.ToLower(), emp2);
            //arr.Add(emp3.EMail.ToLower(), emp3);


            //#region Problem with List<T>
            //Console.WriteLine("Enter EMail to search");
            //string email = Console.ReadLine();

            //Emp emp = arr[email.ToLower()];
            //Console.WriteLine(emp.ToString());
           
          
          
            #endregion
            



        }
    }

    public class Emp
    {
        private int _No;
        private string _Name;
        private string _Address;

        public string Address
        {
            get { return _Address; }
            set { _Address = value; }
        }

        private string _Email;

        public string EMail
        {
            get { return _Email; }
            set { _Email = value; }
        }


        public string Name
        {
            get { return _Name; }
            set { _Name = value; }
        }

        public int No
        {
            get { return _No; }
            set { _No = value; }
        }

        public override string ToString()
        {
            #region Issues with "+" with string
            ////Avoid using  + + for concat - not a good practise because string is immutable
            //// Every "+" for strings creates a new string
            //// earlier object will be put for deletion

            //Instead can we have string buffer like functionality?

            //return this.No.ToString() + this.Name + this.Address;
            #endregion

            #region Using Stringbuilder: Poor readability
            //StringBuilder builder = new StringBuilder();
            //builder.Append(this.No);
            //builder.Append(this.Name);
            //builder.Append(this.Address);

            //return builder.ToString();
            #endregion

            #region Use String.Format

            //string format = 
            //    "ENo = {0}, EName = {1}, City = {2}";

            //string details = string.Format(format, this.No, this.Name, this.Address);

            //return details;

            return string.Format("ENo = {0}, EName = {1}, City = {2}", this.No, this.Name, this.Address);

            #endregion

        }

    }
}
